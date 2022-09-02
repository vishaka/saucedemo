package PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderReviewPage {

    @FindBy(xpath="//*[@class='title']")
    WebElement reviewTitle;

    public String getReviewTitle(){
        return reviewTitle.getText();
    }

    @FindBy(id="back-to-products")
    WebElement btnBacktoProducts;

    public void clickbtnBacktoProducts(){
        btnBacktoProducts.click();
    }

    @FindBy(id="finish")
    WebElement btnfinish;

    public void clickbtnFinish(){
        btnfinish.click();
    }

}
