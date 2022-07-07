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

public class ValidateTitle extends base {
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void DriStart() throws IOException {
	driver=initializeDriver();
	log.info("Driver is Initialized.");
	driver.get(prop.getProperty("url"));
	log.info("Navigated to Home Page.");
}
	@Test
	public void validateTitles() throws IOException {
		LandingPage l=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(l.popSize());
		if(l.popSize()>0) {
			l.getNothanks().click();
			log.info("Popup cancelled.");
		}
		System.out.println(l.getTitle().getText());
		Assert.assertEquals(l.getTitle().getText(), "FEATURED12 COURSES");
		log.info("Successfully Validated Text message.");
	}
	@AfterTest
	public void DriEnd() {
		driver.quit();
		log.info("Closed the driver");
	}
}
