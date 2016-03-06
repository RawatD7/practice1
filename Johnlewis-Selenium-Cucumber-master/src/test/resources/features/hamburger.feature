@perm1
Feature: Using different options available in hamburger menu
  As a user
  I want to click on different options available in the hamburger menu
  So that i can access them

  Scenario: Check that Browse By Departments link is accessible and item can be added to basket
    Given I should be on home page
    When I click on the Hamburger menu
    And I click on the link "Browse by Department"
    Then I navigate to the  Department page
    And I select the specific department "Electrical"
    And Add the item into the basket

  Scenario: Check that partnership card link is accessible
    Given I should be on home page
    When click on the Hamburger menu
    And  click on the link "Partnership Card"
    Then I should navigate to the Apply Partnership card page
