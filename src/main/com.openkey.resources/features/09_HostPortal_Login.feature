@LoginToHostPortal
Feature: Login to host portal

  Scenario: Admin should be able to login

    When The login page of host portal opens
    And Admin enters valid username and password
    Then The dashboard screen should open
