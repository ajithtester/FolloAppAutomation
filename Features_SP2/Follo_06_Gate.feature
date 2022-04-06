Feature: To verify the Gate feature

  @Gate @Regression @dummy
  Scenario: To add gates
    Given User clicks gate button
    And User adds new gate

  @Gate @Regression 
  Scenario: Edit a gate from the list
    Given User edit a gate from the list

  @Gate  @Regression 
  Scenario: Search gate
    Given User search and view the gates

  @Gate @Regression 
  Scenario: Delete a gate from the list
    Given User delete a gate from the list

  @Gate 
  Scenario: Delete all gates from the list
    Given User select all gates
    When User clicks remove button and click yes from the delete popup
    Then All the gates should be deleted
