package com.poc.api.automation.steps;

import com.poc.api.automation.config.ConfigProvider;
import com.poc.api.automation.specifications.GenerateTokenSpecifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenerateTokenSteps {
	
	ConfigProvider configProvider = new ConfigProvider();
	GenerateTokenSpecifications generateTokenSpecifications = new GenerateTokenSpecifications();
	
	@Given("^User configures the base uri for generate Token Request$")
	public void configureBaseUri() {
		generateTokenSpecifications.configureBaseUriForUserTokenGeneration(configProvider.getProperty("authorization.base.uri"));
	}
				

	@When("^User configures the headers \"(.*)\" with value as \"(.*)\"$")
	public void configureHeadersForGenerateToken(String headerKey, String headerValue) {
		generateTokenSpecifications.createGenerateTokenRequestObject();
		generateTokenSpecifications.configureHeadersForGenerateTokenRequest(headerKey, headerValue);
	}

	@When("^User executes generate token request with endpoint \"(.*)\"$")
	public void generateToken(String path) {
		generateTokenSpecifications.executeGenerateTokenRequest(path);
	}

	@Then("^User validates successful status code for generate token request$")
	public void validateCreatedResponseCode() {
		generateTokenSpecifications.validateSucessfulResponseCodeForTokenGeneration();
	}
	
	@Then("User stores the bearer token value")
	public void fetchBearerToken( ) {
		generateTokenSpecifications.storeGeneratedToken();
	}

	@Then("^User validates generate token response contains key \"(.*)\" with not null value$")
	public void vlaidateKeyValueNotNullInResponse(String key) {
		generateTokenSpecifications.validateKeyInResponseNotNull(key);

	}
	
	@Then("^User validates generate token response contains key as \"(.*)\" with value as \"(.*)\"$")
	public void vlaidateKeyValueInResponse(String key, String value) {
		generateTokenSpecifications.validateKeyValueInResponse(key, value);
	}

}
