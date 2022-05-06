package selenium.testng.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverUtils {
	
	 public static  WebDriver _driver;

	    @BeforeSuite(alwaysRun = true)
	    public void setUp() {
	        _driver = new ChromeDriver();
	    }

	    public static WebDriver getDriver() {
	        if ( _driver == null) {
	            _driver = new ChromeDriver();
	        }
	        return _driver;
	    }

	    @AfterSuite(alwaysRun = true)
	    public void tearDown() throws Exception {
	        _driver.close();
	        _driver.quit();
	    }
	    
	    public void logout() throws Exception
	    {

	         Actions a= new Actions(_driver);
	         WebElement ele=_driver.findElement(By.xpath(".//*[@id='nav-link-accountList']"));
	         a.moveToElement(ele).build().perform();



	         _driver.findElement(By.xpath(".//*[@id='nav-al-your-account']"));
	         Thread.sleep(3000);
	         _driver.findElement(By.xpath(".//*[@id='nav-al-your-account']/a[22]")).click();
	    }
}
