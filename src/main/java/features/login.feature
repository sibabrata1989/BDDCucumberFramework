Feature: CRM Login Feature

Scenario: CRM Login Test Scenario

Given user is already on Login Page
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page

Examples:
	| username | password |
	| naveenk  | test@123 |
	|  tom     | test456  | 	
		