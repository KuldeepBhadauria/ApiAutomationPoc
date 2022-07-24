package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.GetBookDetailsWithIsbnSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetBookDetailsWithISbnSteps {

	ConfigProvider configProvider = new ConfigProvider();
	GetBookDetailsWithIsbnSpecifications restAsurredGetSpecifications = new GetBookDetailsWithIsbnSpecifications();
	
	public String responseBodyAsString;
	
	@Given("^User configures the base uri for get book details by id$")
	public void configureBaseUri() {
		restAsurredGetSpecifications.getBaseUri(configProvider.getProperty("books.api.base.uri"));

	}
	
	@When("^User executes API endpoint with book isbn code as (.*)$")
	public void executeGetAPIRequestWithQueryParam(String bookId) {
		restAsurredGetSpecifications.executeGetRequestWithQueryParam(bookId);

	}
	
	
	@Then("^User stores the api response for validation$")
	public void storeAPIResponse() {
	     responseBodyAsString = restAsurredGetSpecifications.fetchResponseForGetRequestAsString();
	}
	
	@Then("^User validates successfull status code$")
	public void validateSucessStatusCode() {
		restAsurredGetSpecifications.validateSuccessfulStatusCode();

	}

	@Then("^User validates bad request status code$")
	public void validateBadRequestStatusCode() {
		restAsurredGetSpecifications.validateBadRequestStatusCode();

	}
	
	@Then("^User validates response contains key as \"(.*)\" with value as \"(.*)\"")
	public void vlaidateKeyValueInResponse(String key, String value) {
		restAsurredGetSpecifications.validateKeyValueInResponse(key, value);
		
	}
}
