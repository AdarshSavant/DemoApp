Feature: Login page Automation of DemoApp

Scenario: Check login is successful with valid credential

Given User is on login page

When User enters valid username and password 

And Clicks on Login Button 

Then User is navigated to Home page

And Close the browser