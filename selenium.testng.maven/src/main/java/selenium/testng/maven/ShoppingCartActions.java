package selenium.testng.maven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.TestException;

public class ShoppingCartActions extends CommonUtils {
		
	private final By CART_BUTTON = By.cssSelector("#hlb-view-cart-announce");
    //private final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("#hlb-ptc-btn-native");
    private final By PRICE = By.cssSelector("[class='a-color-price hlb-price a-inline-block a-text-bold']");
    private final By DELETE_BUTTONS = By.cssSelector("input[value='Delete']");

    public void verifyOnShoppingCartReviewPage(){
        String url = getCurrentURL();
        System.out.println("SHOPPING_CART_REVIEW_PAGE: Verifying that we are on SHOPPING_CART_REVIEW_PAGE.");
        if (!url.contains("view")){
            throw new TestException("ERROR: Not on SHOPPING_CART_REVIEW_PAGE! URL: " + url);
        }
    }

    public String getCartSubtotal(){
        return getElementText(PRICE);
    }

    /*public void clickProceedToCheckoutButton(){
        click(PROCEED_TO_CHECKOUT_BUTTON);
    }*/
    public void deleteAllItemsInCart(){
        List<WebElement> deleteButtons = getElements(DELETE_BUTTONS);
        for ( WebElement button : deleteButtons ){
            button.click();
        }
    }
    
    public void clickCartButton() {
        click(CART_BUTTON);
    }
}
