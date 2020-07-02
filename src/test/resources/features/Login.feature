@login @smoke
Feature: User should be able to log in
  @wip
  Scenario: user should log in with valid credentials
    Given navigate to login page
    When user enter "HR" credentials and click login button
    Then user should be logged in

    @wip1
    Scenario Outline: <usertype>
      Given navigate to login page
      When user enter "<usertype>" credentials and click login button
      Then user should be logged in
      Examples:
        | usertype  |
        | HR        |
        | marketing |
        | helpdesk  |
        |           |
        | user1     |




