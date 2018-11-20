Feature: User logins
  User uses email and password to login

  Scenario: Enter correct email, correct password and press login
    When I enter email "kcpm@gmail.com"
    And I enter password "qwerty"
    And I press button login
    Then I should be told "Success"