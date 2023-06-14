Feature: As a user, I’d like to be able to remove items from my cart if I don’t want an item anymore.
  Scenario: Adding products to the cart
    Given I am on the automationexercise website homepage
    When I find the product I want
    And I click on the add to cart button
    Then I should see the message "Added!"

  Scenario: View what is in the cart
    Given I am on the automationexercise website homepage
    When I click on the cart icon
    Then I should be able to see a summary of the items in my cart

  Scenario: Remove the product from the cart
    Given I am on the automationexercise website homepage
    When I click on the cart icon
    And I click on the X button
    Then I will see the message "Cart is empty!"
