#Author: NM
#Date:
#Description:

@api
@GetBookDetailsWithIsbn
Feature: Book Details Feature

Background:
    Given User configures the base uri for get book details by id

  @GetBookDetailsByIsbnHappyPath
  Scenario Outline: Validation of Get Book Details API By Book ID
    When User executes API endpoint with book isbn code as <ISBN Code>
    Then User stores the api response for validation
    And User validates successfull status code
    And User validates response contains key as "title" with value as "Git Pocket Guide"
    And User validates response contains key as "subTitle" with value as "A Working Introduction"
    And User validates response contains key as "author" with value as "Richard E. Silverman"
    And User validates response contains key as "publish_date" with value as "2020-06-04T08:48:39.000Z"
    And User validates response contains key as "publisher" with value as "O'Reilly Media"
    And User validates response contains key as "pages" with value as "234"
    And User validates response contains key as "website" with value as "http://chimera.labs.oreilly.com/books/1230000000561/index.html"   
    
    Examples: 
      | ISBN Code            |
      | ISBN=9781449325862   |
      
  
  @GetBookDetailsbyIsnUnhappyPath
  Scenario Outline: Validation of Get Book Details API By Invalid Book ID
    When User executes API endpoint with book isbn code as <ISBN Code>
    Then User stores the api response for validation
    And User validates bad request status code
    And User validates response contains key as "code" with value as "1205"
    And User validates response contains key as "message" with value as "ISBN supplied is not available in Books Collection!"    
    
    Examples: 
      | ISBN Code            |
      | ISBN=9111111111111   |