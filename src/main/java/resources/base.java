package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\java\\Java Eclipse\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\this pc\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\this pc\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destFile));
		return destFile;
	}
}
