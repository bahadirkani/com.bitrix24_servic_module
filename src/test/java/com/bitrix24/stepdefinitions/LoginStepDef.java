package com.bitrix24.stepdefinitions;

import com.bitrix24.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();

    @Given("navigate to login page")
    public void navigate_to_login_page() {
        loginPage.navigateToURL();

    }

    @When("user enter {string} credentials and click login button")
    public void user_enter_credentials(String usertype) {
        loginPage.loginAs(usertype);
    }


    @Then("user should be logged in")
    public void user_should_be_logged_in() {
       Assert.assertTrue(loginPage.logo.isDisplayed());

    }



}
