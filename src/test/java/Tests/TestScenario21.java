package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario21 extends BaseClass
{
	
	@Test
	public void case1()
	{
			// 238-241
		test=extent.createTest("Verify  recovery password `Functionality - existing data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		click(loginpageobject.ForgotPasswordLink);
		test.log(Status.INFO,"Navigate to reset password Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("resetpassword"));
		test.log(Status.PASS,"reset password Page is displayed");
				
		enterData(loginpageobject.recoveryEmail,config.getProperty("ExistingEmail"));
		click(loginpageobject.SubmitButton);
		test.log(Status.INFO,"validating the  existing email");
		
		Assert.assertEquals("An email with reset password instructions will be sent if the provided email address is linked to an existing account.",loginpageobject.message.getText());
		test.log(Status.PASS,"confirmation message is displayed");
		//
		enterData(loginpageobject.recoveryEmail,"abcd123@gmail.com");
		click(loginpageobject.SubmitButton);
		test.log(Status.INFO,"validating the non existing email");
		
		Assert.assertEquals("An email with reset password instructions will be sent if the provided email address is linked to an existing account.",loginpageobject.message.getText());
		test.log(Status.PASS,"confirmation message is displayed");	
		//
		enterData(loginpageobject.recoveryEmail,config.getProperty("InvalidEmail"));
		click(loginpageobject.SubmitButton);
		test.log(Status.INFO,"validating the invalid email format");
		
		Assert.assertEquals("Please enter a valid email address.",signuppageobject.emailerror.getText());
		test.log(Status.PASS,"error  message is displayed");	
		
		//
		loginpageobject.recoveryEmail.clear();
		click(loginpageobject.SubmitButton);
		test.log(Status.INFO,"validating the null data");
		
		Assert.assertEquals("This field is required.",signuppageobject.emailerror.getText());
		test.log(Status.PASS,"error  message is displayed");
		
	}
	

}
