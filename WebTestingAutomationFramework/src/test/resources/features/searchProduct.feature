Feature: As a user of 'automationexercise' website, I want to be able to search for products
  Scenario: Navigate from the homepage navbar to product page
    Given I am on the automationexercise website homepage
    When I click products link
    Then I go to products page

  Scenario: Typing in the search field returns the correct results
    Given