Feature: To verify the Login feature

  @Login @Regression @ForgotPassword @dummy @dummy3
  Scenario: Launch the app URL and navigate to login page
    Given User launching the web url
    And User clicks the Login button
    Then User should see login page

  @Login @Regression @dummy @dummy3
  Scenario: Entering the login credentials
    Given User enter mail Id and password
    And User clicks the Login button
    Then User should see the login success message

  @ForgotPassword @Company
  Scenario: User opts for forgot password link
    Given User clicks forgot password
    And User enters mailId in the email feild
    And User clicks the submit button
    Then User should success message
