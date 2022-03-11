Feature: To verify the DFOW feature


 @DFOW @Regression
  Scenario: To navigate to DFOW feature
    Given User clicks settings button
    And User scrolls in the settings menu
    And User clicks the DFOW from the menu
    Then DFOW page should be displayed
    
  @DFOW @Regression
  Scenario: Add DFOW list
    Given User clicks add row
    And User adds DFOW list
    And User clicks the save button
    Then DFOW list should get added

  @DFOW @Regression
  Scenario: Import DFOW list
    Given User clicks import button
    And User clicks browse files
    And User selects file to upload
    And User clicks the save button
    Then DFOW list should get added

  @DFOW @Regression
  Scenario: Export DFOW list
    Given User exports the DFOW list
