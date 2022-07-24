package com.poc.api.automation.specifications;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.poc.api.automation.variables.ResponseVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteBookDetailsForUserSpecifications {
	public static RequestSpecification deleteBookDetailsForUserAccountRequest;
	public static Response deleteBookDetailsForUserAccountResponse;
	public static String deleteBookDetailsForUserResponseString;
	public static List<Map<String, String>> booksForUser;
	public int actualStatusCode;
	
	public void configureBaseUriForDeleteBookDetailsForUser(String uri) {
		RestAssured.baseURI = uri;
	}
	
	public void createDeleteBookDetailsForUserRequestObject() {
		deleteBookDetailsForUserAccountRequest = RestAssured.given();
	}

	public void configureBearerTokenForDeleteBookDetailsForUserRequest() {
		String tokenValue = GenerateTokenSpecifications.generatedToken;
		deleteBookDetailsForUserAccountRequest.header("Authorization", "Bearer " + tokenValue);
	}
	public void configureHeadersForDeleteBookDetailsForUserRequest(String headerName, String headerValue) {
		deleteBookDetailsForUserAccountRequest.header(headerName, headerValue);
	}

	public void executeDeleteBookDetailsForUserRequest(String path) {
		String userId = RegistrationSpecifications.userId;
		String bookId = GetBookDetailsSpecifications.bookIsbn;
		deleteBookDetailsForUserAccountResponse = deleteBookDetailsForUserAccountRequest
				.body("{ \"isbn\":\"" + bookId + "\", \"userId\": \"" + userId + "\"}").delete(path);
		 System.out.println("******************************************************");
		 System.out.println("Response of Delete Book Details Request for User account is" + "\n");
		 deleteBookDetailsForUserAccountResponse.prettyPrint();
		 System.out.println("******************************************************");
	}
	
	public void validateNoContentResponseCodeForDeleteBookDetailsForUserAccount() {
		// Assert that no Content status code is returned.
		actualStatusCode = deleteBookDetailsForUserAccountResponse.getStatusCode();
		Assert.assertEquals(
				"Expected response code is: " + ResponseVariables.STATUS_CODE_NO_CONTENT
						+ " while actual reponse code is:  " + actualStatusCode,
				actualStatusCode, ResponseVariables.STATUS_CODE_NO_CONTENT /* expected value */);
	}
	

	public void validateKeyInResponseNotNull(String key) {
		JsonPath jsonPathEvaluator = deleteBookDetailsForUserAccountResponse.jsonPath();
		String actualValue = (jsonPathEvaluator.get(key)).toString();
		Assert.assertFalse("Expected not null value for key: " + key + " while actual value is: " + actualValue,
				actualValue == null);
	}
	
	public void validateKeyValueInResponse(String key, String value) {
		JsonPath jsonPathEvaluator = deleteBookDetailsForUserAccountResponse.jsonPath();
        String actualValue =  (jsonPathEvaluator.get(key)).toString(); 
        Assert.assertTrue("Expected value for key: " + key + " is: " + value + " while actual value is: " + actualValue ,actualValue.equalsIgnoreCase(value));
	}


}
