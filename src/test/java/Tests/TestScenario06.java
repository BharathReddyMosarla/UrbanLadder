package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import utilities.BaseClass;

public class TestScenario06  extends BaseClass
{
	//@Test
			public void testcase1()
			{
				// test cases 50,51,52
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				parent = driver.getWindowHandle();
				
				test=extent.createTest("Verify Autosuggestions Functionality").assignCategory("Negative Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				
				Assert.assertEquals(true, homepageobject.SalesInfo.isDisplayed());
				test.log(Status.PASS,"Sales info is Displayed");
				Assert.assertEquals(true, homepageobject.SalesInfo.getText().contains("%"));
				test.log(Status.PASS,"Percentage of Sales is mentioned");
				Assert.assertEquals(true, homepageobject.ShopNowLink.isDisplayed());
				test.log(Status.PASS,"Shop Now link is Displayed");
				
				click(homepageobject.ShopNowLink);
				test.log(Status.INFO,"Navigate to Sales Products page");
				
				switchToChildWindow();
				test.log(Status.INFO,"Navigate to new window");
				test.log(Status.PASS,"Shop Now Page is Displayed");
				
				driver.close();
				switchToParentWindow(parent);
				
			}
			
			//@Test
			public void testcase2() throws Exception
			{
				// test cases 53, 54, 55, 56
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				
				test=extent.createTest("Verify Slide Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				System.out.println(homepageobject.ActiveSlide.getAttribute("data-slick-index"));
				click(homepageobject.LeftArrow);
				test.log(Status.INFO," click on Left Arrow Button");
				System.out.println(homepageobject.ActiveSlide.getAttribute("data-slick-index"));
				
				Thread.sleep(1000);
				System.out.println(homepageobject.ActiveSlide.getAttribute("data-slick-index"));
				click(homepageobject.RightArrow);
				test.log(Status.INFO," click on Right Arrow Button");
				System.out.println(homepageobject.ActiveSlide.getAttribute("data-slick-index"));
				
				click(homepageobject.SlideDots.get(4));
				test.log(Status.INFO," click on 4th Dot on Slide");
				System.out.println(homepageobject.ActiveSlide.getAttribute("data-slick-index"));
				
				String url=driver.getCurrentUrl();
				
				test.log(Status.INFO," click on Active Slide");
				click(homepageobject.ActiveSlide);
				test.log(Status.INFO," Navigate to Selected Slide Page");
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS," Selected Slide Page is Displayed");
			}
			//@Test
			public void testcase3() 
			{
				// test cases  57, 58
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				
				test=extent.createTest("Verify Furniture Category Range in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				for(int i=0;i<homepageobject.ProductText.size();i++)
				{
					hover(homepageobject.ProductText.get(i));
					test.log(Status.INFO," Product Text is Highlighted");
					String url=driver.getCurrentUrl();
					click(homepageobject.ProductText.get(i));
					test.log(Status.INFO," Navigate to Selected Product/Category page");
					Assert.assertNotEquals(url, driver.getCurrentUrl());
					test.log(Status.PASS,"Selected Product/Category page is Displayed ");
					driver.navigate().back();
					test.log(Status.INFO," Navigate back to Previous Page");
				}
				
			}
			//@Test
			public void testcase4() throws Exception 
			{
				// test cases 59-62, 69
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				parent = driver.getWindowHandle();
				
				test=extent.createTest("Verify Youtube Video functionality in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				click(homepageobject.PlayButton);
				test.log(Status.INFO," Youtube video is Playing");
				Assert.assertEquals(false, homepageobject.PlayButton.isDisplayed());
				test.log(Status.PASS,"Youtube video Playing is Verified");
				Thread.sleep(3000);
				click(homepageobject.Pause);
				test.log(Status.INFO," Youtube video is Paused");
				
				Assert.assertEquals("The Look That Hooks You | Oasis Collection by Urban Ladder", homepageobject.YoutubeVideoTitle.getText());
				test.log(Status.PASS,"Youtube title is Verified");
				String url=driver.getCurrentUrl();
				
				click(homepageobject.YoutubeVideoTitle);
				test.log(Status.INFO," Youtube video is Playing in Youtube site");
				
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Youtube video is Playing in Youtube site is Verified");
				driver.close();
				switchToParentWindow(parent);		
				
			}
			
			//@Test
			public void testcase5() throws Exception 
			{
			// test cases 63,66
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				
				parent = driver.getWindowHandle();
			//	String url=driver.getCurrentUrl();
				
				test=extent.createTest("Verify Youtube Video functionality - Share in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
					
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				hover(homepageobject.ShareButton);
				test.log(Status.INFO," ShareButton is Highlighted");
				
				click(homepageobject.ShareButton);
				test.log(Status.INFO,"Share Options are visible");
				
				hover(homepageobject.ShareLink);
				test.log(Status.INFO," Link is Highlighted");
				
				Assert.assertEquals(true, homepageobject.ShareLink.isDisplayed());
				test.log(Status.PASS,"Youtube Share Link is Visible");
				
				Assert.assertEquals(true, homepageobject.ShareSocial.get(0).isDisplayed());
				test.log(Status.PASS,"Youtube Share Social media icons are Visible");
				
				click(homepageobject.ShareClose);
				test.log(Status.INFO,"Share Options are closed");
				
			}
			//@Test
			public void testcase6() throws Exception 
			{
				// test cases 67
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
						
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
				
				test=extent.createTest("Verify Youtube Video functionality - Share - More options").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				hover(homepageobject.ShareButton);
				test.log(Status.INFO," ShareButton is Highlighted");
				
				// share options - more
				click(homepageobject.ShareButton);
				test.log(Status.INFO,"Share Options are visible");
				
				hover(homepageobject.ShareLink);
				test.log(Status.INFO," Link is Highlighted");
				
				click(homepageobject.ShareMore);
				test.log(Status.INFO,"Navigate to youtube");
				
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Youtube is Displayed");
				
				driver.close();  // --------------------------------------
				switchToParentWindow(parent);
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				click(homepageobject.ShareClose);
				test.log(Status.INFO,"Share Options are closed");
				
			}
		//	@Test
			public void testcase7() throws Exception 
			{
				// test cases 68
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
						
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
				
				test=extent.createTest("Verify Youtube Video functionality - youtube logo in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
			
				// youtube logo
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				Assert.assertEquals(true, homepageobject.YoutubeLogo.isDisplayed());
				test.log(Status.PASS,"Youtube logo is displayed on Youtube video");
				
				
				click(homepageobject.YoutubeLogo);
				test.log(Status.INFO,"Navigate to youtube");
				
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Youtube is Displayed");
				
				driver.close();  // --------------------------------------
				switchToParentWindow(parent);
			}
			//@Test
			public void testcase8() throws Exception 
			{
				// test cases 64
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
						
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
				
				test=extent.createTest("Verify Youtube Video functionality - share liik in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
			
				//  share link
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				click(homepageobject.ShareButton);
				test.log(Status.INFO,"Share Options are visible");
				
				hover(homepageobject.ShareLink);
				test.log(Status.INFO," Link is Highlighted");
				
				click(homepageobject.ShareLink);
				test.log(Status.INFO,"Navigate to youtube");
				
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Youtube is Displayed");
				
				driver.close();  // --------------------------------------
				
				switchToParentWindow(parent);
			}
		//	@Test
			public void testcase9() throws Exception 
			{
				// test cases 65
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
						
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
				
				test=extent.createTest("Verify Youtube Video functionality -  share social in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				//  share social
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				click(homepageobject.ShareButton);
				test.log(Status.INFO,"Share Options are visible");
				
				hover(homepageobject.ShareLink);
				test.log(Status.INFO," Link is Highlighted");
				
				click(homepageobject.ShareSocial.get(0));
				test.log(Status.INFO,"Navigate to facebook");
				
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Facebook is Displayed");
				
				driver.close();  // --------------------------------------
				
				switchToParentWindow(parent);
				
			}
			//@Test
			public void testcase10() 
			{
				// test cases  71  -- 70,72 (pending)
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
						
				
				test=extent.createTest("Verify Youtube Video functionality -  watch later in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				//  watch later
				switchToFrameByIndex(0);
				test.log(Status.INFO," switch to youtube Frame");
				
				Assert.assertEquals(false, homepageobject.WatchLaterButton.isDisplayed());
				test.log(Status.PASS,"watch later button is not displayed");
				
				switchToParentFrame();
				hover(homepageobject.UserIcon);
				test.log(Status.INFO,"User Icon is highlighted");
				
				click(homepageobject.Login);
				test.log(Status.INFO,"Navigate to Login Popup");
				
				enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
				enterData(loginpageobject.Password,config.getProperty("LoginPassword"));
				test.log(Status.INFO,"Entered valid Login Details");
				
				click(loginpageobject.LoginButton);
				test.log(Status.INFO,"Navigate to Home Page");
				
			//  watch later after login  need to be google login 
//				switchToFrameByIndex(0);
//				test.log(Status.INFO," switch to youtube Frame");
//						
//				Assert.assertEquals(true, homepageobject.WatchLaterButton.isDisplayed());
//				test.log(Status.PASS,"watch later button is displayed");
//				
//				click(homepageobject.WatchLaterButton);
//				test.log(Status.INFO,"selected to watch later button ");
//				
//				Assert.assertEquals(true, homepageobject.WatchLaterButton.getAttribute("aria-label").contains("Added as"));
//				test.log(Status.PASS,"video is selected to watch later");
			}
			//@Test
			public void testcase11() 
			{
				// test cases  73,74
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
								
						
				test=extent.createTest("Verify bestseller category in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				hover( homepageobject.BestsellerText);
				Assert.assertEquals(true, homepageobject.BestsellerText.isDisplayed());
				test.log(Status.PASS,"Bestseller Furniture Categories section is Displayed");
				
				for(int i=0;i<homepageobject.BestsellerCategories.size();i++)
				{
					hover(homepageobject.BestsellerCategories.get(0));
					test.log(Status.INFO,"Image is Highlihted");
				}
			}

			//@Test
			public void testcase12() 
			{
				// test cases  76
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
								
				test=extent.createTest("Verify Bedroom Range category in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				Assert.assertEquals(true, homepageobject.BedroomRangeButton.isDisplayed());
				test.log(Status.PASS,"Explore Button is visible");
				Assert.assertEquals(true, homepageobject.BedroomRangeImage.isDisplayed());
				test.log(Status.PASS,"Bedroom Range Image is visible");
				
				click(homepageobject.BedroomRangeButton);
				test.log(Status.INFO,"navigate to related bedroom window is Displayed");
						
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Bedroom Range Page is Displayed");
				
				driver.close();
				
				switchToParentWindow(parent);
						
//				switchToParentWindow(parent);
				
			}
			//@Test
			public void testcase13() 
			{
				// test cases  77
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
																	
				test=extent.createTest("Verify bestseller category in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
				click(homepageobject.BedroomRangeImage);
				test.log(Status.INFO,"navigate to related bedroom window is Displayed");
				
				switchToChildWindow();
				
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Bedroom Range Page is Displayed");
				
				driver.close();
			}
			//@Test
			public void testcase14() 
			{
				// test cases 97-100
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
										
								
				test=extent.createTest("Verify our stores  in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				int size = homepageobject.StoreLeftArrow.size();
				hover(homepageobject.StoreLeftArrow.get(size-1));
				click(homepageobject.StoreLeftArrow.get(size-1));
				test.log(Status.INFO,"left arrow higlighted and cities move to right");
				
				hover(homepageobject.StoreRightArrow.get(size-1));
				click(homepageobject.StoreRightArrow.get(size-1));
				test.log(Status.INFO,"right arrow higlighted and cities move to left");
				
				hover(homepageobject.Banglore);
				test.log(Status.INFO,"city image is higlighted and zoom in image");
				Assert.assertEquals(true, homepageobject.Banglore.isDisplayed());
				test.log(Status.PASS," selected city page is displayed");
				
				click(homepageobject.Banglore);
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"Banglore City Page is Displayed");
				
				driver.close();
				
				switchToParentWindow(parent);
					
			}
			
			//@Test
			public void testcase15() 
			{
				// test cases 92-96
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
										
								
				test=extent.createTest("Verify new arrivals  in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
				int size = homepageobject.StoreLeftArrow.size();
				hover(homepageobject.StoreLeftArrow.get(size-2));
				click(homepageobject.StoreLeftArrow.get(size-2));
				test.log(Status.INFO,"left arrow higlighted and products move to right");
				
				hover(homepageobject.StoreRightArrow.get(size-2));
				click(homepageobject.StoreRightArrow.get(size-2));
				test.log(Status.INFO,"right arrow higlighted and products move to left");
				
				hover(homepageobject.ShopNow.get(9));
				test.log(Status.INFO,"shopnow button is higlighted ");
				Assert.assertEquals(true, homepageobject.ShopNow.get(9).isDisplayed());
				test.log(Status.PASS," selected product page is displayed");
				
				hover(homepageobject.newproducts.get(9));
				test.log(Status.INFO,"product image is higlighted and zoom in image");
				Assert.assertEquals(true, homepageobject.newproducts.get(9).isDisplayed());
				test.log(Status.PASS," selected product page is displayed");
				
				click(homepageobject.newproducts.get(9));
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"product details Page is Displayed");
				
				driver.close();
				
				switchToParentWindow(parent);
				
				hover(homepageobject.ShopNow.get(9));
				click(homepageobject.ShopNow.get(9));
				switchToChildWindow();
				Assert.assertNotEquals(url, driver.getCurrentUrl());
				test.log(Status.PASS,"product details Page is Displayed");
				
				driver.close();
				
				switchToParentWindow(parent);
					
			}
			@Test
			public void testcase16() 
			{
				// test cases 82-91
				// 78-81
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
				parent = driver.getWindowHandle();
				String url=driver.getCurrentUrl();
										
								
				test=extent.createTest("Verify brie,mia,gretta in HomePage").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
				test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
				for(int i=0;i<homepageobject.BMG.size();i++)
				{
					hover(homepageobject.BMG.get(i));
					test.log(Status.INFO,"sofa set image is higlighted and zoom in image: "+homepageobject.BMGNames.get(i).getText());
					click(homepageobject.BMG.get(i));
					test.log(Status.INFO,"navigate to selected sofa set model page ");
					switchToChildWindow();
					Assert.assertNotEquals(url, driver.getCurrentUrl());
					test.log(Status.PASS,"sofa set details Page is Displayed: ");
					
					driver.close();
					
					switchToParentWindow(parent);
				}
				
				for(int i=0;i<homepageobject.BMGExploreNow.size();i++)
				{
					hover(homepageobject.BMGExploreNow.get(i));
					test.log(Status.INFO,"ExploreNow button is higlighted:  "+homepageobject.BMGNames.get(i).getText());
					click(homepageobject.BMGExploreNow.get(i));
					switchToChildWindow();
					Assert.assertNotEquals(url, driver.getCurrentUrl());
					test.log(Status.PASS,"sofa set details Page is Displayed: ");
					
					driver.close();
					
					switchToParentWindow(parent);
				}
			
			}

}
