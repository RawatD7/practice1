
@eclipse
Feature: Sign in Action
As a user 
I want to signin in to the john lewis application
So that i can access the additional features and after that can signout 



Scenario: Successful signin

Given I should be on home page
When  I click on signin link
And   I enter  Email "lewis@yopmail.com" ,Password "Lewis1yopmail" 
And   I click on signin button
Then  I should see signout link


Scenario: Successful signout
Given I am on signout page
When  I click on sign out
Then  I should see signin option





  