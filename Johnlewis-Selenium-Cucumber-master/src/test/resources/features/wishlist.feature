
@perm
Feature: Adding Items to the wish list
  As a user 
  I want to add the selected item in the wish list
  So that I can buy that later

  Scenario: Verify user can add the selected item in the wish list successfully
    Given I shoulld be on the home page
    When I Search for the required item "purses"
    And I click on item "John Lewis Emma Leather Medium Flapover Purse, Blue"
    And I click on the  Signin to Add to wishlist
    And I click on wishList link after sign in
    Then I can see the selected item in the WishList 
