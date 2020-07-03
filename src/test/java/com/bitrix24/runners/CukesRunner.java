package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin =
        features = "src/test/resources/features",
        glue = "com/bitrix24/stepdefinitions",
        dryRun = false,
        tags = "@service"


)

public class CukesRunner {
}

