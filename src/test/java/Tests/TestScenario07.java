package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import utilities.BaseClass;

public class TestScenario07 extends BaseClass
{
	//101-102
	@Test
	public void testcase1() 
	{
		// test cases 103,104,107
		
		test=extent.createTest("Verify footer links - social").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		parent = driver.getWindowHandle();
		
		hover(homepageobject.AddressDetailsFooter);
		Assert.assertEquals(true, homepageobject.AddressDetailsFooter.isDisplayed());
		test.log(Status.PASS,"Company address is displayed");
		
		
		
		hover(homepageobject.PhoneIcon);
		Assert.assertEquals(true, homepageobject.PhoneIcon.isDisplayed());
		test.log(Status.PASS,"Phone icon is displayed");
		
		
		hover(homepageobject.EmailIcon);
		Assert.assertEquals(true, homepageobject.EmailIcon.isDisplayed());
		test.log(Status.PASS,"email icon is displayed");
		
		hover(homepageobject.FacebookIcon);
		Assert.assertEquals(true, homepageobject.FacebookIcon.isDisplayed());
		test.log(Status.PASS,"facebook icon is displayed");
		
		hover(homepageobject.TwitterIcon);
		Assert.assertEquals(true, homepageobject.TwitterIcon.isDisplayed());
		test.log(Status.PASS,"twitter icon is displayed");
		
		hover(homepageobject.PintrestIcon);
		Assert.assertEquals(true, homepageobject.PintrestIcon.isDisplayed());
		test.log(Status.PASS,"Pintrest icon is displayed");
		
		hover(homepageobject.YoutubeIcon);
		Assert.assertEquals(true, homepageobject.YoutubeIcon.isDisplayed());
		test.log(Status.PASS,"youtube icon is displayed");
		
		hover(homepageobject.InstagramIcon);
		Assert.assertEquals(true, homepageobject.InstagramIcon.isDisplayed());
		test.log(Status.PASS,"Instagram icon is displayed");
		
		hover(homepageobject.LinkedinIcon);
		Assert.assertEquals(true, homepageobject.LinkedinIcon.isDisplayed());
		test.log(Status.PASS,"Linkedin icon is displayed");
		
		hover(homepageobject.copyrightFooter);
		Assert.assertEquals(true, homepageobject.copyrightFooter.isDisplayed());
		test.log(Status.PASS,"copyrihts is displayed");

					
	}
	@Test
	public void testcase2() 
	{
		// test cases 105, 106, 108-112
		
		test=extent.createTest("Verify footer links - social").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		parent = driver.getWindowHandle();
		
		hover(homepageobject.FacebookIcon);
		click(homepageobject.FacebookIcon);
		test.log(Status.INFO,"Navigate to facebook page");
		switchToChildWindow();
		Assert.assertEquals("https://www.facebook.com/urbanladder", driver.getCurrentUrl());
		test.log(Status.PASS,"facebook page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		hover(homepageobject.TwitterIcon);
		click(homepageobject.TwitterIcon);
		test.log(Status.INFO,"Navigate to twitter page");
		switchToChildWindow();
		Assert.assertEquals("https://x.com/UrbanLadder", driver.getCurrentUrl());
		test.log(Status.PASS,"twitter page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		hover(homepageobject.PintrestIcon);
		click(homepageobject.PintrestIcon);
		test.log(Status.INFO,"Navigate to pintrest page");
		switchToChildWindow();
		Assert.assertEquals("https://www.pinterest.com/urbanladder/", driver.getCurrentUrl());
		test.log(Status.PASS,"pintrest page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		hover(homepageobject.YoutubeIcon);
		click(homepageobject.YoutubeIcon);
		test.log(Status.INFO,"Navigate to youtube page");
		switchToChildWindow();
		Assert.assertEquals("https://www.youtube.com/user/urbanladder", driver.getCurrentUrl());
		test.log(Status.PASS,"youtube page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		hover(homepageobject.InstagramIcon);
		click(homepageobject.InstagramIcon);
		test.log(Status.INFO,"Navigate to instagram page");
		switchToChildWindow();
		Assert.assertEquals("https://www.instagram.com/urbanladder/", driver.getCurrentUrl());
		test.log(Status.PASS,"instagram page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		hover(homepageobject.LinkedinIcon);
		click(homepageobject.LinkedinIcon);
		test.log(Status.INFO,"Navigate to linkedin page");
		switchToChildWindow();
		Assert.assertEquals(true, driver.getCurrentUrl().contains("linkedin.com"));
		test.log(Status.PASS,"linkedin page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		hover(homepageobject.AppStoreFooter.get(0));
		click(homepageobject.AppStoreFooter.get(0));
		test.log(Status.INFO,"Navigate to AppStore page");
		switchToChildWindow();
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://apps.apple.com/"));
		test.log(Status.PASS,"AppStore page is displayed");
		driver.close();
		switchToParentWindow(parent);

		hover(homepageobject.AppStoreFooter.get(1));
		click(homepageobject.AppStoreFooter.get(1));
		test.log(Status.INFO,"Navigate to google play store page");
		switchToChildWindow();
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://play.google.com/"));
		test.log(Status.PASS,"google play store page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		// cases108
		for(int i=0;i<homepageobject.acceptpayments.size();i++)
		{
			hover(homepageobject.acceptpayments.get(i));
			Assert.assertEquals(true, homepageobject.acceptpayments.get(i).isDisplayed());
			test.log(Status.PASS,"accept payments is displayed");
		}
		// 109, 110,111,112
		Assert.assertEquals(true, homepageobject.deliverytextFooter.isDisplayed());
		test.log(Status.PASS,"deliviers text is displayed in footer");
		
		Assert.assertEquals(true, homepageobject.deliverylocationsFooter.isDisplayed());
		test.log(Status.PASS,"deliviers location is displayed in footer");
		
		hover(homepageobject.DeliveryLocationMoreLink);
		test.log(Status.INFO," Delivery Location More Link is highlighted");
		
		Assert.assertEquals(true, homepageobject.DeliveryLocationMoreLink.isDisplayed());
		test.log(Status.PASS,"more link is displayed in deliviers locations in footer section");
		
		click(homepageobject.DeliveryLocationMoreLink);
		test.log(Status.INFO," Navigate to delivery locations page");
		
		switchToChildWindow();
		Assert.assertEquals(true, driver.getCurrentUrl().contains("locations"));
		test.log(Status.PASS,"delivery locations page");
		driver.close();
		switchToParentWindow(parent);
	}
	@Test
	public void testcase3() 
	{
		// test cases 114-129,113
		
		test=extent.createTest("Verify Pages in footer section").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		parent = driver.getWindowHandle();
		
		hover(homepageobject.AboutUsFooter);
		Assert.assertEquals(true, homepageobject.AboutUsFooter.isDisplayed());
		test.log(Status.PASS,"About Us link is Highlighted");
		click(homepageobject.AboutUsFooter);
		test.log(Status.INFO," Navigate to About Us Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("about"));
		test.log(Status.PASS,"About Us Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.HelpFooter);
		Assert.assertEquals(true, homepageobject.HelpFooter.isDisplayed());
		test.log(Status.PASS,"Help link is Highlighted");
		click(homepageobject.HelpFooter);
		test.log(Status.INFO," Navigate to Help Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("help"));
		test.log(Status.PASS,"Help Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.BlogFooter);
		Assert.assertEquals(true, homepageobject.BlogFooter.isDisplayed());
		test.log(Status.PASS,"Blog link is Highlighted");
		click(homepageobject.BlogFooter);
		test.log(Status.INFO," Navigate to Blog Page");
		switchToChildWindow();
		Assert.assertEquals(true, driver.getCurrentUrl().contains("blog"));
		test.log(Status.PASS,"Blog Page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		
		hover(homepageobject.InsideULFooter);
		Assert.assertEquals(true, homepageobject.InsideULFooter.isDisplayed());
		test.log(Status.PASS,"Inside UL link is Highlighted");
		click(homepageobject.InsideULFooter);
		test.log(Status.INFO," Navigate to Inside UL Page");
		switchToChildWindow();
		Assert.assertEquals(true, driver.getCurrentUrl().contains("inside"));
		test.log(Status.PASS,"Inside UL Page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		hover(homepageobject.CareersFooter);
		Assert.assertEquals(true, homepageobject.CareersFooter.isDisplayed());
		test.log(Status.PASS,"Careers link is Highlighted");
		click(homepageobject.CareersFooter);
		test.log(Status.INFO," Navigate to Careers Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("careers"));
		test.log(Status.PASS,"Careers Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.PressFooter);
		Assert.assertEquals(true, homepageobject.PressFooter.isDisplayed());
		test.log(Status.PASS,"Press link is Highlighted");
		click(homepageobject.PressFooter);
		test.log(Status.INFO," Navigate to Press Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("press"));
		test.log(Status.PASS,"Press Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.TeamFooter);
		Assert.assertEquals(true, homepageobject.TeamFooter.isDisplayed());
		test.log(Status.PASS,"Team link is Highlighted");
		click(homepageobject.TeamFooter);
		test.log(Status.INFO," Navigate to Team Page");
		switchToChildWindow();
		Assert.assertEquals(true, driver.getCurrentUrl().contains("linkedin"));
		test.log(Status.PASS,"Team Page is displayed");
		driver.close();
		switchToParentWindow(parent);
		
		
		hover(homepageobject.PrivacyPolicyFooter);
		Assert.assertEquals(true, homepageobject.PrivacyPolicyFooter.isDisplayed());
		test.log(Status.PASS,"Privacy Policy link is Highlighted");
		click(homepageobject.PrivacyPolicyFooter);
		test.log(Status.INFO," Navigate to Privacy Policy Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("privacy"));
		test.log(Status.PASS,"Privacy Policy Page is displayed");
		
		driver.navigate().back();

		hover(homepageobject.FeesPaymentFooter);
		Assert.assertEquals(true, homepageobject.FeesPaymentFooter.isDisplayed());
		test.log(Status.PASS,"Fee & Payment link is Highlighted");
		click(homepageobject.FeesPaymentFooter);
		test.log(Status.INFO," Navigate to Fee & Payment Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("payments"));
		test.log(Status.PASS,"Fee & Payment Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.ShippingDeliveryFooter);
		Assert.assertEquals(true, homepageobject.ShippingDeliveryFooter.isDisplayed());
		test.log(Status.PASS,"Shipping and delivery link is Highlighted");
		click(homepageobject.ShippingDeliveryFooter);
		test.log(Status.INFO," Navigate to Shipping and delivery Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("shipping"));
		test.log(Status.PASS,"Shipping and delivery Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.TermsandConditionsFooter);
		Assert.assertEquals(true, homepageobject.TermsandConditionsFooter.isDisplayed());
		test.log(Status.PASS,"Terms and conditions link is Highlighted");
		click(homepageobject.TermsandConditionsFooter);
		test.log(Status.INFO," Navigate to Terms and conditions Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("terms"));
		test.log(Status.PASS,"Terms and conditions Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.WarrantyReturnRefundFooter);
		Assert.assertEquals(true, homepageobject.WarrantyReturnRefundFooter.isDisplayed());
		test.log(Status.PASS,"Warrenty, return and Refund link is Highlighted");
		click(homepageobject.WarrantyReturnRefundFooter);
		test.log(Status.INFO," Navigate to Warrenty, return and Refund Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("offer"));
		test.log(Status.PASS,"Warrenty, return and Refund Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.ContactUsFooter);
		Assert.assertEquals(true, homepageobject.ContactUsFooter.isDisplayed());
		test.log(Status.PASS,"Contact Us link is Highlighted");
		click(homepageobject.ContactUsFooter);
		test.log(Status.INFO," Navigate to Contact Us Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("contact"));
		test.log(Status.PASS,"Contact Us Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.VisitUsFooter);
		Assert.assertEquals(true, homepageobject.VisitUsFooter.isDisplayed());
		test.log(Status.PASS,"Visit Us link is Highlighted");
		click(homepageobject.VisitUsFooter);
		test.log(Status.INFO," Navigate to Visit Us Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("furniture-stores"));
		test.log(Status.PASS,"Visit Us Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.BuyInBulkFooter);
		Assert.assertEquals(true, homepageobject.BuyInBulkFooter.isDisplayed());
		test.log(Status.PASS,"Buy in bulk link is Highlighted");
		click(homepageobject.BuyInBulkFooter);
		test.log(Status.INFO," Navigate to Buy in bulk Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("buy"));
		test.log(Status.PASS,"Buy in bulk Page is displayed");
		
		driver.navigate().back();
		
		hover(homepageobject.ReferEarnFooter);
		Assert.assertEquals(true, homepageobject.ReferEarnFooter.isDisplayed());
		test.log(Status.PASS,"Refer and earn link is Highlighted");
		click(homepageobject.ReferEarnFooter);
		test.log(Status.INFO," Navigate to Refer and earn Page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("refer"));
		test.log(Status.PASS,"Refer and earn Page is displayed");

		driver.navigate().back();
	}


}
