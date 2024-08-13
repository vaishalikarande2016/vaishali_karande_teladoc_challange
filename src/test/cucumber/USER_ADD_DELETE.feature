#Author: Vaishali karande

@tag
Feature: ADD and DELETE User from table
  

  @ADD
  Scenario Outline: Scenario 1
    Given Add user
    |FirstName|<FirstName>|
    |LastName|<LastName>|
    |UserName|<UserName>|
    |Email|<Email>|
    |MobilePhone|<MobilePhone>|
    |RoleId|<RoleId>|    
    Then validate the user has been added to the table  
    |UserName|<UserName>|
   
    Examples:
    |FirstName|LastName|UserName|Email|MobilePhone|RoleId|
    |test23|test|test123|test@domain.com|1234567812|Customer|
   
  @DELETE
  Scenario Outline: Scenario 2
    Given Delete the user "<UserName>" from the table   
    Then validate the user has been deleted
    |UserName|<UserName>|
    
    Examples:
    |UserName|
    |novak|

