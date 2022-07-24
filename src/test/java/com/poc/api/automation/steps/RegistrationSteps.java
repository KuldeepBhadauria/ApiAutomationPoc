package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.RegistrationSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

	ConfigProvider configProvider = new ConfigProvider();
	RegistrationSpecifications registrationSpecifications = new RegistrationSpecifications();

	@Given("^User configures the base uri for user registration$")
	public void configureBaseUri() {
		registrationSpecifications
				.configureBaseUriForUserRegistration(configProvider.getProperty("authorization.base.uri"));
	}

	@When("^User configures the header \"(.*)\" with value as \"(.*)\"$")
	public void configureHeaders(String headerKey, String headerValue) {
		registrationSpecifications.createRegisterUserRequestObject();
		registrationSpecifications.configureHeaders(headerKey, headerValue);
	}

	@When("^User executes registration request for user \"(.*)\" with endpoint \"(.*)\"$")
	public void registerUser(String username, String path) {
		registrationSpecifications.executeRegistrationRequest(username, path);
	}

	@Then("^User validates created response status code$")
	public void validateCreatedResponseCode() {
		registrationSpecifications.validateCreatedResponseCode();
	}
	
	@Then("^User stores user id from response")
	public void storeUserId() {
		registrationSpecifications.storeUserId();

	}


	@Then("^User validates registration response contains key \"(.*)\" with not null value")
	public void vlaidateKeyValueNotNullInResponse(String key) {
		registrationSpecifications.validateKeyInResponseNotNull(key);

	}

}
