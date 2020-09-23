Feature: Register and login feature
  This feature includes scenario that would validate the following features.
  1. Navigate to website
  2. Register the user
  3. Click on the icon and check if the registered user is logged in
Scenario: Register User
  Given User should be able to navigate to homepage
  When User click on the signup link
  And User enters mandatory details and click Signup button
  Then User should be registered and loggedin



