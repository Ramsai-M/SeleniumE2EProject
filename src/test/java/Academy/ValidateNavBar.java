package Academy;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.base;

public class ValidateNavBar extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void DriStart() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized.");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page.");
	}
	@Test
	public void validateNavBar() throws IOException {
		LandingPage l=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(l.popSize());
		if(l.popSize()>0) {
			l.getNothanks().click();
			log.info("Pop Up is closed");
		}
		Assert.assertTrue(l.getconNavbar().isDisplayed());
		System.out.println(l.getconNavbar().getText());
		log.info("Navigation is displaying.");
	}
	@AfterTest
	public void DriEnd() {
		driver.quit();
		log.info("Closed the driver.");
	}
}
