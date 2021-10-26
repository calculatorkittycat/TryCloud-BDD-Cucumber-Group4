@smoke
Feature: Story: As a user, I should be able to access to Files module.

Scenario: verify users can delete a file/folder.

Given Login as a user
When user click action-icon from any file on the page
When And user choose "Delete f" option
Then Click "Deleted files" on the left bottom corner
Then Verify the deleted file is displayed no the page.

#(Pre-condition: there should be at least 1 file is uploaded inside files page)