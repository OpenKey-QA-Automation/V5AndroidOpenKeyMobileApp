@SessionDeletedScenarioInApp

Feature: Session deleted scenario in OpenKey Mobile App in Android Device

  Scenario: Guest should get push notification and should be redirected to feedback screen when session is deleted from host portal

    When Session is deleted for the guest from Host Portal
    Then The guest should get key expired push notification

    When Guest taps on the notification
    Then Guest should be redirected to feedback screen

    When user is on Feedback screen
    Then verify content on feedback screen
    And feedback is submitted successfully

