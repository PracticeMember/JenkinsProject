Feature: User Login

@Login 
Scenario: User should be able to login
Given User navigates to the magento website
When User clicks on Sign In link
Then  login form would open
Then  User would enter login email
Then  User would enter login password
Then  clicks on signIn button 
Then  User should be able to land on homepage 


    