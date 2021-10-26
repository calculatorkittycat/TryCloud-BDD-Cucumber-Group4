@smoke
Feature: Story: As a user, I should be able to access to Files module.


    Scenario: verify users can create a folder
        Given Login as a user
        When Choose a folder from the page
        When Click the “+” icon on top
And Click “New Folder”
Then Write a folder name
Then Click submit icon
Then Verify the folder is displayed on the page


    Scenario: verify users can upload a file inside a folder

Given Login as a user
When Choose a folder from the page
When Click the “+” icon on top
And Click “upload file”
Then Upload a file
Then Verify the file is displayed on the page
#(Pre-condition: there should be at least 1 folder is created on the filers page)