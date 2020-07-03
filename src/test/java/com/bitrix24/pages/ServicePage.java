package com.bitrix24.pages;

import com.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ServicePage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'Services')]")
    public WebElement servicesTab;

    @FindBy(xpath = "//span[contains(text(),'e-Orders')]")
    public WebElement eOrdersModule;

    @FindBy(linkText = "Maintenance\n" + "services")
    public WebElement maintenanceServicesButton;

    @FindBy(xpath = "(//table)[5]//td//h3")
    public WebElement ticketTitle;

    @FindBy(id = "form_dropdown_REQUEST_TYPE")
    public WebElement orderType;

    @FindBy(xpath = "//input[@class='inputtext']")
    public WebElement orderTitle;

    @FindBy(xpath = "(//textarea[@class='inputtextarea'])[1]")
    public WebElement problemDescription;

    @FindBy(xpath = "(//textarea[@class='inputtextarea'])[2]")
    public WebElement priorityorduedate;

    @FindBy(xpath = "(//textarea[@class='inputtextarea'])[3]")
    public WebElement comment;

    @FindBy(xpath = "//input[@value='Submit Order']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@value='Apply']")
    public WebElement applyButton;

    @FindBy(xpath = "//input[@type='reset']")
    public WebElement resetButton;


    public void loggedIn(String usertype) {
        new LoginPage().navigateToURL();
        new LoginPage().loginAs(usertype);
    }

    public void navigateToTabAndModule(String string) {
        Driver.get().findElement(By.xpath("//span[contains(text(),'"+string+"')]")).click();
    }

    public void chooseTicketType(String ticket) {
        Driver.get().findElement(By.xpath("//img[@title='"+ticket+"']")).click();

    }

    public void createTicket() {
        //Select

    }


}
