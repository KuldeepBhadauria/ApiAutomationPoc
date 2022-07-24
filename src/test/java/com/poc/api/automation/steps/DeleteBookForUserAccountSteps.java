package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.DeleteBookDetailsForUserSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteBookForUserAccountSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
	DeleteBookDetailsForUserSpecifications deleteBookDetailsForUserSpecifications = new DeleteBookDetailsForUserSpecifications();
	
	@Given("^User configures the base uri for delete book details for user account$")
	public void configureBaseUriForDeleteBookDetailsForUser() {
		deleteBookDetailsForUserSpecifications.configureBaseUriForDeleteBookDetailsForUser(configProvider.getProperty("authorization.base.uri"));
	}
	
	@When("^User adds authorization token in the header for delete book details for user request$")
	public void addBearerTokenToHeaderForDeleteBookDetailsForUserResponse() {
		deleteBookDetailsForUserSpecifications.createDeleteBookDetailsForUserRequestObject();
		deleteBookDetailsForUserSpecifications.configureBearerTokenForDeleteBookDetailsForUserRequest();
	}
		

	@When("^User configures the headers for delete book details for user account as \"(.*)\" with value as \"(.*)\"$")
	public void configureHeadersForDeleteBookDetailsForUser(String headerKey, String headerValue) {
		deleteBookDetailsForUserSpecifications.configureHeadersForDeleteBookDetailsForUserRequest(headerKey, headerValue);
	}			

	@When("^User executes delete book details for user request with endpoint \"(.*)\"$")
	public void deleteBookDetailsForUser(String path) {
    	deleteBookDetailsForUserSpecifications.executeDeleteBookDetailsForUserRequest(path);
	}

	@Then("^User validates no content status code for delete book details for user account$")
	public void validateDeleteBookDetailsNoContentResponseCode() {
		deleteBookDetailsForUserSpecifications.validateNoContentResponseCodeForDeleteBookDetailsForUserAccount();
	}
	
	@Then("^User validates delete book for user response contains key \"(.*)\" with not null value$")
	public void vlaidateKeyValueNotNullInResponse(String key) {
		deleteBookDetailsForUserSpecifications.validateKeyInResponseNotNull(key);

	}
	
	@Then("^User validates delete book for user response contains key as \"(.*)\" with value as \"(.*)\"$")
	public void vlaidateKeyValueInResponse(String key, String value) {
		deleteBookDetailsForUserSpecifications.validateKeyValueInResponse(key, value);
	}
	

}
