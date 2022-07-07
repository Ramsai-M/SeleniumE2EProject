package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By emailid=By.cssSelector("input#user_email");
	By loginPwd=By.cssSelector("input#user_password");
	By SubBtn=By.name("commit");
	public LoginPage(WebDriver driver3) {
		this.driver=driver3;
	}
	public WebElement getEmailId() {
		return driver.findElement(emailid);
	}
	public WebElement getLoginPwd() {
		return driver.findElement(loginPwd);
	}
	public WebElement getSubBtn() {
		return driver.findElement(SubBtn);
	}
}
