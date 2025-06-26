package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.BulkOrdersPage;
import Pages.HomePage;
import utilities.BaseClass;

public class TestScenario15 extends BaseClass
{
	//@Test
	public void testcase1() 
	{
//---179
		test=extent.createTest("Verify Bulk Orders Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.BulkOrders);
		test.log(Status.INFO,"Navigate to Bulk Orders Page");
		
		switchToFrameByIndex(0);
		test.log(Status.INFO,"switch to google form");
		
		hover(bulkorderspageobject.SigninLink);
		click(bulkorderspageobject.SigninLink);
		test.log(Status.INFO,"Navigate to google signin Page");
		
		switchToChildWindow();
		test.log(Status.INFO,"switch to new window");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("accounts"));
		test.log(Status.PASS," Google signin Page is Displayed");
		
		driver.close();
		test.log(Status.INFO,"switch to new window");
		
		switchToParentWindow(parent);
		test.log(Status.INFO,"switch to Main window");
	}
	//@Test
	public void testcase2() 
	{
		//--180
		test=extent.createTest("Verify Bulk Orders Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.BulkOrders);
		test.log(Status.INFO,"Navigate to Bulk Orders Page");
		
		switchToFrameByIndex(0);
		test.log(Status.INFO,"switch to google form");
		
		hover(bulkorderspageobject.LearnMoreLink);
		click(bulkorderspageobject.LearnMoreLink);
		test.log(Status.INFO,"popup is displayed");
		
		Assert.assertEquals(true, bulkorderspageobject.popupwithoutsignin.isDisplayed());
		test.log(Status.PASS,"continue without signin button is displayed");
		Assert.assertEquals(true, bulkorderspageobject.popupwithsignin.isDisplayed());
		test.log(Status.PASS,"signin button is displayed");
		
		// -----181
		click(bulkorderspageobject.popupwithoutsignin);
		test.log(Status.INFO,"Navigate back to Google form");
	
		// -----182
		hover(bulkorderspageobject.LearnMoreLink);
		test.log(Status.PASS,"Google form is displayed");
		click(bulkorderspageobject.LearnMoreLink);
		test.log(Status.INFO,"popup is displayed");
		
		click( bulkorderspageobject.popupwithsignin);
		test.log(Status.INFO,"Navigate to google signin Page");
		
		switchToChildWindow();
		test.log(Status.INFO,"switch to new window");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("accounts"));
		test.log(Status.PASS," Google signin Page is Displayed");
		
		driver.close();
		test.log(Status.INFO,"switch to new window");
		
		switchToParentWindow(parent);
		test.log(Status.INFO,"switch to Main window");
	}
	//@Test
	public void testcase3() throws Exception 
	{ //185, 191,193, 192
		test=extent.createTest("Verify Bulk Orders Functionality - valid data and submit button").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.BulkOrders);
		test.log(Status.INFO,"Navigate to Bulk Orders Page");
		
		//switchToFrameByWebElement(bulkorderspageobject.formframe);
		switchToFrameByIndex(0);
		test.log(Status.INFO,"switch to google form");

		// for not scrolable and not viewpoint
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", bulkorderspageobject.Name);
		Thread.sleep(1000);
		hover(bulkorderspageobject.Name);

		enterData(bulkorderspageobject.Name,"John");test.log(Status.INFO,"entered name fields");
		enterData(bulkorderspageobject.PhoneNumber,"7867456786");test.log(Status.INFO,"entered phone fields");
		enterData(bulkorderspageobject.Email,"John@gmail.com");test.log(Status.INFO,"entered email fields");
		enterData(bulkorderspageobject.City,"Manchester");test.log(Status.INFO,"entered city fields");
		
		click(bulkorderspageobject.NextButton);
		test.log(Status.INFO,"switch to next page");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", bulkorderspageobject.lookingforField);
		Thread.sleep(1000);
		hover(bulkorderspageobject.lookingforField);
		
		click(bulkorderspageobject.RadioButtons.get(1));
		enterData(bulkorderspageobject.lookingforField,"test the google form");
		test.log(Status.INFO,"entered allfields");
		
		Assert.assertEquals("width: 100%;", bulkorderspageobject.ProgressBar.getAttribute("style"));
		test.log(Status.PASS,"Progress bar is full");
				
		click(bulkorderspageobject.SubmitButton);
		test.log(Status.INFO,"submited the form");
		
		Assert.assertEquals(true, bulkorderspageobject.ConfirmMessage.isDisplayed());
		test.log(Status.PASS,"Confirmation Message is Displayed");
		
	}
	//@Test
		public void testcase4() throws Exception 
		{ //186
			test=extent.createTest("Verify Bulk Orders Functionality - invalid data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
			parent = driver.getWindowHandle();
			
			click(homepageobject.BulkOrders);
			test.log(Status.INFO,"Navigate to Bulk Orders Page");
			
			//switchToFrameByWebElement(bulkorderspageobject.formframe);
			switchToFrameByIndex(0);
			test.log(Status.INFO,"switch to google form");

			// for not scrolable and not viewpoint
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", bulkorderspageobject.Name);
			Thread.sleep(1000);
			hover(bulkorderspageobject.Name);

			enterData(bulkorderspageobject.Name,"@£$3464");test.log(Status.INFO,"entered invalid data name fields");
			enterData(bulkorderspageobject.PhoneNumber,"sfjs &%7");test.log(Status.INFO,"entered invalid data phone fields");
			enterData(bulkorderspageobject.Email,"Johngmail.com");test.log(Status.INFO,"entered invalid data email fields");
			enterData(bulkorderspageobject.City,"@£$3464");test.log(Status.INFO,"entered invalid data city fields");
	
			
			click(bulkorderspageobject.NextButton);
			test.log(Status.INFO,"Error messages are displayed");
			
			Assert.assertEquals(true, bulkorderspageobject.NextButton.isDisplayed());
			test.log(Status.PASS,"Form should not proceed to next page");
			Assert.assertEquals("Please enter 10 digit valid phone number without +91", bulkorderspageobject.PhoneError.getText());
			test.log(Status.PASS,"Error Message is Displayed for Phone number Field");
			Assert.assertEquals("Please enter valid email id", bulkorderspageobject.EmailError.getText());
			test.log(Status.PASS,"Error Message is Displayed for Email Field");
	
	
		}
		
		
		//@Test
		public void testcase5() throws Exception 
		{ //187
			test=extent.createTest("Verify Bulk Orders Functionality - Null data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
					
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
			parent = driver.getWindowHandle();
					
			click(homepageobject.BulkOrders);
			test.log(Status.INFO,"Navigate to Bulk Orders Page");
					
			//switchToFrameByWebElement(bulkorderspageobject.formframe);
			switchToFrameByIndex(0);
			test.log(Status.INFO,"switch to google form");

			// for not scrolable and not viewpoint
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", bulkorderspageobject.Name);
			Thread.sleep(1000);
			hover(bulkorderspageobject.Name);

			enterData(bulkorderspageobject.Name,"");test.log(Status.INFO,"leave name field");
			enterData(bulkorderspageobject.PhoneNumber,"");test.log(Status.INFO,"leave phone field");
			enterData(bulkorderspageobject.Email,"");test.log(Status.INFO,"leave email field");
			enterData(bulkorderspageobject.City,"");test.log(Status.INFO,"leave city field");
			
					
			click(bulkorderspageobject.NextButton);
			test.log(Status.INFO,"Error messages are displayed");
					
			Assert.assertEquals(true, bulkorderspageobject.NextButton.isDisplayed());
			test.log(Status.PASS,"Form should not proceed to next page and Display Validation messages");
			
			Assert.assertEquals("This is a required question", bulkorderspageobject.NameError.getText());
			test.log(Status.PASS,"Error Message is Displayed for Name Field");
			Assert.assertEquals("This is a required question", bulkorderspageobject.PhoneError.getText());
			test.log(Status.PASS,"Error Message is Displayed for Phone number Field");
			Assert.assertEquals("This is a required question", bulkorderspageobject.EmailError.getText());
			test.log(Status.PASS,"Error Message is Displayed for Email Field");
			Assert.assertEquals("This is a required question", bulkorderspageobject.CityError.getText());
			test.log(Status.PASS,"Error Message is Displayed for City Field");
			
			
		}
		//@Test
		public void testcase6() throws Exception 
		{ //188
			test=extent.createTest("Verify Bulk Orders Functionality - Next Button").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
			parent = driver.getWindowHandle();
			
			click(homepageobject.BulkOrders);
			test.log(Status.INFO,"Navigate to Bulk Orders Page");
			
			//switchToFrameByWebElement(bulkorderspageobject.formframe);
			switchToFrameByIndex(0);
			test.log(Status.INFO,"switch to google form");

			// for not scrolable and not viewpoint
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", bulkorderspageobject.Name);
			Thread.sleep(1000);
			hover(bulkorderspageobject.Name);

			enterData(bulkorderspageobject.Name,"John");test.log(Status.INFO,"entered name fields");
			enterData(bulkorderspageobject.PhoneNumber,"7867456786");test.log(Status.INFO,"entered phone fields");
			enterData(bulkorderspageobject.Email,"John@gmail.com");test.log(Status.INFO,"entered email fields");
			enterData(bulkorderspageobject.City,"Manchester");test.log(Status.INFO,"entered city fields");
			
			click(bulkorderspageobject.NextButton);
			test.log(Status.INFO,"switch to next page");


			Assert.assertEquals("Page 2 of 2", bulkorderspageobject.Progresspage.getText());
			test.log(Status.PASS,"2nd page is displayed in the form");
		}
		
		//@Test
		public void testcase7() throws Exception 
		{ //189
			test=extent.createTest("Verify Bulk Orders Functionality - clear form Button").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
			parent = driver.getWindowHandle();
			
			click(homepageobject.BulkOrders);
			test.log(Status.INFO,"Navigate to Bulk Orders Page");
			
			//switchToFrameByWebElement(bulkorderspageobject.formframe);
			switchToFrameByIndex(0);
			test.log(Status.INFO,"switch to google form");

			// for not scrolable and not viewpoint
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", bulkorderspageobject.Name);
			Thread.sleep(1000);
			hover(bulkorderspageobject.Name);

			enterData(bulkorderspageobject.Name,"John");test.log(Status.INFO,"entered name fields");
			enterData(bulkorderspageobject.PhoneNumber,"7867456786");test.log(Status.INFO,"entered phone fields");
			enterData(bulkorderspageobject.Email,"John@gmail.com");test.log(Status.INFO,"entered email fields");
			enterData(bulkorderspageobject.City,"Manchester");test.log(Status.INFO,"entered city fields");
			
			click(bulkorderspageobject.ClearFormButton);
			test.log(Status.INFO,"initiate clear all fields");
			
			click(bulkorderspageobject.PopupcancelButton);
			test.log(Status.INFO,"initiate clear all fields is canceled");
			
			Thread.sleep(1000);
			
			click(bulkorderspageobject.ClearFormButton);
			test.log(Status.INFO,"initiate clear all fields");
			
			click(bulkorderspageobject.PopupClearFormButton);
			test.log(Status.INFO," finished clear all fields in form");
			
			Assert.assertEquals("", bulkorderspageobject.Name.getAttribute("value"));
			test.log(Status.PASS, "All fields are cleared");
	
			
		}
		
		@Test
		public void testcase8() throws Exception 
		{ //190
			test=extent.createTest("Verify Bulk Orders Functionality - Back Button").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			BulkOrdersPage bulkorderspageobject=PageFactory.initElements(driver, BulkOrdersPage.class);
			parent = driver.getWindowHandle();
			
			click(homepageobject.BulkOrders);
			test.log(Status.INFO,"Navigate to Bulk Orders Page");
			
			//switchToFrameByWebElement(bulkorderspageobject.formframe);
			switchToFrameByIndex(0);
			test.log(Status.INFO,"switch to google form");

			// for not scrolable and not viewpoint
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", bulkorderspageobject.Name);
			Thread.sleep(1000);
			hover(bulkorderspageobject.Name);

			enterData(bulkorderspageobject.Name,"John");test.log(Status.INFO,"entered name fields");
			enterData(bulkorderspageobject.PhoneNumber,"7867456786");test.log(Status.INFO,"entered phone fields");
			enterData(bulkorderspageobject.Email,"John@gmail.com");test.log(Status.INFO,"entered email fields");
			enterData(bulkorderspageobject.City,"Manchester");test.log(Status.INFO,"entered city fields");
			
			click(bulkorderspageobject.NextButton);
			test.log(Status.INFO,"switch to next page");
			Thread.sleep(1000);

			Assert.assertEquals("Page 2 of 2", bulkorderspageobject.Progresspage.getText());
			test.log(Status.PASS,"2nd page is displayed in the form");
			
			click(bulkorderspageobject.BackButton);
			test.log(Status.INFO,"switch to Previous page");
			
			Thread.sleep(1000);
			Assert.assertEquals("Page 1 of 2", bulkorderspageobject.Progresspage.getText());
			test.log(Status.PASS,"1st page is displayed in the form");
			
		}

// 194 test case need to check gmail for form confirmation1
// 183, 184  need to sign in to google account
		
		
	
}
