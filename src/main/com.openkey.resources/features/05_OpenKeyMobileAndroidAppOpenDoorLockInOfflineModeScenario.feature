@OpenKeyDoorLockInOfflineModeAndroidApp
Feature: Open Door Lock using issued mobile key in OpenKey Mobile App in Android Device

  Scenario: Open Door Lock in Offline Mode using OpenKey Mobile App in Android Device
  As a guest I should be able to open door lock in offline mode using issued mobile key in OpenKey mobile app when I login to OpenKey app in Android Device
    When Guest device does not connected with Networks
    And Bluetooth is on
    And Clicks on Key Icon on My Key Screen
    And Scanning locks in range
    Then Door Opened and Access Granted check mark should be displayed

  Scenario: Open Door Lock multiple times in Offline Mode  using OpenKey Mobile App in Android Device
  As a guest I am opening the door multiple times at regular interval in Offline Mode
    When I clicks the main key for given number of times in Offline Mode
    Then It should open the lock successfully each time in Offline Mode
    And Guest navigates back to the My Key Screen
    And Verify Push Notification You can also share your key with other guests should not be triggered