package com.openkey.steps;

import com.openkey.setups.CapabilitiesManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/** OpenKey Guest Mobile Android App Opening Door Lock Screen */
public class OpenKeyDoorLockSteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver, mqttClient);

    }

    @When("^Guest clicks on Key Icon on My Key Screen$")
    public void guest_clicks_on_key_icon_on_my_key_screen() throws InterruptedException {

        openDoorLockScreen.openMainDoorLock();
        System.out.println("Guest clicked on Main Key Icon");

    }

    @And("^It starts scanning locks in range$")
    public void it_starts_scanning_locks_in_range() {

        openDoorLockScreen.scanningNearByLockInRange();

    }

    @Then("^Access Granted check mark should be displayed$")
    public void access_granted_check_mark_should_be_displayed() {

        openDoorLockScreen.accessGrantedCheck();

    }

    @And("^Guest should be redirected back to the My Key Screen$")
    public void guest_should_be_redirected_back_to_the_my_key_screen() throws InterruptedException {

        openDoorLockScreen.redirectToMyKeyScreen();
        System.out.println("Guest redirected back to the My Key Screen");

    }

    @And("^Verify Push Notification You can also share your key with other guests should be triggered on first time opening door lock$")
    public void verify_push_notification_you_can_also_share_your_key_with_other_guests_should_be_triggered_on_first_time_opening_door_lock() {

        openDoorLockScreen.pushNotificationsOfShareKeyWithOtherGuests();
        System.out.println("Verify Push Notification You can also share your key with other guests should be triggered on first time successfully opening door lock\n");

    }

    @When("^I clicks the main key for given number of times$")
    public void i_clicks_the_main_key_for_given_number_of_times() throws InterruptedException {
        openDoorLockScreen.openMainDoorLockMultipleTimes(CapabilitiesManager.lockCounter);
    }

    @Then("^It should open the lock successfully each time$")
    public void it_should_open_the_lock_successfully_each_time() {
        allureReportingManager.stepsScreenshots();
    }
}


