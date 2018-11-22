Feature: User logins
	User uses email and password to login

 	Scenario Outline: Enter correct email, correct password and press login
	Given I enter email and password "<email>" "<password>"
	When I press button login
	Then I should be told "<answer>"

	Examples:
		| email | password | answer |
		| kcpm@gmail.com | qwerty | Success |
		| hoami@gmail.com | hoami | Success |
		| ecec@gmail.com  | ecec  | Fail    |
		| | ecc   | Email can not be empty |
		| ecec@gmail.com | | Password can not be empty |
