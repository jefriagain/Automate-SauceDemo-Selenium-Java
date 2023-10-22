Feature: Login Page SauceDemo

  @Login @Positive
  Scenario: Success login
    Given Login page sauceDemo
    When User input username
    And User input password
    And Click login button
    Then User is on home page

  @Login @Negative
  Scenario: Failed login
    Given Login page sauceDemo
    When User input username
    And User input invalid password
    And Click login button
    Then User get error message
