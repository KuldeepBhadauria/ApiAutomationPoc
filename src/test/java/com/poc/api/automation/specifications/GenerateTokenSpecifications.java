package com.poc.api.automation.specifications;

import org.junit.Assert;
import com.poc.api.automation.variables.ResponseVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateTokenSpecifications {
	
	public static RequestSpecification generateTokenRequest;
	public static Response generateTokenResponse;
	public static String generatedToken;
	public int actualStatusCode;
	
	public void configureBaseUriForUserTokenGeneration(String uri) {
		RestAssured.baseURI = uri;
	}

	
	public void createGenerateTokenRequestObject() {
		generateTokenRequest = RestAssured.given();
	}

	public void configureHeadersForGenerateTokenRequest(String headerName, String headerValue) {
		generateTokenRequest.header(headerName, headerValue);
	}

	public void executeGenerateTokenRequest(String path) {
		String username = RegistrationSpecifications.registrationUsername;
		String password = RegistrationSpecifications.password;
		generateTokenResponse = generateTokenRequest
				.body("{ \"userName\":\"" + username + "\", \"password\":\"" + password + "\"}").post(path);

	}

	public void validateSucessfulResponseCodeForTokenGeneration() {
		// Assert that successful status code is returned.
		actualStatusCode = generateTokenResponse.getStatusCode();
		Assert.assertEquals(
				"Expected response code is: " + ResponseVariables.STATUS_CODE_OK
						+ " while actual reponse code is:  " + actualStatusCode,
				actualStatusCode, ResponseVariables.STATUS_CODE_OK /* expected value */);
	}

	public void storeGeneratedToken() {		
		System.out.println("******************************************************");
		System.out.println("Response of Generate Token Request is" + "\n");
		generateTokenResponse.prettyPrint();
		System.out.println("******************************************************");
		// We will need the token in the response body for our tests, saving it in a
		// local variable
		generatedToken = generateTokenResponse.getBody().jsonPath().getString("token");
		System.out.println("Bearer Token for Username " + RegistrationSpecifications.registrationUsername + " is: " + generatedToken);
	}

	public void validateKeyInResponseNotNull(String key) {
		JsonPath jsonPathEvaluator = generateTokenResponse.jsonPath();
		String actualValue = (jsonPathEvaluator.get(key)).toString();
		Assert.assertFalse("Expected not null value for key: " + key + " while actual value is: " + actualValue,
				actualValue == null);
	}
	
	public void validateKeyValueInResponse(String key, String value) {
		JsonPath jsonPathEvaluator = generateTokenResponse.jsonPath();
        String actualValue =  (jsonPathEvaluator.get(key)).toString(); 
        Assert.assertTrue("Expected value for key: " + key + " is: " + value + " while actual value is: " + actualValue ,actualValue.equalsIgnoreCase(value));
	}


}
