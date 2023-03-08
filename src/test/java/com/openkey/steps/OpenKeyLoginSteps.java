package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/** OpenKey Guest Mobile Android App Login Screen */
public class OpenKeyLoginSteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver, mqttClient);
    }

    @Given("^If any previous notifications clear all notifications from notifications bar$")
    public void clearNotifications() {

        openKeyLoginScreen.clearNotifications();
    }

    @When("^Guest select Country Code$")
    public void guest_select_country_code() {
        openKeyLoginScreen.selectCountryCode();
        System.out.println("Guest click on Country Code dropdown");
        System.out.println("Country Code Search Screen should be displayed");
        System.out.println("Guest type value in search textbox");
        System.out.println("Searched country result should be displayed");
        System.out.println("Selected country code should be displayed in country code field");
    }

    @And("^Guest entered invalid mobile number$")
    public void guest_entered_invalid_mobile_number() {
        openKeyLoginScreen.invalidEnterMobileNumber();
        System.out.println("Guest entered invalid mobile number");
        System.out.println("Guest clicked on Request Verification Code Button");
    }

    @Then("^The number you have entered is invalid. Please enter a valid phone number error alert prompt should be displayed$")
    public void the_number_you_have_entered_is_invalid_Please_enter_a_valid_phone_number_error_alert_prompt_should_be_displayed() {
        openKeyLoginScreen.invalidMobileErrorAlert();
        System.out.println("The number you have entered is invalid. Please enter a valid phone number error alert prompt should be displayed");
    }

    @When("^Guest entered register mobile number$")
    public void guest_entered_register_mobile_number() {
        openKeyLoginScreen.enterMobileNumber();
        System.out.println("Guest click on Enter Mobile Number Field");
        System.out.println("Guest entered register mobile number");
    }

    @And("^Guest click on Request Verification Code Button$")
    public void guest_click_on_request_verification_code_button() {
        openKeyLoginScreen.getVerificationCode();
        System.out.println("Guest clicked on Request Verification Code Button");

    }

    @Then("^Enter Verification Code Screen should be displayed$")
    public void enter_verification_code_screen_should_be_displayed() {
        openKeyLoginScreen.enterVerificationCodeScreen();
        System.out.println("Enter Verification Code Screen should be displayed");
        System.out.println("Guest received verification code text message");
    }

    @When("^Read the Verification Code from text message$")
    public void read_the_verification_code_from_text_message() {
        openKeyLoginScreen.enterVerificationCode();
        System.out.println("Guest click on Enter Verification Code Field");
        System.out.println("Read the Verification Code from text message");
    }

    @And("^Guest click on Get My Key Button$")
    public void guest_click_on_get_my_key_button() {
        openKeyLoginScreen.getMyKey();
        System.out.println("Guest click on Get My Key Button");
    }

    @Then("^Downloading Key Screen should be displayed$")
    public void downloading_key_screen_should_be_displayed() {
        openKeyLoginScreen.downloadMobileKeyScreen();
        System.out.println("Downloading Key Screen should be displayed");
    }

}



