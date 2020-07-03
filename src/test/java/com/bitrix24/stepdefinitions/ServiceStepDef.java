package com.bitrix24.stepdefinitions;

import com.bitrix24.pages.ServicePage;
import com.bitrix24.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ServiceStepDef {

    ServicePage servicePage = new ServicePage();

    @Given("the user is logged in as a {string}")
    public void theUserIsLoggedInAsA(String usertype) {
        servicePage.loggedIn(usertype);
    }

    @When("navigate to {string} tab and enter {string} module")
    public void navigate_to_tab_and_enter_module(String tab, String module) {
        servicePage.navigateToTabAndModule(tab);
        servicePage.navigateToTabAndModule(module);    }

    @Then("verify that user on the {string} page")
    public void verify_that_user_on_the_page(String pageTitle) {
        Assert.assertEquals(pageTitle,servicePage.getPageTitle());

    }

    @Then("user navigates to {string}")
    public void user_navigates_to(String ticketType) {
        servicePage.chooseTicketType(ticketType);
    }

    @When("user creates the ticket")
    public void user_creates_the_ticket() {


    }


}
