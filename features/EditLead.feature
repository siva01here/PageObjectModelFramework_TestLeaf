Feature: Edit Lead Feature

@Functinoal
Scenario Outline: Verify edit lead functionality

Given User is on the login page of the application
When User enters the username as 'Demosalesmanager'
And User enters the password as 'crmsfa'
And User clicks on the login button
Then Home page of the application should be displayed
When User clicks on the CRMSFA link
And  User clicks on Leads link
And User clicks on Create Lead link
And User enters the company name as '<companyName>'
And User enters the first name as '<firstName>'
And User enters the last name as '<lastName>'
And User clicks on Create Lead button
Then Lead should be created successfully
And Lead should have the company name as '<companyName>'
And Lead should have the first name as '<firstName>'
And Lead should have the last name as '<lastName>'
When User clicks on Edit lead button
And User updates the description as '<description>'
And User clicks on update button
Then Updated descirption is displayed as '<description>' on the view lead page


Examples:
| companyName | firstName | lastName | description |
| HTC | John | Harry | US Based MNC |