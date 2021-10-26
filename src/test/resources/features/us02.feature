  #I had to change "Talk" to "Spreed" in the table of expected modules
  # I had to do this because the only way I was able to validate the modules was by the href value
    # all the other expected module names had their names in the link of the icons
    # all except for talk which href value washttp://qa2.trycloud.net/index.php/apps/spreed/
    #whereas if the link was formatted like the others, being consistent with their link text
    # and link value it would have been http://qa2.trycloud.net/index.php/apps/talk/
  @smoke
  Feature: As a user, I should be access all the main modules of the app.

    Scenario Outline: Verify modules

      Given user is on the login page
      When user enter valid "<username>" and "<password>"
      And user click login button
      Then Verify user launched to the dashboard
      Then Verify the user sees the following modules
        | Dashboard |
        | Files     |
        | Photos    |
        | Activity  |
        | Spreed    |
        | Contacts  |
        | Circles   |
        | Calendar  |
        | Deck      |
      Then TEST user logs out

      Examples:
        | username | password    |
        | User3    | Userpass123 |
        | User33   | Userpass123 |
        | User63   | Userpass123 |
        | User93   | Userpass123 |



