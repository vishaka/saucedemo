Feature: Test scenarios for Saucelabs

  Background:
    Given Launch web application

  @Success
  @SauceLabTest
  Scenario: Successful Login Authentication
    Given Enter "standard_user" for login
    Then Enter "secret_sauce" and click login button
    And Validate the successful login

    @NegativeScenarios
      @SauceLabTest
  Scenario Outline:  Un-happy path to validate the login errors
    Given Enter "<username>" for login
    Then Enter "<password>" and click login button
    And Validate the "<ErrorMessage>"
    Examples:
      | username | password | ErrorMessage |
      |          |          |Epic sadface: Username is required|
      |          |test      |Epic sadface: Username is required|
      |test      |          |Epic sadface: Password is required|
      |Test      |Random    |Epic sadface: Username and password do not match any user in this service|
      |standard_user| sejior  |Epic sadface: Username and password do not match any user in this service|

      @LoginBuy2Product
      @SauceLabTest
      Scenario: Successful purchase of product
        Given Enter "standard_user" for login
        Then Enter "secret_sauce" and click login button
        And Validate the successful login
        Then Add two products to cart
        And Enter the checkout details "Ben" "Geller" and "D04VW50" and click checkout
        Then Verify the details and click Review

