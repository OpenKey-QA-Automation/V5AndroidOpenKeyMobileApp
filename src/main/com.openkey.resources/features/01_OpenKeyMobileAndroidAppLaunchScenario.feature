@LaunchOpenKeyAndroidApp
Feature: Launch OpenKey Mobile App in Android Device

  Scenario: Launch OpenKey App in Android Device
    As a guest I should be able to launch OpenKey mobile app when I install OpenKey app in Android Device
    Given OpenKey App is Launched
    When Allow Notifications
    Then Enter Mobile Number Screen should be displayed

#  @Precondition
#    Given environment "Dev" from "ok-envds.yaml"
#
#  @Install_OpenKey_App
#
#  @Launch_OpenKey_App
#    Given UI connection to "OpenKeyAndroidApplication"
#    When I run application with "OpenKeyAndroidApplication"
#    Then "OkGuestAndroidApp Login Screen" should be displayed
#
#  @Select_UUID
#    When I click on "OkGuestAndroidApp UUID Listbox"
#    And I type value "Graduate Hotel"
#    Then "Graduate Hotel" should be displayed in "OkGuestAndroidApp UUID"
#
#  @Login_with_MobileNumber
#    Given 'mobilenumber' default value is "«credentials.GuestMobileNumber.mobilenumber»"
#    When I click on "OkGuestAndroidApp Select Country Code"
#    And I type value "+1"
#    And I click on "OkGuestAndroidApp Enter Mobile Number Field"
#    And I type "«mobilenumber»"
#    And I click on "OkGuestAndroidApp Sign-In Button"
#    Then "OkGuestAndroidApp Enter Verification Code Screen" should be displayed
#
#  @DownloadMobileKey
#    When I click on "OkGuestAndroidApp Enter Verification Code Field"
#    And I type "«otp»"
#    And I click on "OkGuestAndroidApp Get the Key button"
#    Then "OkGuestAndroidApp Downloading Key Screen" should be displayed
#    And I wait until "OkGuestAndroidApp My Key Screen" should be displayed
#
#  @Post_Test_Execution_Cleanup