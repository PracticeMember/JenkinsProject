@Login 
Feature: Login functionality

  Scenario: Valid login
    Given I open the login page
    When I enter valid credentials
    And I click the login button
    Then I should be redirected to the inventory page


    