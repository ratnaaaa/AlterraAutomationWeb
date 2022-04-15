Feature: facebook login
  As a user
  I want to perform login on facebook
  but I can't see my news feed due to FB restriction

@FBlogin
  Scenario: user failed login facebook
    Given I open facebook login page
    When I input email and password
    And I click button login
    Then I can't see my news feed
    But I see Facebook has disabled my account