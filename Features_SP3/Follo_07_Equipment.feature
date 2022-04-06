Feature: To verify the Equipment feature

  @Equipment @Regression @dummy @dummy3
  Scenario: To click equipment button from the menu
    Given User clicks equipment button

  @Equipment @Regression @dummy 
  Scenario: To add equipments
    Given User adds new equipment

  @Equipment @Regression
  Scenario: Edit a equipment from the list
    Given User edit a equipment from the list

  @Equipment @Regression @dummy3
  Scenario: Filter equipment based on equipment name
    Given User filter the company based on equipment name

  @Equipment @Regression 
  Scenario: Search equipment
    Given User search and view the equipment

  @Equipment @Regression
  Scenario: Delete a equipment from the list
    Given User delete a equipment from the list

  @Equipment @Regression
  Scenario: Delete all equipments
    Given User selects all equipment
    And User clicks remove button and click yes from the equipment popup
    Then All the equipment should be deleted
