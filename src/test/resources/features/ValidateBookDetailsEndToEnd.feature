#Author: NM
#Date:
#Description:

@api
@BookDetailsRegression
Feature: Book Details Feature    

  @RegisterUser
  Scenario: Validation of User Registration
    Given User configures the base uri for user registration
    When User configures the header "Content-Type" with value as "application/json"
    And User executes registration request for user "TestAutomation" with endpoint "/Account/v1/User"
    Then User validates created response status code
    And User validates registration response contains key "userID" with not null value
    And User stores user id from response
    
   @GenerateBearerToken
    Scenario: Validation of generating bearer token with authorised user
    Given User configures the base uri for generate Token Request
    When User configures the headers "Content-Type" with value as "application/json"
    When User executes generate token request with endpoint "/Account/v1/GenerateToken"
    Then User validates successful status code for generate token request
    And User validates generate token response contains key "token" with not null value
    And User stores the bearer token value
    And User validates generate token response contains key "expires" with not null value
    And User validates generate token response contains key as "status" with value as "Success"
    And User validates generate token response contains key as "result" with value as "User authorized successfully."
    
    @GetBooks
    Scenario: Validation of get book details for Admin
    Given User configures the base uri for get book details
    When User executes get book details request with endpoint "/BookStore/v1/Books" 
    Then User validates successful status code for get book details
    And User validates response contains atleast one book details
    And User stores the book isbn from response
    
    @AddBookWithAuthorization
    Scenario: Validation of adding book details to user account
    Given User configures the base uri for post book details
    When User adds authorization token in the header for post book details request
    And User configures the headers for post book details "Content-Type" with value as "application/json"
    When User executes post book details request with endpoint "/BookStore/v1/Books" 
    Then User validates created status code for adding book details
    
    @GetBookDetailsForUserAccount
    Scenario: Validation of get book details for User Account
    Given User configures the base uri for get book details for user account
    When User adds authorization token in the header for get book details for user request
    And User configures the headers for get book details for user account as "Content-Type" with value as "application/json"
    When User executes get book details for user request with endpoint "/Account/v1/User" 
    Then User validates successful status code for get book details for user account
    And User validates that only one book exist in user account
    
    @DeleteBookFromUserAccount
    Scenario: Validation of get book details for User Account
    Given User configures the base uri for delete book details for user account
    When User adds authorization token in the header for delete book details for user request
    And User configures the headers for delete book details for user account as "Content-Type" with value as "application/json"
    When User executes delete book details for user request with endpoint "/BookStore/v1/Book" 
    Then User validates no content status code for delete book details for user account
    
    @GetBookDetailsForUserAccount
    Scenario: Validation of get book details for User Account
    Given User configures the base uri for get book details for user account
    When User adds authorization token in the header for get book details for user request
    And User configures the headers for get book details for user account as "Content-Type" with value as "application/json"
    When User executes get book details for user request with endpoint "/Account/v1/User" 
    Then User validates successful status code for get book details for user account
    And User validates that no book exist in user account
    

    