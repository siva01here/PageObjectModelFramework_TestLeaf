Feature: Login logout with invalid credentials

@Smoke
Scenario Outline: Verify login functionality with different combinations

Given User is on the login page of the application
When User enters the username as '<username>'
And User enters the password as '<password>'
And User clicks on the login button
Then Error message should be displayed on the application

Examples:
| username | password |
| demouser | crmsfa |
| DemoCSR | Test123 |
| | crmsfa |
| DemoCSR | |