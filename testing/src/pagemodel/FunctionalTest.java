package pagemodel;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionalTest {
	protected static WebDriver driver;
	protected  static final String APP = "https://kitabisa.com/nusantaraccbelgia/contribute";
	
	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.get(APP);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@After
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void  tearDown() {
		driver.close();
		
	}
}
	
