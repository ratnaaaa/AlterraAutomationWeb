@all @hrmcrud
Feature: Orange HRM -CRUD Employee Data

  Background:
    Given I open Orange HRM login page
    When I input username and password
    And I click login button
    And I access employee list

  @hrmcreate
  Scenario: User add Orange HRM employee successfully
      When I add new employee with required field only
      Then I can see my Personal Details

  @hrmread
  Scenario: user read Orange HRM employee list successfully
      Then I can see new employee list result

  @hrmupdate
  Scenario: user update Orange HRM employee successfully
      When I search for new employee
      And I update new employee's middle name
      Then I can see the Personal Details has Changed

  @hrmdelete
  Scenario: user delete Orange HRM employee successfully
      When I search for new employee
      And I delete new employee
      Then I can't see deleted employee on list
