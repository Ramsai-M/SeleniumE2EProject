package Academy;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void DrivStart() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName,String Pwdlgn, String textofUser) throws IOException {
		//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		LandingPage l=new LandingPage(driver);
		LoginPage lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(l.popSize());
		if(l.popSize()>0) {
			l.getNothanks().click();
			log.info("Pop Up got Closed");
		}
		l.getLogin().click();
		log.info("Able to click on login button");
		lp.getEmailId().sendKeys(UserName);
		log.info("Entered the email Id");
		lp.getLoginPwd().sendKeys(Pwdlgn);
		log.info("Entered Password");
		System.out.println(textofUser);
		lp.getSubBtn().click();
		log.info("Able to click on Submit button");
	}
	@AfterMethod
	public void DriEnd() {
		driver.quit();
		log.info("Closed the driver");
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="kepab91164@eoscast.com";
		data[0][1]="raja123";
		data[0][2]="Restricted User";
		
		//1th row
		data[1][0]="kepab94@eoscast.com";
		data[1][1]="rani123";
		data[1][2]="Non Restricted User";
		return data;       
	}

}
