package com.poc.api.automation.specifications;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.poc.api.automation.variables.ResponseVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookDetailsSpecifications {
	
		
		public static RequestSpecification getBookDetailsRequest;
		public static Response getBookDetailsResponse;
		public static String getBookDetailsResponseString;
		public static List<Map<String, String>> books;
		public static String bookIsbn;
		public int actualStatusCode;
		
		public void configureBaseUriForGetBookDetails(String uri) {
			RestAssured.baseURI = uri;
		}

		
		public void createGetBookDetailsRequestObject() {
			getBookDetailsRequest = RestAssured.given();
		}

		public void executeGetBookDetailsRequest(String path) {
			getBookDetailsResponse = getBookDetailsRequest.get(path);

		}

		public void validateSucessfulResponseCodeForGetBookDetails() {
			// Assert that successful status code is returned.
			actualStatusCode = getBookDetailsResponse.getStatusCode();
			Assert.assertEquals(
					"Expected response code is: " + ResponseVariables.STATUS_CODE_OK
							+ " while actual reponse code is:  " + actualStatusCode,
					actualStatusCode, ResponseVariables.STATUS_CODE_OK);
		}

		public void validategetBookDetailsResponse() {		
			System.out.println("******************************************************");
			System.out.println("Response of Get Book Details Request is" + "\n");
			getBookDetailsResponse.prettyPrint();
			System.out.println("******************************************************");
			getBookDetailsResponseString = getBookDetailsResponse.asString();
			books = JsonPath.from(getBookDetailsResponseString).get("books");
			Assert.assertTrue(books.size() > 0);
		}
		
		public void storeBookIsbn() {
			// We will need the book isbn in the response body for our tests, saving it in a
			// local variable			
			bookIsbn = books.get(0).get("isbn");
			System.out.println("Book ISBN Is:" + bookIsbn);
			
		}

}
