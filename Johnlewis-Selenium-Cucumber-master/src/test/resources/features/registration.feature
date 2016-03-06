@temp2
Feature: Registration
  As a user
  I want to register with john lewis 
  So that I can have an account in john lewis application

  Scenario Outline: Verify that user can register
    Given I am on Home page
    When I enter"<Email address>","<Password>","<confirm password>"
    And I click on create account button
    Then I get registered successfully "<message>"

    Examples: Valid Registration
      | Email address      | Password       | confirm password | message                       |
      | check3@yopmail.com | Lewisa1yopmail | Lewisa1yopmail   | Your account has been created |
      | check3@yopmail.com | Lewisa1yopmail | Lewisa1yopmail   | Your account has been created |
     
      
