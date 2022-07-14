@smoke
Feature: Shopping Cart Feature

  Scenario:Logged user could add different products to Shopping cart
    When navigate to login page
    And user try to login with valid user name and password
    And select random category
    And select sub category
    And select random item
    And add item to chart
    Then item is added successfully