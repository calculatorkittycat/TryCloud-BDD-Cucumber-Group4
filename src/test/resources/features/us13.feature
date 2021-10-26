@smoke
Feature: As a user, I should be able to access to Contacts module. -ivan

  Scenario Outline:
    Given user is on the login page
    When user enter valid "<username>" and "<password>"
    And user click login button
    Then Verify user launched to the dashboard
    When user Click contacts module
    Then Verify the contact names are in the list
    Then TEST user logs out

    Examples:
      | username | password    |
      | User3    | Userpass123 |
      | User33   | Userpass123 |
      | User63   | Userpass123 |
      | User93   | Userpass123 |