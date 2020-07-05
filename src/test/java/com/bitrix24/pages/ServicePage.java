package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtils;
import com.bitrix24.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

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

    @FindBy(xpath = "//div[@class='bx-mylist-form-data']")
    public List<WebElement> ticketList;

    @FindBy(xpath = "(//span[@class='main-buttons-item-text-title'])[2]")
    public WebElement myOrders;


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

    public String createTicket() {
        Random rn = new Random();
        Select select = new Select(orderType);
        select.selectByIndex(rn.nextInt(4));
        BrowserUtils.waitFor(3);
        String selectedOption = select.getFirstSelectedOption().getText();

        switch (selectedOption){

            case "Phone is out of order":
                orderTitle.sendKeys("Battery Issue!!");
                problemDescription.sendKeys("While charging Battery exploded");
                priorityorduedate.sendKeys("Extremely Urgent ");
                comment.sendKeys("Replace it with new one would make me happy:)");
                break;

            case "Furniture repair":
                orderTitle.sendKeys("Chair legs broken!!");
                problemDescription.sendKeys("While seating  it is exploded");
                priorityorduedate.sendKeys("If you change change,If you don't change don't send it back!!! ");
                break;

            case "Cleaner service":
                orderTitle.sendKeys("After party Living room needs to be cleaned!");
                problemDescription.sendKeys("While partying messed it up");
                priorityorduedate.sendKeys("Extremely Urgent ");
                comment.sendKeys("Before my  mother come to home please make it cleaned");
                break;

            case "other":
                orderTitle.sendKeys("Unknown error!");
                priorityorduedate.sendKeys("Urgent");
                break;
        }
        BrowserUtils.waitFor(5);

        submitButton.click();

        return selectedOption;

    }

//    public boolean checkTicket(){
//
//       // myOrders.click();
//
//        boolean res=true;
//
//        if(!ticketList.get(0).getText().contains(createTicket())){
//
//            res=false;
//        }
//
//        return res;
//
//    }


}
