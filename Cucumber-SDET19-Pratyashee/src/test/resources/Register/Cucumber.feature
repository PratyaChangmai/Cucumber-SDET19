Feature: To Sign Up and Register for Website Application

Scenario Outline: To register and sign up new user
Given Homepage is in English language
When User clicks on Signup button
And User enters Firstname "<firstname>"
And User enters Lastname "<lastname>"
And User enters Email "<email>"
And User enters Username "<username>"
And User enters Password "<pwd>"
And User enters Confirm Password "<pwd>"
And User clicks Register button
Then User should see Confirmation message for "<firstname>""<lastname>" and Email as "<email>"

When User clicks Compose button in Homepage
And User enters Email details for "<firstname>"
And User clicks on Send button
Then User should receive an Acknowledgment

Examples:
|firstname |lastname|email                 |username      |pwd|
|Pratyashee|Changmai|pratyaTest03@gmail.com|PratyaTester03|Pratya@123|