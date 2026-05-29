@Login 
Feature: Login functionality

	@UserLogin
  Scenario Outline: Valid login for User
    Given I open the login page
    When I enter valid "<username>" and "<password>"
    And I click the login button
    Then I should be redirected to the inventory page

	Examples:
	| username | password |
	| standard_user | secret_sauce |
	