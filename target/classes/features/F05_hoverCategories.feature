@smoke
Feature: Select Category Feature


  Scenario: Logged user could select different Categories
When navigate to login page
And user try to login with valid user name and password
And select random category
And select sub category
Then category selection done successfully