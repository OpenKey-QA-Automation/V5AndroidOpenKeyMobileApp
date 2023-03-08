@MoreMenuAndroidApp
Feature: Navigate through 'More' menu items and verify underlying functionality of each Menu item

  Scenario: Access More menu
  As a guest I should be able to access the More menu in OpenKey mobile app when I login to OpenKey app in Android Device

    Given Dashboard screen with Footer Menu is shown
    When Guest clicks on Wifi menu
    Then WiFi Screen should be displayed

    When Guest clicks on More menu
    Then All More menu items should be displayed

    When Guest clicks on Hotel Information option in More menu
    Then Hotel information screen features should be functional

    When Guest clicks on Promotions option in More menu
    Then Promotions screen features should be functional

    When Guest clicks on Express Checkout option in More menu
    Then Feedback screen should be displayed

    When Guest selects one of the happy neutral and sad emojis
    And Guest submits the happy feedback with comment or clicks Skip
    Then Guest should be navigated back to the Hotel Search screen
