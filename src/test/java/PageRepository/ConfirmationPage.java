package PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage {

    @FindBy(xpath="//*[@class='title']")
    WebElement confirmationTitle;

    public String getConfirmationTitle(){
        return confirmationTitle.getText();
    }

    @FindBy(id="back-to-products")
    WebElement btnBackToProd;

    public void clickBackToProd(){
        btnBackToProd.click();
    }

}
