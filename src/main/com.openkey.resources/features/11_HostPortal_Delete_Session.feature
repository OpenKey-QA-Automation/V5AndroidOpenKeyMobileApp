@SessionDeleteInHostPortal
Feature: Guest session delete from Host Portal

  Scenario: Guest session delete from Host Portal
  As a guest I must be able to receive push notification of session expired When Admin delete guest session from Host Portal

    When Admin selects delete image icon
    Then Session should be expired for this particular guest