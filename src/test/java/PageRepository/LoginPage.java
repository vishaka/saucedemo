package PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorTxt;

    public String getErrorMessage(){
        return errorTxt.getText();
    }

   public void setUsername(String uname){
       username.sendKeys(uname);
   }
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

   public void clickLogin(){
       loginButton.click();
   }

}
