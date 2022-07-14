@smoke
Feature: Change Currency Feature


  Scenario: logged in user change currency from US to Euro
When navigate to login page
And user try to login with valid user name and password
And change the currency
Then currency changed successfully
