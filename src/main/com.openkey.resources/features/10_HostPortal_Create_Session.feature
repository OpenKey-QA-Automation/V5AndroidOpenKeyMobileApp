@SessionCreateInHostPortal
Feature: Create and then delete session of an existing guest

  Scenario: Admin should be able to login

    When Admin selects Add Guest option and provides all valid details
    Then A new session should be created for the guest