Feature: To verify the Company feature

  @Company @Regression
  Scenario: To navigate to Company feature
    Given User clicks Company button
    And User clicks new company button
    And User fills the company details
    And User clicks sumbit button
    Then User should see the success message