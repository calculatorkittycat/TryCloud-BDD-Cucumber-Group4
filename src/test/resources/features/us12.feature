@smoke
Feature: As a user, I should be able to access to Contacts module.

  Background:
    Given user is on login page




  Scenario Outline: AC#1 - verify users can access to Talks module

    And user provides valid "<username>" and "<password>"
    When user clicks on Contacts module
    Then user verifies the page title is Contents module's title
    Examples:
      | username | password    |
      | User3    | Userpass123 |
      | User33   | Userpass123 |
      | User63   | Userpass123 |
      | User93   | Userpass123 |


  @us12
  Scenario Outline: AC#2 - verify user can add contacts
    And user provides valid "<username>" and "<password>"
    When user clicks on Contacts module

    And user clicks on New Contact button
    When user fills out the contact info like: Title, Phone, email, address, etc
    Then user verifies the contact name is added to the contact list
    Examples:
      | username | password    |
      | User3    | Userpass123 |
      | User33   | Userpass123 |
      | User63   | Userpass123 |
      | User93   | Userpass123 |