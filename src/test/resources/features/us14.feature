@smoke
Feature: As a user, I should be able to access search any item/ users from the homepage.

  Scenario Outline: whatever

    Given user is on the login page
    When user enter valid "<username>" and "<password>"
    And user click login button
    Then Verify user launched to the dashboard
    When Search any existing file folder user name
    Then Verify the app displays the expected result option


    Examples:
      | username | password    |
      | User3    | Userpass123 |
