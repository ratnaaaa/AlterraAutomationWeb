Feature: Orange HRM - Login

  @hrmlogin
  Scenario: user Login Orange
    Given I open Orange HRM login page
    When I input username and password
    And I click login button
    Then I can login successfully