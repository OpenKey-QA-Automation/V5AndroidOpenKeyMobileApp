@LoginToOpenKeyAndroidApp
Feature: Login to OpenKey Mobile App in Android Device

  Scenario: Login to OpenKey App in Android Device
  As a guest I should be able to login to OpenKey mobile app when I entered registered mobile number to OpenKey app in Android Device
    Given If any previous notifications clear all notifications from notifications bar
    When Guest select Country Code
    And Guest entered invalid mobile number
    Then The number you have entered is invalid. Please enter a valid phone number error alert prompt should be displayed

    When Guest entered register mobile number
    And Guest click on Request Verification Code Button
    Then Enter Verification Code Screen should be displayed

    When Read the Verification Code from text message
    And Guest click on Get My Key Button
    Then Downloading Key Screen should be displayed