@OpenKeyWelcomeMessageAndroidApp
Feature: Verify Text message which appears after creating session for a Guest through OpenKey Host portal

  Scenario: As a guest I should be getting welcome message to mobile number entered while creating the session

    When Session is started for a Guest
    Then Guest should receive welcome text message

    When Guest clicks message notification
    Then Guest should be navigated to screen where Welcome message is open

    When Guest clicks app download link available in Welcome Message
    Then User should be able to install the build using app download link