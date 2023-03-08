@OpenKeyHamburgerMenuAndroidApp
Feature: Navigate through all the Hamburger menu items and verify underlying functionality of each Menu item

  Scenario: Access Hamburger menu
    As a guest I should be able to access the Hamburger menu in OpenKey mobile app when I login to OpenKey app in Android Device

    Given User is on Dashboard screen
    When Guest clicks on Hamburger menu
    Then All menu items should appear enabled

    When Guest clicks on 'SEARCH HOTELS' menu item
    Then 'SEARCH HOTELS' screen features should be functional

    When Guest clicks on 'SETTINGS' menu item
    Then 'SETTINGS' screen features should be functional

    When Guest clicks on 'LEARN MORE' menu item
    Then 'LEARN MORE' screen features should be functional

    When Guest clicks on 'CALL HOTEL' menu item
    Then 'CALL HOTEL' screen features should be functional

    When Guest clicks on 'PRIVACY POLICY' link
    Then 'PRIVACY POLICY' link should be functional

    When Guest clicks on 'TERMS OF USE' link
    Then 'TERMS OF USE' link should be functional