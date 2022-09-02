package stepDefinitions;

import PageRepository.*;
import Utilities.BrowserFactory;
import Utilities.Constants;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class MyStepdefs {

    private WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    OrderReviewPage orderReviewPage;
    ConfirmationPage confirmationPage;


    @After
    public void closeBrowser() {
        driver.quit();
    }


    @Given("Launch web application")
    public void launch_web_application() {
        driver = BrowserFactory.initializeDriver(driver);
        driver.get(Constants.appUrl);
        driver.manage().window().setSize(new Dimension(1024,768));
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        productsPage=PageFactory.initElements(driver,ProductsPage.class);
        shoppingCartPage=PageFactory.initElements(driver,ShoppingCartPage.class);
        checkoutPage=PageFactory.initElements(driver,CheckoutPage.class);
        orderReviewPage=PageFactory.initElements(driver,OrderReviewPage.class);
        confirmationPage=PageFactory.initElements(driver,ConfirmationPage.class);
        //     driver.manage().wait(1000);
    }

    @Given("^Enter \"([^\"]*)\" for login$")
    public void enterForLogin(String username) throws Throwable {
       
        loginPage.setUsername(username);
    }

    @Then("^Enter \"([^\"]*)\" and click login button$")
    public void enterAndClickLoginButton(String password) throws Throwable {
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }



    @And("^Validate the \"([^\"]*)\"$")
    public void validateThe(String expected) throws Throwable {
        Assert.assertEquals(loginPage.getErrorMessage(),expected);
    }

    @And("^Validate the successful login$")
    public void validateTheSuccessfulLogin() throws InterruptedException {
        Assert.assertEquals(productsPage.getTitle(),"PRODUCTS");


    }

    @Then("^Add two products to cart$")
    public void addTwoProductsToCart() {
        productsPage.selectSauceLabsTshirt();
        productsPage.selectSauceLabsBackpack();
        productsPage.clickShoppingCart();
        Assert.assertEquals(shoppingCartPage.getCheckoutTitle(),"YOUR CART");
    }

    @And("^Enter the checkout details \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" and click checkout$")
    public void enterTheCheckoutDetailsAndAndClickCheckout(String fname, String lname, String postcode) throws Throwable {
        shoppingCartPage.clickCheckout();
        checkoutPage.enterFirstname(fname);
        checkoutPage.enterLastname(lname);
        checkoutPage.enterPostalCode(postcode);
        checkoutPage.clickContinue();
        Assert.assertEquals(orderReviewPage.getReviewTitle(),"CHECKOUT: OVERVIEW");
    }


    @Then("^Verify the details and click Review$")
    public void verifyTheDetailsAndClickReview() {
        orderReviewPage.clickbtnFinish();
        Assert.assertEquals(confirmationPage.getConfirmationTitle(),"CHECKOUT: COMPLETE!");
        confirmationPage.clickBackToProd();
    }
}
