package com.bitrix24.stepdefinitions;

import com.bitrix24.utilities.BrowserUtils;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setup(Scenario scenario) {
        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }
}
