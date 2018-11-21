Feature: User logins
  User uses email and password to login

  (@login-feature)
  Scenario Outline: Enter correct email, correct password and press login
    When I enter email "<email>"
    And I enter password "<password>"
    And I press button login
    Then I should be told "<answer>"

    Examples:
    | email | password | answer |
    | kcpm@gmail.com | qwerty | Success |
    | hoami@gmail.com | hoami | Success |
    | ecec@gmail.com  | ecec  | Fail    |
