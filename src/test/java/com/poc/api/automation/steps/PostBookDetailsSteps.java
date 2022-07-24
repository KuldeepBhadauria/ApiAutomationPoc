package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.PostBookDetailsSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostBookDetailsSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
    PostBookDetailsSpecifications postBookDetailsSpecifications = new PostBookDetailsSpecifications();
	
	@Given("^User configures the base uri for post book details$")
	public void configureBaseUriFOrPostBookDetails() {
		postBookDetailsSpecifications.configureBaseUriForPostBookDetails(configProvider.getProperty("authorization.base.uri"));
	}
	
	@Given("^User adds authorization token in the header for post book details request$")
	public void addBearerTokenToHeaderFOrPostBookDetails() {
		postBookDetailsSpecifications.createpostBookDetailsRequestObject();
		postBookDetailsSpecifications.configureBearerTokenForPostBookDetailsRequest();
	}
		

	@When("^User configures the headers for post book details \"(.*)\" with value as \"(.*)\"$")
	public void configureHeadersForGenerateToken(String headerKey, String headerValue) {
    	postBookDetailsSpecifications.configureHeadersForPostBookDetailsRequest(headerKey, headerValue);
	}

	@When("^User executes post book details request with endpoint \"(.*)\"$")
	public void generateToken(String path) {
		postBookDetailsSpecifications.executePostBookDetailsRequest(path);
	}

	@Then("^User validates created status code for adding book details$")
	public void validateCreatedResponseCode() {
		postBookDetailsSpecifications.validateCreatedResponseCodeForTokenGeneration();
	}

}
