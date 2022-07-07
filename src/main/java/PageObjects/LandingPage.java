package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By Nothanks=By.xpath("//button[text()='NO THANKS']");
	By login=By.cssSelector("a[href*='sign_in']");
	By Title=By.cssSelector("div[class='text-center'] h2");
	By conNavbar=By.xpath("//nav[@class='navbar-collapse collapse']");
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}
	public WebElement getNothanks() {
		return driver.findElement(Nothanks);
	}
	public int popSize() {
		return driver.findElements(Nothanks).size();
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	public WebElement getTitle() {
		return driver.findElement(Title);
	}
	public WebElement getconNavbar() {
		return driver.findElement(conNavbar);
	}
}
