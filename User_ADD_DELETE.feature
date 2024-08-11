
Feature: Verify addition and deletion of user
  

  Scenario: Add a user and validate the user has been added to the table
  Given Add user
  Then Verify user is added
   

  Scenario: Delete the user "novak" from the table and validate the user has been deleted 
    Given Delete user
    Then Verify user is deleted
  