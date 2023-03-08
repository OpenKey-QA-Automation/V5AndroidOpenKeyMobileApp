package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/** OpenKey Guest Mobile Android App Download Mobile Key Screen */
public class OpenKeyDownloadMobileKeySteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver, mqttClient);
    }

    @When("^Guest is downloading key$")
    public void guest_is_downloading_key() {

        openKeyDownloadMobileKeyScreen.verifyKeyDownloadingScreen();
        System.out.println("Digital Mobile Key is getting downloaded");
        allureReportingManager.stepsScreenshots();
    }

    @Then("^My Key Screen should be displayed$")
    public void my_key_screen_should_be_displayed() {

        openKeyDownloadMobileKeyScreen.verifyActiveKeyScreen();
        System.out.println("Digital key Downloaded Successfully");
        System.out.println("My Key Screen should be displayed");
        allureReportingManager.stepsScreenshots();

    }

    @And("^Get push notification saying you have access to Room Number$")
    public void get_push_notification_saying_you_have_access_to_room_number() {

        openKeyDownloadMobileKeyScreen.verifyPushNotificationForAccess();

    }

    @And("^Guest has access to room$")
    public void guest_has_access_to_room() {

        openKeyDownloadMobileKeyScreen.verifyAccessToRoomNumber();
        allureReportingManager.stepsScreenshots();

    }

    @And("^On the My Key Screen Welcome To Hotel Name and Room Number should be displayed$")
    public void on_the_my_key_screen_welcome_to_hotel_name_and_room_number_should_be_displayed() {

        openKeyDownloadMobileKeyScreen.verifyContentOnActiveKeyScreen();
        System.out.println("On the My Key Screen Welcome To Hotel Name and Room Number should be displayed");
        allureReportingManager.stepsScreenshots();

    }
}


