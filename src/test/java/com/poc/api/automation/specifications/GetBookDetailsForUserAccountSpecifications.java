package com.poc.api.automation.specifications;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.poc.api.automation.variables.ResponseVariables;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookDetailsForUserAccountSpecifications {
	
	public static RequestSpecification getBookDetailsForUserAccountRequest;
	public static Response getBookDetailsForUserAccountResponse;
	public static String getBookDetailsForUserResponseString;
	public static List<Map<String, String>> booksForUser;
	public int actualStatusCode;
	
	public void configureBaseUriForGetBookDetailsForUser(String uri) {
		RestAssured.baseURI = uri;
	}

	
	public void createGetBookDetailsForUserRequestObject() {
		getBookDetailsForUserAccountRequest = RestAssured.given();
	}

	public void configureBearerTokenForGetBookDetailsForUserRequest() {
		String tokenValue = GenerateTokenSpecifications.generatedToken;
		getBookDetailsForUserAccountRequest.header("Authorization", "Bearer " + tokenValue);
	}
	public void configureHeadersForGetBookDetailsForUserRequest(String headerName, String headerValue) {
		getBookDetailsForUserAccountRequest.header(headerName, headerValue);
	}

	public void executeGetBookDetailsForUserRequest(String path) {
		String userId = RegistrationSpecifications.userId;
		getBookDetailsForUserAccountResponse = getBookDetailsForUserAccountRequest.get(path + "/" + userId);
		System.out.println("******************************************************");
		System.out.println("Response of Get Book Details For User Account Request is" + "\n");
		getBookDetailsForUserAccountResponse.prettyPrint();
		System.out.println("******************************************************");
	}
	
	public void validateGetBookDetailsForUserAccountResponse() {
		getBookDetailsForUserResponseString = getBookDetailsForUserAccountResponse.asString();
		booksForUser = JsonPath.from(getBookDetailsForUserResponseString).get("books");
		Assert.assertTrue(booksForUser.size() == 1);	
	}

	public void validateSuccessfulResponseCodeForGetBookDetailsForUserAccount() {
		// Assert that successful status code is returned.
		actualStatusCode = getBookDetailsForUserAccountResponse.getStatusCode();
		Assert.assertEquals(
				"Expected response code is: " + ResponseVariables.STATUS_CODE_OK
						+ " while actual reponse code is:  " + actualStatusCode,
				actualStatusCode, ResponseVariables.STATUS_CODE_OK /* expected value */);
	}
	
	public void validateNoBookDetailsForUserAccountResponse() {
		getBookDetailsForUserResponseString = getBookDetailsForUserAccountResponse.asString();
		booksForUser = JsonPath.from(getBookDetailsForUserResponseString).get("books");
		Assert.assertTrue(booksForUser.size() == 0);	
	}

}
