Feature: User should make an order

  Scenario: User creates resolve problem ticket
    Given the user is logged in
    When navigate to "Services" tab and enter "e-Orders" module
    Then verify that user on the "e-Orders" page
    And user creates a ticket under "resolve problems"


