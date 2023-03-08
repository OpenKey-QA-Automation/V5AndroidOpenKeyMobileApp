@OpenKeyShareKeyAndroidApp
Feature: Sharing Key functionality

  Scenario: Verify Guest is able to share key with additional guests
    When Guest selects Share Key on Active Key Screen
    Then Share Key screen is displayed
    And Verify content on the Share Key Screen

  Scenario Outline: Share key with additional guests
    When Main Guest enters '<name>' '<ctrycode>' and '<mobilenumber>' and taps on Share key button
    Then Success pop up should be displayed

    When Guest selects OK from Success pop up
    Then This guest should be added to the list
    And The additional guest detail name and mobile number should display on share key screen

    When The mobile number already added
    Then A popup saying "Guest has already CheckedIn" should be displayed

    Examples:
      | name    | ctrycode | mobilenumber |
      | Guest 1 | India    | 9960440812   |
      | Guest 2 | India    | 9375612345   |
      | Guest 3 | India    | 8866452357   |
      | Guest 4 | India    | 9375612345   |
      | Guest 5 | India    | 7503322197   |

  Scenario: Removing additional guests

    When Guest selects x to remove the added additional guest
    Then An Alert pup up should be displayed

    When Guest selects Cancel
    Then The additional guest detail item should not be removed from the list

    When Guest selects CONFIRM
    Then The additional guest detail item should be removed from the list

    When Maximum additional guests are added
    Then Remove all the additional guests
    And Navigates back to the main guest to My Key Screen