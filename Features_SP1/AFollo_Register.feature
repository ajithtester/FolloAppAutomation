Feature: To verify the Register feature

  @Register 
  Scenario: Launch the app URL and navigate to register popup
    Given User launching the app url
    And User clicks the get-started button
    Then User should see welcome popup

  @Register 
  Scenario: Filling the mailId and phone number
    Given User enter mail Id and Phone number
    And User Clicks the continue button
    Then User should see the basic details popup

  @Register 
  Scenario: Filling the basic details
    Given User fills the basic details and clicks continue button
    Then User should see the project details popup

  @Register 
  Scenario: Filling the project details
    Given User fills the project name and address
    And User click next button
    Then User should see the subscription plan page

  @Register 
  Scenario: User selects the subscription plan
    Given User selects the subscription plan
    Then User should redirected to the login page
