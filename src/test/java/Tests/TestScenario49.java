package Tests;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario49 extends BaseClass
{
	@Test
	public void case1()
	{
		try
		{
			// 512-520
			test=extent.createTest("Verifying comparing two products ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
			
			hover(homepageobject.Dining);
			test.log(Status.INFO,"Selected menu is highlighted");
			hover(homepageobject.DiningSM.get(3));
			click(homepageobject.DiningSM.get(3));
			test.log(Status.INFO,"selected product category page is displayed");
			
			wait.until(ExpectedConditions.visibilityOf(productspageobject.headingproduct));
			hover(productspageobject.ProductImages.get(0));
			test.log(Status.INFO,"add to compare button is visible: 1");
			click(productspageobject.AddtoCompareButtons.get(0));
			test.log(Status.INFO,"First product added to compare list : "+productspageobject.ProductNames.get(0).getText());
			
			wait.until(ExpectedConditions.visibilityOf(productspageobject.products.get(0)));
			Assert.assertEquals(productspageobject.products.get(0).getText(), productspageobject.products.get(0).getText());
			test.log(Status.PASS,"compare frame is visble and added product is displlayed in a frame");
		
			Assert.assertEquals(true, productspageobject.compare.getAttribute("class").contains("disabled"));
			test.log(Status.PASS,"compare button is disabled");
			
			wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
			click(signuppageobject.close);
			
			
			hover(productspageobject.ProductImages.get(1));
			test.log(Status.INFO,"add to compare button is visible: 2");
		//	hover(productspageobject.AddtoCompareButtons.get(1));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", productspageobject.AddtoCompareButtons.get(1));
			test.log(Status.INFO,"Second product added to compare list : "+productspageobject.ProductNames.get(1).getText());
			
			
		//	wait.until(ExpectedConditions.visibilityOf(productspageobject.products.get(1)));
			Assert.assertEquals(true, productspageobject.compare.isEnabled());
			test.log(Status.PASS,"compare button is enabled");
			
			
			action.moveToElement(productspageobject.ProductImages.get(2));
			test.log(Status.INFO,"add to compare button is visible : 3");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", productspageobject.AddtoCompareButtons.get(2));
			test.log(Status.INFO,"try to add to compare list -- error message is displayed");
			
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(productspageobject.errormessage));
			Assert.assertEquals(true, productspageobject.errormessage.isDisplayed());
			test.log(Status.PASS,"error mesage is displayed : "+productspageobject.errormessage.getText());
			click(productspageobject.gotit);
			
		
			
	
			click(productspageobject.compare);
			test.log(Status.INFO,"Navigate to compare page : ---");
			
			Thread.sleep(3000);
			
			Assert.assertEquals(true, productspageobject.comparetext.isDisplayed());
			test.log(Status.PASS," compare page is displayed");
			
			
			test.log(Status.PASS,"product names: "+productspageobject.product1.getText()+" = "+productspageobject.product2.getText());
			test.log(Status.PASS,"product prices: "+productspageobject.product1price.getText()+" = "+productspageobject.product2price.getText());

			int middle =productspageobject.head.size()/2;
			for(int i=0;i<middle;i++)
			{
				test.log(Status.PASS,+(i+1)+". "+productspageobject.head.get(i).getText()+" : "+productspageobject.info.get(i).getText() +" = "
						+productspageobject.head.get(middle+i).getText()+" : "+productspageobject.info.get(middle+i).getText());

			}
			
			
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went wrong"+e.getMessage());
			screenshot("compareproducts");
		}
		
	}
	

}
