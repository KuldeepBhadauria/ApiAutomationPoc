package com.poc.api.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.poc.api.automation.steps", plugin = {
		"pretty", "html:target/htmlReports/poc-api-automation-reports.html", "json:target/cucumber.json",
		"junit:target/junitReports/poc-api-automation-reports.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        tags = "@api",
		// tags = "@api or @Regression",
		// tags = "(@api or @Regression) and @Smoke",
		// tags = "(@api or @Regression) and not @Smoke",
		monochrome = true)

public class TestRunner {
	
}
