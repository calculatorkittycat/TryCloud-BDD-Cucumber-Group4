@smoke
Feature: As a user, I should be able to access to Files module.

  Background:
    Given user is on the login page

  Scenario Outline: Verify the page title
    When user enter valid "<username>" and "<password>"
    And user click login button
    Then User click Files module
    And Verify the page title is "Files - Trycloud"
    Examples:
      | username | password    |
      | User3    | Userpass123 |
      | User33   | Userpass123 |
      | User63   | Userpass123 |
      | User93   | Userpass123 |

    Scenario Outline: Verify users can select all the uploaded files
      When user enter valid "<username>" and "<password>"
      And user click login button
      Then User click Files module
      And click the checkbox of the table
      Then Assert all the files are selected
      Examples:
        | username | password |
        | User3    | Userpass123 |
        | User33   | Userpass123 |
        | User63   | Userpass123 |
        | User93   | Userpass123 |
