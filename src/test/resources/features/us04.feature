@smoke
Feature: As a user, I should be able to add file to favorites

Scenario Outline: user can add file to favorites

  Given  user is on the login page
  When user enter valid "<username>" and "<password>"
  And user click login button
  And User click Files module
  And User click Action icon button
  And user click Add to Favorites
  Then file added to Favorites


  Examples:
    | username | password    |
    | User3    | Userpass123 |
    | User33   | Userpass123 |
    | User63   | Userpass123 |
    | User93   | Userpass123 |
