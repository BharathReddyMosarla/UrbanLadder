package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.InteriorsPage;
import utilities.BaseClass;

public class TestScenario45 extends BaseClass
{
	public void questionariePage()
	{
		try 
		{
			test=extent.createTest("Verifying navigation to qutionarie page ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			InteriorsPage interiorspageobject=PageFactory.initElements(driver, InteriorsPage.class);
			
			hover(homepageobject.Interiors);
			test.log(Status.INFO,"Highlight the Interiors menu");
			hover(interiorspageobject.ModularWardrobes);	
			click(interiorspageobject.ModularWardrobes);
			test.log(Status.INFO,"Navigate to Interiors Page");
			Assert.assertTrue( interiorspageobject.GetFreeQuoteText.isDisplayed());
			test.log(Status.PASS,"Selected Interior Page is Displayed");			
			
			
			String Pincode="500001",
					Name="John",
					MobileNumber="9843556456",
					Email="john@gmail.com";
				hover(interiorspageobject.Pincode);
				enterData(interiorspageobject.Pincode,Pincode);
				enterData(interiorspageobject.Name,Name);
				enterData(interiorspageobject.MobileNumber,MobileNumber);
				enterData(interiorspageobject.Email,Email);	
				test.log(Status.INFO,"entered valid data");
				
				hover(interiorspageobject.NextButton);
				click(interiorspageobject.NextButton);
					
				Assert.assertEquals("Thank you for booking a design consultation.", interiorspageobject.ThankuMsg.getText());
				String OrderId=driver.getCurrentUrl().split("/")[4];
				test.log(Status.PASS,"Thank you Message is displayed and orderid : "+OrderId);
				
				click(interiorspageobject.ProceedtoQuestionarieButton);
				test.log(Status.INFO,"navigate to questionarie page");
				
				Assert.assertEquals(true, driver.getCurrentUrl().contains("requirements-questionnaire"));
				test.log(Status.PASS," questionarie page is displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			screenshot("questionarie page");
		}
	}
	
	@Test
	public void case1()
	{
		questionariePage();
		try
		{//454-457,459,460
			test=extent.createTest("Verifying qutionarie page ");
			test.log(Status.INFO,"Questionarie page is Displayed");
			
			InteriorsPage interiorspageobject=PageFactory.initElements(driver, InteriorsPage.class);
			
			Assert.assertEquals(true, interiorspageobject.Prev.isDisplayed());
			test.log(Status.PASS,"previous button is displayed in a page");
			
			Assert.assertEquals(true, interiorspageobject.Next.isDisplayed());
			test.log(Status.PASS,"Next button is displayed in a page");
			
			Assert.assertEquals(false, interiorspageobject.Prev.isEnabled());
			test.log(Status.PASS,"previous button is Disabled in a page");
			String Q1= interiorspageobject.Question.getText();
			test.log(Status.INFO,"question 1 is : "+Q1);
			click(interiorspageobject.Next);
			
			Assert.assertEquals("Please select atleast one option", interiorspageobject.ErrorMessage.getText());
			test.log(Status.PASS,"Error message is displayed for not selecting any option");
			
			click(interiorspageobject.Options.get(0));
			
			click(interiorspageobject.Next);
			test.log(Status.INFO,"goto next question");
			wait.until(ExpectedConditions.elementToBeClickable(interiorspageobject.Prev));
			String Q2= interiorspageobject.Question.getText();
			test.log(Status.INFO,"question 2 is : "+Q2);
			Assert.assertTrue(!Q1.equals(Q2));
			test.log(Status.PASS,"Second question is visible");
			
			click(interiorspageobject.Prev);
			test.log(Status.INFO,"goto Previous question");
			wait.until(ExpectedConditions.textToBePresentInElement(interiorspageobject.Question,Q1));
			Assert.assertEquals(Q1, interiorspageobject.Question.getText());
			test.log(Status.PASS,"First question is visible");
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			screenshot("case1-45");
		}
		
	}
	//@Test
	public void case2()
	{
		//461-463, 458
		questionariePage();
		test = extent.createTest("Full Questionnaire Flow Using Loop");

		InteriorsPage interiorsPage = PageFactory.initElements(driver, InteriorsPage.class);

		// Expected upto 32 questions
		for (int i = 1; i <= 32; i++) 
		{
		    try 
		    {
		        String questionText = interiorsPage.Question.getText();
		        test.log(Status.INFO, "Q" + i + ": " + questionText);

		     //   boolean answered = false;

		        // Select checkbox/radio if available based available options count is morethan 1
		        if (interiorsPage.Options.size()!=1) 
		        {
		        	// Select first available option
		            click(interiorsPage.Options.get(0));
		            test.log(Status.INFO, "Selected Option: " + interiorsPage.OptionsText.get(0).getText());
		          //  answered = true;
		        }

		        // Handle text input field, if available based available options count is equal to 1
		        if (interiorsPage.Options.size()==1) 
		        {
		            enterData(interiorsPage.Options.get(0), "456");
		            test.log(Status.INFO, "Entered Text: 456");
		         //   answered = true;
		        }

		        // Click Next button unless Submit button is displayed → last question
		        try 
		        {
		        	if (interiorsPage.Next.isDisplayed()) 
		        	{
			            click(interiorsPage.Next);
			            Thread.sleep(5000);
			            test.log(Status.INFO, "Clicked Next Button");
			            wait.until(ExpectedConditions.visibilityOf(interiorsPage.Question));
		        	}
		        }
		        catch(Exception e) 
		        { 
		        	if (interiorsPage.SubmitButton.isDisplayed()) 
		        	{
			            click(interiorsPage.SubmitButton);
			            test.log(Status.INFO, "Clicked Submit Button");
			            break;
		        	} 
		        }

		    } 
		    catch (Exception e) 
		    {
		        test.log(Status.FAIL, "Exception on Q" + i + ": " + e.getMessage());
		        break;
		    }
		}

		// thank you message
		try 
		{
		    wait.until(ExpectedConditions.visibilityOf(interiorsPage.ThankyouMessage));
		    Assert.assertTrue(interiorsPage.ThankyouMessage.isDisplayed(), "Thank You message not visible.");
		    test.log(Status.PASS, "Thank You Message: " + interiorsPage.ThankyouMessage.getText());

		    Assert.assertTrue(interiorsPage.ResponsesButton.isDisplayed(), "Responses button not visible.");
		    test.log(Status.PASS, "Responses Button is displayed.");
		    
		    click(interiorsPage.ResponsesButton);
		    wait.until(ExpectedConditions.visibilityOf(interiorsPage.Question));
		    test.log(Status.PASS, "first question is displayed.");
		} 
		catch (Exception e) 
		{
		    test.log(Status.FAIL, "Thank you screen validation failed: " + e.getMessage());
		}

		
	}

}
