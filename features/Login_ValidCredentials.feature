Feature: Login, Logout feature of application

@Smoke @Functional @Regression
Scenario: Verify login, logout functionalities of the application with valid credentials

Given User is on the login page of the application
When User enters the username as 'Demosalesmanager'
And User enters the password as 'crmsfa'
And User clicks on the login button
Then Home page of the application should be displayed
When User clicks on the logout button
Then Login page of the application should be displayed

@Smoke @Functional @Regression
Scenario Outline: Verify login, logout functionality with multiple valid credentials

Given User is on the login page of the application
When User enters the username as '<username>'
And User enters the password as '<password>'
And User clicks on the login button
Then Home page of the application should be displayed
When User clicks on the logout button
Then Login page of the application should be displayed 

Examples:
| username | password |
| Demosalesmanager | crmsfa |
| DemoCSR | crmsfa |

