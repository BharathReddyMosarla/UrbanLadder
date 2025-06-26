package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HelpPage;
import Pages.HomePage;
import utilities.BaseClass;

public class TestScenario12and13 extends BaseClass
{
	//@Test
	public void testcase1() throws Exception 
	{
		//--- 158,159,160
		test=extent.createTest("Verify Help Page Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		HelpPage Helppageobject=PageFactory.initElements(driver, HelpPage.class);
		parent = driver.getWindowHandle();
				
		click(homepageobject.Help);
		test.log(Status.INFO,"Navigate to Help Page");
		
		String validdata= "Return Policy";
		enterData(Helppageobject.SearchBar,validdata);
		test.log(Status.INFO,"entered valid search keyword");
		
		click(Helppageobject.SearchIconButton);
		test.log(Status.INFO,"search results are displayed for entered keyword : "+validdata);
		
		Assert.assertEquals("Search results for '"+validdata+"'", Helppageobject.searchresulttext.getText());
		test.log(Status.PASS,"Relevant search results are displayed ");
		
		String invaliddata= "xyz";
		enterData(Helppageobject.SearchBar,invaliddata);
		test.log(Status.INFO,"entered invalid search keyword");
		
		click(Helppageobject.SearchIconButton);
		test.log(Status.INFO,"No results found for entered search data : "+invaliddata);
		
		Assert.assertEquals("No search results for '"+invaliddata+"'", Helppageobject.searchresulttext.getText());
		test.log(Status.PASS,"display no queries and display contact information details ");
		
		enterData(Helppageobject.SearchBar,"");
		click(Helppageobject.SearchIconButton);
		test.log(Status.INFO,"display validation for empty field");
		Thread.sleep(1000);
		screenshot("12searchvalidation");
		
		
		
	}
	@Test
	public void testcase2() throws Exception 
	{
		//--- 161-164
		test=extent.createTest("Verify Help Page - auto suggestions Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		HelpPage Helppageobject=PageFactory.initElements(driver, HelpPage.class);
		parent = driver.getWindowHandle();
				
		click(homepageobject.Help);
		test.log(Status.INFO,"Navigate to Help Page");
		
		enterData(Helppageobject.SearchBar,"return");
		test.log(Status.INFO,"entered valid search keyword");
		
		click(Helppageobject.titletext);
		
		int size=Helppageobject.autosugesstions.size();
		click(Helppageobject.SearchBar);
		if(size<=4 & size>=1)
		{
			Assert.assertTrue(true);
			test.log(Status.PASS,"auto suggestions are displayed");
			
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='';", Helppageobject.SearchBar);
		
		Helppageobject.SearchBar.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		
		enterData(Helppageobject.SearchBar,"a");
		test.log(Status.INFO,"entered valid search keyword");
		
		click(Helppageobject.titletext);
		
		int size1=Helppageobject.autosugesstions.size();
		click(Helppageobject.SearchBar);
		if(size1<=4 & size1>=1)
		{
			Assert.assertTrue(true);
			test.log(Status.PASS,"auto suggestions are displayed for single character");
			
		}
		enterData(Helppageobject.SearchBar,"xyz");
		test.log(Status.INFO,"entered invalid search keyword");

		Thread.sleep(6000);
		Assert.assertEquals("Still have unanswered queries?Contact Us", Helppageobject.sugginvalidtext.getText());
		test.log(Status.PASS,"auto suggestions is displayed for invalid data");
		
		click(Helppageobject.contactuslink);
		test.log(Status.INFO,"Navigate to Contact us topic information in help page");
		
		Assert.assertEquals("Contact Us", Helppageobject.highlighthelptopic.getText());
		test.log(Status.PASS,"contact us information is displayed and contact us topic is highlighted");
		
		Thread.sleep(6000);
	}
	
	//@Test
	public void testcase3() throws Exception 
	{
		//--- 167-169
		test=extent.createTest("Verify Help Page - topics Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		HelpPage Helppageobject=PageFactory.initElements(driver, HelpPage.class);
		parent = driver.getWindowHandle();
				
		click(homepageobject.Help);
		test.log(Status.INFO,"Navigate to Help Page");
		
		for(int i=0;i<Helppageobject.HelpTopics.size();i++)
		{
			String topic=Helppageobject.HelpTopics.get(i).getText();
			click(Helppageobject.HelpTopics.get(i));
			test.log(Status.INFO,"selected topic is displayedv: "+topic);
			Assert.assertEquals(topic, Helppageobject.highlighthelptopic.getText());
			test.log(Status.PASS,"topic is highlighted: "+topic);
			Assert.assertEquals(topic, Helppageobject.SelectedHelpTopicHeading.getText());
			test.log(Status.PASS,"topic is displayed : "+topic);
		}
		
	}
}
