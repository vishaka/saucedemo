package PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy(xpath="//*[@class='title']")
    WebElement checkoutPageTitle;

    public String getCheckoutTitle(){
        return checkoutPageTitle.getText();
    }

    @FindBy(id="first-name")
    WebElement txtFirstName;

    public void enterFirstname(String fname){
        txtFirstName.sendKeys(fname);
    }

    @FindBy(id="last-name")
    WebElement txtLastName;

    public void enterLastname(String lname){
        txtLastName.sendKeys(lname);
    }

    @FindBy(id="postal-code")
    WebElement txtPostalCode;

    public void enterPostalCode(String postalCode){
        txtPostalCode.sendKeys(postalCode);
    }

    @FindBy(id="continue")
    WebElement btnContinue;

    public void clickContinue(){
        btnContinue.click();
    }

}
