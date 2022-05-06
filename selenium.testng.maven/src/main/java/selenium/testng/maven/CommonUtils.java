package selenium.testng.maven;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.annotations.Test;


public class CommonUtils {
	public static WebDriver _driver;
	public WebDriverWait wait;
	private static int timeout = 10;
	
	public CommonUtils() {
        _driver = DriverUtils.getDriver();
    }
	
	 public String getCurrentURL() {
	        try {
	            return _driver.getCurrentUrl();
	        } catch (Exception e) {
	            throw new TestException(String.format("Current URL is: %s", _driver.getCurrentUrl()));
	        }
	    }
	 
	 public String getElementText(By selector) {
	        waitUntilElementIsDisplayedOnScreen(selector);
	        try {
	            return StringUtils.trim(_driver.findElement(selector).getText());
	        } catch (Exception e) {
	            System.out.println(String.format("Element %s does not exist - proceeding", selector));
	        }
	        return null;
	    }
	 
	 public void click(By selector) {
	        WebElement element = getElement(selector);
	        waitForElementToBeClickable(selector);
	        try {
	            element.click();
	        } catch (Exception e) {
	            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
	        }
	    }
	 
	 public WebElement getElement(By selector) {
	        try {
	            return _driver.findElement(selector);
	        } catch (Exception e) {
	            System.out.println(String.format("Element %s does not exist - proceeding", selector));
	        }
	        return null;
	    }
	 
	 public List<WebElement> getElements(By Selector) {
	        waitForElementToBeVisible(Selector);
	        try {
	            return _driver.findElements(Selector);
	        } catch (Exception e) {
	            throw new NoSuchElementException(String.format("The following element did not display: [%s] ", Selector.toString()));
	        }
	    }
	 
	 public void sendKeys(By selector, String value) {
	        WebElement element = getElement(selector);
	        clearField(element);
	        try {
	            element.sendKeys(value);
	        } catch (Exception e) {
	            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
	        }
	    }
	 
	 public void clearField(WebElement element) {
	        try {
	            element.clear();
	            waitForElementTextToBeEmpty(element);
	        } catch (Exception e) {
	            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
	        }
	    }
	 
	 public void waitForElementTextToBeEmpty(WebElement element) {
	        String text;
	        try {
	            text = element.getText();
	            int maxRetries = 10;
	            int retry = 0;
	            while ((text.length() >= 1) || (retry < maxRetries)) {
	                retry++;
	                text = element.getText();
	            }
	        } catch (Exception e) {
	            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
	        }

	    }
	 
	 @SuppressWarnings("deprecation")
		public void waitUntilElementIsDisplayedOnScreen(By selector) {
	        try {
	            wait = new WebDriverWait(_driver, timeout);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	        } catch (Exception e) {
	            throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
	        }
	    }
	 
	 @SuppressWarnings("deprecation")
		public void waitForElementToBeClickable(By selector) {
	        try {
	            wait = new WebDriverWait(_driver, timeout);
	            wait.until(ExpectedConditions.elementToBeClickable(selector));
	        } catch (Exception e) {
	            throw new TestException("The following element is not clickable: " + selector);
	        }
	    }
	 
	 @SuppressWarnings("deprecation")
		public void waitForElementToBeVisible(By selector) {
	        try {
	            wait = new WebDriverWait(_driver, timeout);
	            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
	        } catch (Exception e) {
	            throw new NoSuchElementException(String.format("The following element was not visible: %s", selector));
	        }
	    }

}
