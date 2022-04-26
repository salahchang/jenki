package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"username\"]") WebElement USER_NAME_ELEMENT;
	@FindBy (how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy (how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SIGN_INBUTTON_ELEMENT;
	
	public void InsertUsername(String username) {
		USER_NAME_ELEMENT.sendKeys(username);
	}
	
	public void InsertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void ClickSigninButton() {
		SIGN_INBUTTON_ELEMENT.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	
}
