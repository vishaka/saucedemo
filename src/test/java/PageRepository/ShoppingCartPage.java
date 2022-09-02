package PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {

    @FindBy(xpath="//*[@class='title']")
    WebElement shoppingCartTitle;

    public String getCheckoutTitle(){
        return shoppingCartTitle.getText();
    }

    @FindBy(id="continue-shopping")
    WebElement btnContinueShopping;

    @FindBy(id="checkout")
    WebElement btnCheckout;

    public void clickCheckout(){
        btnCheckout.click();
    }


}
