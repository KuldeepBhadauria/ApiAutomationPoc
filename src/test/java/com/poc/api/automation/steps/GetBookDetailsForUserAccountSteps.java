package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.GetBookDetailsForUserAccountSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetBookDetailsForUserAccountSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
	GetBookDetailsForUserAccountSpecifications getBookDetailsForUserAccountSpecifications = new GetBookDetailsForUserAccountSpecifications();
	
	@Given("^User configures the base uri for get book details for user account$")
	public void configureBaseUriForGetBookDetailsForUserAccount() {
		getBookDetailsForUserAccountSpecifications.configureBaseUriForGetBookDetailsForUser(configProvider.getProperty("authorization.base.uri"));
	}
    
	@When("^User adds authorization token in the header for get book details for user request$")
	public void addBearerTokenToHeaderForGetBookDetailsForUserResponse() {
		getBookDetailsForUserAccountSpecifications.createGetBookDetailsForUserRequestObject();
		getBookDetailsForUserAccountSpecifications.configureBearerTokenForGetBookDetailsForUserRequest();
	}
		

	@When("^User configures the headers for get book details for user account as \"(.*)\" with value as \"(.*)\"$")
	public void configureHeadersForGetBookDetailsForUser(String headerKey, String headerValue) {
		getBookDetailsForUserAccountSpecifications.configureHeadersForGetBookDetailsForUserRequest(headerKey, headerValue);
	}

	@When("^User executes get book details for user request with endpoint \"(.*)\"$")
	public void getBookDetailsForUSer(String path) {
    	getBookDetailsForUserAccountSpecifications.executeGetBookDetailsForUserRequest(path);
	}

	@Then("^User validates successful status code for get book details for user account$")
	public void validateGetBookDetailsForUSerSuccessResponseCode() {
		getBookDetailsForUserAccountSpecifications.validateSuccessfulResponseCodeForGetBookDetailsForUserAccount();
	}
	
	@Then("^User validates that only one book exist in user account$")
	public void validateBookSizeInGetBookDetailsForUserResponse() {
		getBookDetailsForUserAccountSpecifications.validateGetBookDetailsForUserAccountResponse();
	}
	
	@Then("^User validates that no book exist in user account$")
	public void validateNoBooksInGetBookDetailsForUserResponse() {
		getBookDetailsForUserAccountSpecifications.validateNoBookDetailsForUserAccountResponse();
	}
	
}
