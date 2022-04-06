Feature: To verify the Company feature

  @Company @Regression @dummy
  Scenario: To navigate to Company feature
    Given User clicks Company button
    And User add new company

  @Company @Regression 
  Scenario: Search Company
    Given User search and view the company

  @Company @Regression 
  Scenario: Edit a Company from the list
    Given User edits a Company from the list

  @Company @Regression 
  Scenario: Filter Company
    Given User search and filter the company

  @Company @Regression
  Scenario: Delete a Company from the list
    Given User deletes a Company from the list

   @Company
  Scenario: Delete all Companies from the list
    Given User selects all Companies
    And User clicks remove button and click yes in company delete popup
    Then All the Companies except parent company is deleted
