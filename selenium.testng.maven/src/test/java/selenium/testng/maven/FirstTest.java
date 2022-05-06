package selenium.testng.maven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.testng.maven.*;


public class FirstTest {
	
	public WebDriver driver;

    @BeforeClass
    public void setUp(){
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\LEGION\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
    }
	
	@Test
	public static void CartTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LEGION\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		WebElement username = driver.findElement(By.id("ap_email"));
		WebElement continuee = driver.findElement(By.id("continue"));
		username.sendKeys("9833056380");
		continuee.click();
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("$Shantanu619");
		WebElement signin = driver.findElement(By.id("signInSubmit"));
		signin.click(); 
		int cartSubtotal = 0;
		driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("MacBook Pro");
		driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId1 = it.next();
		driver.switchTo().window(childId1);
		String item1 = driver.findElement(By.xpath("//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr[2]/td[2]/span[1]/span[2]")).getText();
    	int pitem1 = Integer.parseInt(item1.replaceAll("[^0-9]", "").trim());
    	cartSubtotal += pitem1/100;
    	driver.findElement(By.id("add-to-cart-button")).click();
    	Thread.sleep(2000);
    	String item2 = driver.findElement(By.xpath("//*[@id=\"attach-accessory-price-2-0\"]/span[2]/span[2]")).getText();
    	int pitem2 = Integer.parseInt(item2.replaceAll("[^0-9]", "").trim());
    	cartSubtotal += pitem2;
    	driver.findElement(By.xpath("//*[@id=\'attach_add_accessory_button_0-0\']/span/input")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id='attach_add_accessory_button_2-0']/span/input")).click();
    	String item3 = driver.findElement(By.xpath("//*[@id=\"attach-accessory-price-0-0\"]/span[2]/span[2]")).getText();
    	int pitem3 = Integer.parseInt(item3.replaceAll("[^0-9]", "").trim());
    	cartSubtotal += pitem3;
    	driver.switchTo().window(parentId);
    	driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).clear();
    	driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Logitech Keyboard");
    	driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
    	driver.findElement(By.xpath("//*[contains(text(),'Logitech MX Keys Advanced Illuminated Wireless Keyboard, Bluetooth, Tactile Responsive Typing, Backlit Keys, USB-C, PC/Mac/Laptop, Windows/Linux/iOS/Android - Graphite Black (920-009418)')]")).click();
    	Thread.sleep(1000);
    	Set<String> ids2 = driver.getWindowHandles();
    	Iterator<String> it2 = ids2.iterator();
    	String base = it2.next();
    	String productpage = it2.next();
    	String cartpage = it2.next();
    	driver.switchTo().window(cartpage);
    	String item4 = driver.findElement(By.xpath("//*[@id=\"corePrice_feature_div\"]/div/span/span[2]")).getText();
    	int pitem4 = Integer.parseInt(item4.replaceAll("[^0-9]", "").trim());
    	cartSubtotal += pitem4/100;
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
    	System.out.println(cartSubtotal);
    	Thread.sleep(3000);
    	Actions a= new Actions(driver);
    	WebElement ele= driver.findElement(By.xpath(".//*[@id='nav-link-accountList']"));
    	driver.findElement(By.id("attach-close_sideSheet-link")).click();
    	Thread.sleep(2000);
    	a.moveToElement(ele).build().perform();
    	//driver.findElement(By.xpath(".//*[@id='nav-al-your-account']"));
     	driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]")).click();
     	Thread.sleep(2000);
     	WebElement username1 = driver.findElement(By.id("ap_email"));
		WebElement continuee1 = driver.findElement(By.id("continue"));
		username1.sendKeys("9833056380");
		continuee1.click();
		WebElement password1 = driver.findElement(By.id("ap_password"));
		password1.sendKeys("$Shantanu619");
		WebElement signin1 = driver.findElement(By.id("signInSubmit"));
		signin1.click();
		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
		Thread.sleep(2000);
		String cart = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span")).getText();
		int pcart = Integer.parseInt(cart.replaceAll("[^0-9]", "").trim());
		Assert.assertEquals(cartSubtotal, pcart/100);
	}
	
		@AfterClass
	    public void tearDown(){
	        driver.quit();
	    }
}
