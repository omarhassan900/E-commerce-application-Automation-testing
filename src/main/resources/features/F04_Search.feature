@smoke
Feature: Search Feature

Scenario:Logged User could search for any product
When navigate to login page
And user try to login with valid user name and password
And search for any product
Then products appeared successfully