Feature: To verify the Login feature

  @Login @Regression
  Scenario: Launch the app URL and navigate to login page
    Given User launching the web url
    And User clicks the Login button
    Then User should see login page

 
   @Login @Regression
  Scenario: Entering the login credentials
    Given User enter mail Id and password
    And User clicks the Login button
    Then User should see the login success message
    
