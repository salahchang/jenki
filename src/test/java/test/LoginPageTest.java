package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.TestBase;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	
	@BeforeMethod
	public void setUp() {
		initDriver();
		loginpage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test
	public void LoginTest() throws Throwable {
		loginpage.InsertUsername("demo@techfios.com");
		loginpage.InsertPassword("abc123");
		loginpage.ClickSigninButton();
		TakeScreenShot(driver);
	}
	
	@Test
	public void pageTitleTest() throws Throwable {
		loginpage.InsertUsername("demo@techfios.com");
		loginpage.InsertPassword("abc123");
		loginpage.ClickSigninButton();
		String ecpectedTitle = "Dashboard- iBilling";
		String actualTitle = loginpage.getTitle();
		Assert.assertEquals(actualTitle, ecpectedTitle);
		TakeScreenShot(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
