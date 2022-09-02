package PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {

    @FindBy(xpath="//*[@class='title']")
    WebElement pagetitle;

    public String getTitle(){
        return  pagetitle.getText();
    }

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    public void clickShoppingCart(){
        shoppingCartLink.click();
    }

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addToCartSauceLabsBackpack;

    public void selectSauceLabsBackpack(){
        addToCartSauceLabsBackpack.click();
    }

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartSauceLabsboltTshirt;

    public void selectSauceLabsTshirt(){
        addToCartSauceLabsboltTshirt.click();
    }
}
