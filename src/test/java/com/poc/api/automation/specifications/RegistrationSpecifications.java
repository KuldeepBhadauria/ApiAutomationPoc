package com.poc.api.automation.specifications;

import org.junit.Assert;
import com.poc.api.automation.variables.ResponseVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegistrationSpecifications {

	public static RequestSpecification registerUserRequest;
	public static Response registrationResponse;
	public static String registrationUsername;
	public static String password = "TestUser@123";
	public int actualStatusCode;
	public static String userId;

	public void configureBaseUriForUserRegistration(String uri) {
		RestAssured.baseURI = uri;
	}

	public void createRegisterUserRequestObject() {
		registerUserRequest = RestAssured.given();
	}

	public void configureHeaders(String headerName, String headerValue) {
		registerUserRequest.header(headerName, headerValue);
	}

	public void executeRegistrationRequest(String username, String path) {
		registrationUsername = username + generateRandomStringOfGivenLength(5);
		registrationResponse = registerUserRequest
				.body("{ \"userName\":\"" + registrationUsername + "\", \"password\":\"" + password + "\"}").post(path);

	}

	public void validateCreatedResponseCode() {
		// Assert that successful status code is returned.
		actualStatusCode = registrationResponse.getStatusCode();
		Assert.assertEquals(
				"Expected response code is: " + ResponseVariables.STATUS_CODE_CREATED
						+ " while actual reponse code is:  " + actualStatusCode,
				actualStatusCode, ResponseVariables.STATUS_CODE_CREATED /* expected value */);
	}

	public void storeUserId() {
		System.out.println("******************************************************");
		System.out.println("Response of Registration Request is" + "\n");
		registrationResponse.prettyPrint();
		System.out.println("******************************************************");
		// We will need the userID in the response body for our tests, saving it in a
		// local variable
		userId = registrationResponse.getBody().jsonPath().getString("userID");
		System.out.println("USER ID is: " + userId);
	}

	public void validateKeyInResponseNotNull(String key) {
		JsonPath jsonPathEvaluator = registrationResponse.jsonPath();
		String actualValue = (jsonPathEvaluator.get(key)).toString();
		Assert.assertFalse("Expected not null value for key: " + key + "while actual value is: " + actualValue,
				actualValue == null);
	}

	private String generateRandomStringOfGivenLength(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	

}
