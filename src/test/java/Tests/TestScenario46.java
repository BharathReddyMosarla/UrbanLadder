package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario46 extends BaseClass
{

	@Test
	public void case1()
	{
		try
		{
			test=extent.createTest("Verifying menu - sub menu options ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
			SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
			parent = driver.getWindowHandle();
			
			hover(homepageobject.OasisCollection);
			for(int i=0;i<homepageobject.OasisCollectionSM.size();i++)
			{
				hover(homepageobject.OasisCollectionSM.get(i));
			}
			hover(homepageobject.DealZone);
			for(int i=0;i<homepageobject.DealZoneSM.size();i++)
			{
				hover(homepageobject.DealZoneSM.get(i));
			}
			hover(homepageobject.SofasRecliners);
			for(int i=0;i<homepageobject.SofasReclinersSM.size();i++)
			{
				hover(homepageobject.SofasReclinersSM.get(i));
			}
			hover(homepageobject.Living);
			for(int i=0;i<homepageobject.LivingSM.size();i++)
			{
				hover(homepageobject.LivingSM.get(i));
			}
			hover(homepageobject.BedroomMattresses);
			for(int i=0;i<homepageobject.BedroomMattressesSM.size();i++)
			{
				hover(homepageobject.BedroomMattressesSM.get(i));
			}
			hover(homepageobject.Dining);
			for(int i=0;i<homepageobject.DiningSM.size();i++)
			{
				hover(homepageobject.DiningSM.get(i));
			}
			hover(homepageobject.StorageFurniture);
			for(int i=0;i<homepageobject.StorageFurnitureSM.size();i++)
			{
				hover(homepageobject.StorageFurnitureSM.get(i));
			}
			hover(homepageobject.Study);
			for(int i=0;i<homepageobject.StudySM.size();i++)
			{
				hover(homepageobject.StudySM.get(i));
			}
			hover(homepageobject.LightingDecor);
			for(int i=0;i<homepageobject.LightingDecorSM.size();i++)
			{
				hover(homepageobject.LightingDecorSM.get(i));
			}
			hover(homepageobject.Interiors);
			for(int i=0;i<homepageobject.InteriorsSM.size();i++)
			{
				hover(homepageobject.InteriorsSM.get(i));
			}
			hover(homepageobject.Stores);
//			for(int i=0;i<homepageobject.StoresSM.size();i++)
//			{
//				hover(homepageobject.StoresSM.get(i));
//			}
			test.log(Status.PASS,"Menu Options are Highlighted in home page");
			
			//-----------------466,467
			
			hover(homepageobject.Living);
			hover(homepageobject.LivingSubMenu.get(0));
			String submenu = homepageobject.LivingSubMenu.get(0).getText();
			
			click(homepageobject.LivingSubMenu.get(0));
			String submenuheading = homepageobject.productmenuheading.getText();
			
			Assert.assertEquals(submenu, submenuheading);
			test.log(Status.PASS,"sub menu page is verified"+submenu);
			for(int i=0;i<homepageobject.subsublistimage.size();i++)
			{
				Assert.assertEquals(true, homepageobject.subsublistimage.get(i).isDisplayed());
				test.log(Status.PASS,"sub menu page - list verified: "+i+" : "+homepageobject.catinfo.get(i).getText());
			}
			
			//-----468
			hover(homepageobject.subsublistimage.get(0));
			String productinfo =homepageobject.subsublistimage.get(0).getText();
			System.out.println(productinfo);
			click(homepageobject.subsublistimage.get(0));
			
			switchToChildWindow();
			Assert.assertEquals(true, homepageobject.productmenuheading.isDisplayed());
			test.log(Status.PASS,"selcted product category page is displayed: "+homepageobject.productmenuheading.getText());
			
			
			wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
			click(signuppageobject.close);
			
			//-----------469
			for(int i=0;i<productspageobject.ProductImages.size();i++)
			{
				Assert.assertEquals(true, productspageobject.ProductNames.get(i).isDisplayed());
				test.log(Status.PASS,"product name is displayed");
				Assert.assertEquals(true, productspageobject.ProductImages.get(i).isDisplayed());
				test.log(Status.PASS,"product image is displayed");
				hover(productspageobject.ProductNames.get(i));
				Assert.assertEquals(true, productspageobject.AddWishlistbuttons.get(i).isDisplayed());
				test.log(Status.PASS,"add wish list button is displayed");
				hover(productspageobject.ProductNames.get(i));
				Assert.assertEquals(true, productspageobject.AddtoCompareButtons.get(i).isDisplayed());
				test.log(Status.PASS,"add to compate button is displayed");
			}
			
			driver.close();
			
			switchToParentWindow(parent);
			wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
			click(signuppageobject.close);
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"something went wrong : "+e.getMessage());
			screenshot("case1-46");
		}
		
	}
	
}
