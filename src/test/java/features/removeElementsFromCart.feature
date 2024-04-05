Feature: Removing elements from the shopping cart
  As a shopper
  I want to remove items from the shopping cart
  So that I can ensure the cart becomes empty

  Scenario: Remove items from the shopping cart
    Given I am logged in to the system to select items random items
    When I have added 3 different elements to the shopping cart
    And I go to the cart page
    And I remove all items from the cart
    Then the shopping cart should be empty