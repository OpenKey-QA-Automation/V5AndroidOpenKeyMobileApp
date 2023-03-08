package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

/** OpenKey Guest Mobile Android App Welcome Message */
public class OpenKeyWelcomeMessageSteps extends BaseSteps{

    @Before
    public void setupSteps() {

        setupScreens(driver, mqttClient);
    }

    @When("^Session is started for a Guest$")
    public void session_is_started_for_a_guest() throws InterruptedException, IOException {

        hostPortalLogin.hostPortalLoginScreen();
        hostPortalCreateSessionScreen.createNewSession();
        System.out.println("Session is started for the Guest through Host Portal");

    }

    @Then("^Guest should receive welcome text message$")

    public void guest_should_receive_welcome_text_message() {

        openKeyWelcomeMessageScreen.verifyWelcomeMessageNotification();
        //logger.info( "Welcome Text Message");
    }

    @When("^Guest clicks message notification$")
    public void guest_clicks_message_notification() {

        openKeyWelcomeMessageScreen.verifyWelcomeNotificationClick();

    }

    @Then("^Guest should be navigated to screen where Welcome message is open$")
    public void guest_should_be_navigated_to_screen_where_welcome_message_is_open() {

        openKeyWelcomeMessageScreen.verifyWelcomeMessageBody();
    }

    @When("^Guest clicks app download link available in Welcome Message$")
    public void guest_clicks_app_download_link_in_welcome_message() throws InterruptedException {

        openKeyWelcomeMessageScreen.verifyAppLanuchFrmDownloadLink();
    }

    @Then("^User should be able to install the build using app download link$")
    public void user_should_be_able_to_install_the_build_using_appDownloadLink() {

        System.out.println("User should be able to install the build using app download link");
        allureReportingManager.stepsScreenshots();
    }

}
