@smoke
Feature: Wishlist Feature

  Scenario: Logged user could add different products to Wishlist
When navigate to login page
And user try to login with valid user name and password
And select random category
And select sub category
And select random item
And press add to wishlist button
Then item is added successfully to the wishlist
