Feature: User logins
  User uses email and password to login

  Scenario Outline: Enter correct email, correct password and press login
    When I enter <email>
    And I enter <password>
    And I press button login
    Then I should be told "<answer>"

    Examples:
      | email | password | answer |
      | kcpmt2@gmail.com | 123456 | Success |
      | kcpct2@gmail.com | 123456 | Fail |
      | hoami123@gmail.com | hoami | Success |
      | kcpmt2@yahoo.com | 123456 | Fail |