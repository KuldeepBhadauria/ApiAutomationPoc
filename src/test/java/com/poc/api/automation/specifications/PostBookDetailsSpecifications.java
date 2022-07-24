package com.poc.api.automation.specifications;

import org.junit.Assert;
import com.poc.api.automation.variables.ResponseVariables;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostBookDetailsSpecifications {
	
	public static RequestSpecification postBookDetailsRequest;
	public static Response postBookDetailsResponse;
	public int actualStatusCode;
	
	public void configureBaseUriForPostBookDetails(String uri) {
		RestAssured.baseURI = uri;
	}

	
	public void createpostBookDetailsRequestObject() {
		postBookDetailsRequest = RestAssured.given();
	}

	public void configureBearerTokenForPostBookDetailsRequest() {
		String tokenValue = GenerateTokenSpecifications.generatedToken;
		postBookDetailsRequest.header("Authorization", "Bearer " + tokenValue);
	}
	public void configureHeadersForPostBookDetailsRequest(String headerName, String headerValue) {
		postBookDetailsRequest.header(headerName, headerValue);
	}

	public void executePostBookDetailsRequest(String path) {
		String userId = RegistrationSpecifications.userId;
		String bookId = GetBookDetailsSpecifications.bookIsbn;
		postBookDetailsResponse = postBookDetailsRequest
				.body("{ \"userId\":\"" + userId + "\", \"collectionOfIsbns\": [{\"isbn\":\"" + bookId + "\"}]}").post(path);
		 System.out.println("******************************************************");
		 System.out.println("Response of Post Book Details Request is" + "\n");
		 postBookDetailsResponse.prettyPrint();
		 System.out.println("******************************************************");

	}

	public void validateCreatedResponseCodeForTokenGeneration() {
		// Assert that successful status code is returned.
		actualStatusCode = postBookDetailsResponse.getStatusCode();
		Assert.assertEquals(
				"Expected response code is: " + ResponseVariables.STATUS_CODE_CREATED
						+ " while actual reponse code is:  " + actualStatusCode,
				actualStatusCode, ResponseVariables.STATUS_CODE_CREATED /* expected value */);
	}


}
