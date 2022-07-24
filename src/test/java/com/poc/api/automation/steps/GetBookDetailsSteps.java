package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.GetBookDetailsSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetBookDetailsSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
	GetBookDetailsSpecifications getBookDetailsSpecifications = new GetBookDetailsSpecifications();
	
	@Given("^User configures the base uri for get book details$")
	public void configureBaseUriForGetBookDetails() {
		getBookDetailsSpecifications.configureBaseUriForGetBookDetails(configProvider.getProperty("authorization.base.uri"));
	}
				

	@When("^User executes get book details request with endpoint \"(.*)\"$")
	public void getBookDetails(String path) {
		getBookDetailsSpecifications.createGetBookDetailsRequestObject();
		getBookDetailsSpecifications.executeGetBookDetailsRequest(path);
	}

	@Then("^User validates successful status code for get book details$")
	public void validateGetBookDetailsSuccessResponseCode() {
		getBookDetailsSpecifications.validateSucessfulResponseCodeForGetBookDetails();
	}
	
	@Then("^User validates response contains atleast one book details$")
	public void validateBookSizeInGetBookDetailsResponse() {
		getBookDetailsSpecifications.validategetBookDetailsResponse();
	}
	
	
	@Then("User stores the book isbn from response")
	public void fetchBookIsbn( ) {
		getBookDetailsSpecifications.storeBookIsbn();
	}


}
