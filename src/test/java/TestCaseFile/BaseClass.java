package TestCaseFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import UtilitiesFile.ReadconfigClass;

public class BaseClass {

	public static WebDriver driver;
	public static Logger Log1;
	ReadconfigClass Rc = new ReadconfigClass();
	String url = Rc.geturl(); //"https://practicetestautomation.com/practice-test-login/"
	String browser = Rc.getbrowser(); //Firefox
	@BeforeClass
	public void browserLaunch() {
		switch(browser.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			default:
				driver=null;
				break;
		}
		Log1=LogManager.getLogger("MyFirstDDProject");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	public void ScreenShot() throws IOException {
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("D:\\Shreya_code\\Eclipse_workspace\\MyFirstDDProject\\ScreenshotFolder\\ProjectReport.png");
	FileUtils.copyFile(Source, Destination);
	
	}
	@AfterClass
	public void closeUp() {
		driver.close();
		driver.quit();
	}
}
