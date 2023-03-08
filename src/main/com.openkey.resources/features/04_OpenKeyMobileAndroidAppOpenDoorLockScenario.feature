@OpenKeyDoorLockAndroidApp
Feature: Open Door Lock using issued mobile key in OpenKey Mobile App in Android Device

  Scenario: Open Door Lock using OpenKey Mobile App in Android Device
  As a guest I should be able to open door lock using issued mobile key in OpenKey mobile app when I login to OpenKey app in Android Device
    When Guest clicks on Key Icon on My Key Screen
    And It starts scanning locks in range
    Then Access Granted check mark should be displayed
    And Guest should be redirected back to the My Key Screen
    And Verify Push Notification You can also share your key with other guests should be triggered on first time opening door lock

  Scenario: Open Door Lock multiple times using OpenKey Mobile App in Android Device
  As a guest I am opening the door multiple times at regular interval
    When I clicks the main key for given number of times
    Then It should open the lock successfully each time