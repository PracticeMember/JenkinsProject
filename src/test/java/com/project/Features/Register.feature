Feature: User Registration

@Register
Scenario: User should be able to create an account 
Given User navigates to the magento website
When User clicks on create an account link
Then  registration form would open
Then  User would enter firstname
Then  User would enter lastname
Then  User would enter email
Then  User would enter password and confirms it
#Then  clicks on signin button 
#Then  User should be able to see registration success message 
    