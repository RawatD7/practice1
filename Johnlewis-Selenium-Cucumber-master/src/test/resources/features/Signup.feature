
@temp1
Feature: Sign up
  As a user
  I want to sign up for latest news ,offers and ideas
  So that I get notified with latest offers and ideas

  Scenario Outline: Signup for latest ,news,offers
    Given I am on home page
    When I enter "<Email>"
    And I click on sign up button
    Then I should get the "<Message>"

    Examples: Valid Email
      | Email                   | Message                                                      |
      | rawatdeepika7@gmail.com | Than you, you have been successfully added to our email list |

    Examples: Invalid Email
      | Email | Message                         |
      |       | Please Enter your Email address |
