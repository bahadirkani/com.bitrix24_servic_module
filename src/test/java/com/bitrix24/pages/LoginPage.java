package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtils;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "USER_LOGIN")
    public WebElement usernameInput;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement loginButton;

    @FindBy(id = "logo_24_text")
    public WebElement logo;

    

    public void login(String username, String password) {

    usernameInput.sendKeys(ConfigurationReader.get(username));
    passwordInput.sendKeys(ConfigurationReader.get(password));
    loginButton.click();

    }

    public void loginAs(String usertype) {

        usertype = usertype.toLowerCase();
        usernameInput.sendKeys(ConfigurationReader.get(usertype+"_username") );
        passwordInput.sendKeys(ConfigurationReader.get(usertype+"_password"));
        loginButton.click();

    }
    public void navigateToURL() {
        Driver.get().get(ConfigurationReader.get("url"));
    }







}




