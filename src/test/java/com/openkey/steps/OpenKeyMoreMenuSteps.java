package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/** OpenKey Guest Mobile Android App More Menu */
public class OpenKeyMoreMenuSteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver, mqttClient);
    }

    @Given("^Dashboard screen with Footer Menu is shown$")

    public void dashboard_screen_with_footer_menu_is_shown() {

        System.out.println("Footer Menu is shown over Dashboard Screen");
        allureReportingManager.stepsScreenshots();
    }

    @When("^Guest clicks on Wifi menu$")

    public void guest_clicks_on_wifi_menu() {

        openKeyMoreMenuScreen.verifyWifiFooterMenu();

    }

    @Then("^WiFi Screen should be displayed$")

    public void wifi_screen_should_be_displayed() {

        openKeyMoreMenuScreen.verifyWifiScreenActions();

    }

    @When("^Guest clicks on More menu$")
    public void Guest_clicks_on_More_menu() {

        openKeyMoreMenuScreen.verifyMoreMenu();

    }

    @Then("^All More menu items should be displayed$")

    public void all_more_menu_items_should_be_displayed() {

        openKeyMoreMenuScreen.verifyMoreMenuActions();

    }

    @When("^Guest clicks on Hotel Information option in More menu$")

    public void guest_clicks_on_Hotel_information_option_in_more_menu() {

        openKeyMoreMenuScreen.verifyHotelInformationOption();

    }

    @Then("^Hotel information screen features should be functional$")

    public void hotel_information_screen_features_should_be_functional() throws InterruptedException {

        openKeyMoreMenuScreen.verifyHotelInformationActions();

    }

    @When("^Guest clicks on Promotions option in More menu$")

    public void guest_clicks_on_promotions_option_in_more_menu() {

        openKeyMoreMenuScreen.verifyPromotions();

    }

    @Then("^Promotions screen features should be functional$")

    public void promotions_screen_features_should_be_functional() {

        allureReportingManager.stepsScreenshots();
    }

    @When("^Guest clicks on Express Checkout option in More menu$")

    public void guest_clicks_on_express_checkout_option_in_more_menu() {

        openKeyMoreMenuScreen.verifyExpressCheckoutOption();

    }

    @Then("Feedback screen should be displayed")
    public void feedback_screen_should_be_displayed() {

        openKeyMoreMenuScreen.verifyExpressCheckoutScreenItems();

        openKeyMoreMenuScreen.verifyExpressCheckoutSuccess();

    }

    @When("Guest selects one of the happy neutral and sad emojis")
    public void guest_selects_one_of_the_happy_neutral_and_sad_emojis() {

        openKeyMoreMenuScreen.verifyFeedbackEmojiSelection();

    }

    @And("Guest submits the happy feedback with comment or clicks Skip")
    public void guest_submits_the_happy_feedback_with_comment() {

        openKeyMoreMenuScreen.verifyActionSkipORFeedbackComment();

    }

    @Then("Guest should be navigated back to the Hotel Search screen")
    public void guest_should_be_navigated_back_to_the_hotel_search_screen() {

        openKeyMoreMenuScreen.verifyPostFeedbackSubmission();

    }

}



