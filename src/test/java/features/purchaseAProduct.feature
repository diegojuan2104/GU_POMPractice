Feature: Purchase a product
  As a user
  I want to follow the complete buyflow
  So that I can purchase a product successfully

  Background:
    Given I am logged in to the system

  Scenario: Purchase a product successfully
    Given I select a random product
    And I add the product to the cart
    And I add personal data for the purchase
    And I proceed to checkout
    Then I should see the "Thank you for your order!" page