@smoke
Feature: As a user, I should be able to login

Background:
  Given user is on the login page

  Scenario Outline:

    When user enter valid "<username>" and "<password>"
    And user click login button
    Then Verify user launched to the dashboard
    Then TEST user logs out

    Examples:
      | username | password    |
      | User3    | Userpass123 |
      | User33   | Userpass123 |
      | User63   | Userpass123 |
      | User93   | Userpass123 |

  Scenario: verify user login fail with invalid credentials

    When user enter invalid credentials
    And user click login button
    Then “Wrong username or password.” message should be displayed



