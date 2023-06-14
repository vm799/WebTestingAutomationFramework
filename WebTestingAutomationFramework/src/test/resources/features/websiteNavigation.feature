Feature: As a user of 'automationexercise' website, I’d like to be able to safely log out of my account.
  Scenario: Navigate from the homepage of website
    Given I am on the automationexercise website homepage
    When I click on SignupLogin button
    Then I can see the login page

  Scenario: Login with correct credentials
    Given I am on the automationexercise website homepage
    When I am on the login page
    And I enter username
    And enter password
    And click on Login
    Then I can see Logged in as username

  Scenario: After logout, redirect to Login page
    Given I am on the automationexercise website homepage
    When I am on the login page
    And I enter username
    And enter password
    And click on Login
    And I click on logout button
    Then I can see the login page  after logout