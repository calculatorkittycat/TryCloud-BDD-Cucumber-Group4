@smoke
Feature: Access files module function test
  As a user
  I should be able to able to access to Files module.

  Background:
    Given Login as a user

  Scenario: Verify users can remove a file from favorites.
    When Click action-icon from any file on the page
    And Click “Remove from Favorites” option
    Then Verify that the file is removed from Favorites sub-module’s table.
#(Pre-condition: there should be at least 1 file is added to favorites table)

  Scenario: Verify users can upload a file directly to the homepage (File-Uploading)
    When Click the “plus+” icon on top
    And Click “upload file”
    And Upload a file
    Then Verify the file is displayed on the page