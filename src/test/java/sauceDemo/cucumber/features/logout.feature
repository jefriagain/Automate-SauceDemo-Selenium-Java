Feature: Logout from SauceDemo

  @Logout
  Scenario: Success logout from SauceDemo
    Given User already login for logout
    When User click burger menu button
    And User click logout
    Then User back to login page