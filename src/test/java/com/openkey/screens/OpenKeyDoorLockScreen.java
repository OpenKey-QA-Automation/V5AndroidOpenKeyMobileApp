package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;
import static com.openkey.setups.CapabilitiesManager.mqttClient;

public class OpenKeyDoorLockScreen extends BaseScreen {

    public static int counter = 0;
    public static int lockOpenSuccessCount = 0;
    public static int lockOpenFailureCount = 0;
    public static int totalNumberOfLockOpeningAttempts=0;

    String accessGranted;

    public OpenKeyDoorLockScreen(AndroidDriver driver, MqttClientClass mqttClient) {

        super(driver);
    }

    /**Mobile Elements*/
    By mainDoorKey = By.id("com.openkey.guest:id/imgMainKey");
    By scanningNearByLockInRange = By.id("com.openkey.guest:id/txtScanning");
    //By accessGrantedCheck = By.id("com.openkey.guest:id/txtSuc");
    By accessGrantedCheck = By.id("com.openkey.guest:id/txtSuccess");
    By pushNotificationsOfShareKeyWithOtherGuests = By.xpath("//android.widget.TextView[contains(@text, 'You can also share your key with other guests')]");
    By redirectToMyKeyScreen = By.id("com.openkey.guest:id/constraintMainRoom");
    By clearNotifications = By.id("com.android.systemui:id/dismiss_text");
    By failedToOpenDoorLockError = By.id("com.openkey.guest:id/txtErrorMsg");
    By failedToOpenDoorLockErrorPrompt = By.id("com.openkey.guest:id/btnClose");
    By enjoyingOpekeyStarRatingPrompt = By.id("com.openkey.guest:id/txtNotNowBtn");

    /**Actions*/
    public void openMainDoorLock() throws InterruptedException {
        mqttClient.moveToPosition(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainDoorKey)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void scanningNearByLockInRange() {
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(scanningNearByLockInRange)).isDisplayed();
            System.out.println("Door Lock is opening...");
            allureReportingManager.stepsScreenshots();
        }
        catch (Exception e) {

            System.out.println("Lock is not in range");

        }
    }

    public void accessGrantedCheck() {

        try
            {
                driver.findElement(accessGrantedCheck).isDisplayed();
                System.out.println("Access Granted! Door Lock opened successfully");
                allureReportingManager.stepsScreenshots();
            }
        catch (Exception e)
            {
                driver.findElement(failedToOpenDoorLockError).isDisplayed();
                allureReportingManager.stepsScreenshots();
                String failedToOpenDoorLockErrorStr = wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockError)).getText();
                Assert.assertTrue(failedToOpenDoorLockErrorStr.toLowerCase().contains("unable to connect"));
                System.out.println("Door lock failed to open error prompt is displayed " + failedToOpenDoorLockErrorStr);
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPrompt)).isDisplayed();
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPrompt)).click();
                allureReportingManager.stepsScreenshots();
            }
    }

    public void redirectToMyKeyScreen() throws InterruptedException {
        mqttClient.moveToPosition(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(redirectToMyKeyScreen)).isDisplayed();
        allureReportingManager.stepsScreenshots();
    }

    public void pushNotificationsOfShareKeyWithOtherGuests() {

        try {
            driver.openNotifications();
            allureReportingManager.stepsScreenshots();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(pushNotificationsOfShareKeyWithOtherGuests)).isDisplayed()) {
                allureReportingManager.stepsScreenshots();
                String shareKeyWithOtherGuests = wait.until(ExpectedConditions.visibilityOfElementLocated(pushNotificationsOfShareKeyWithOtherGuests)).getText();
                Assert.assertTrue(shareKeyWithOtherGuests.toLowerCase().contains("share your key"));
                System.out.println("Push Notifications " + shareKeyWithOtherGuests);
                driver.navigate().back();
                allureReportingManager.stepsScreenshots();
            }
        }
        catch (Exception e)
        {
            // Assert.assertTrue(false, "Push Notification not triggered");
            System.out.println("Push Notifications not triggered");
            driver.navigate().back();
            allureReportingManager.stepsScreenshots();
        }
    }

    public void verifyDoorOpen() {
        try {
            if (driver.findElement(accessGrantedCheck).isDisplayed()) {
                accessGranted = wait.until(ExpectedConditions.visibilityOfElementLocated(accessGrantedCheck)).getText();
                lockOpenSuccessCount = lockOpenSuccessCount + 1;
                counter = counter + 1;
                if (lockOpenSuccessCount == 1) System.out.println(accessGranted + " Door Lock opened successfully for the first time");
                else System.out.println(accessGranted + " Door Lock opened successfully for the " + lockOpenSuccessCount + " times");
                Assert.assertEquals(accessGranted, "ACCESS GRANTED");
            }

        } catch (Exception e) {
                allureReportingManager.stepsScreenshots();
            if (driver.findElement(failedToOpenDoorLockError).isDisplayed()) {
                lockOpenFailureCount = lockOpenFailureCount + 1;
                if (lockOpenFailureCount == 1)
                    System.out.println("Door lock failed to open " + lockOpenFailureCount + " time");
                else System.out.println("Door lock failed to open " + lockOpenFailureCount + " times");
                counter = counter + 1;
                String failedToOpenDoorLockErrorStr = wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockError)).getText();
                Assert.assertTrue(failedToOpenDoorLockErrorStr.toLowerCase().contains("unable to connect"));
                System.out.println("Door lock failed to open error prompt is displayed " + failedToOpenDoorLockErrorStr);
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPrompt)).click();
                allureReportingManager.stepsScreenshots();
            }
        }
    }

    public void starRatingPrompt() {

        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(enjoyingOpekeyStarRatingPrompt)).isDisplayed();
            System.out.println("Enjoying Openkey Star Rating Prompt is displayed");
            allureReportingManager.stepsScreenshots();
            wait.until(ExpectedConditions.visibilityOfElementLocated(enjoyingOpekeyStarRatingPrompt)).click();
            allureReportingManager.stepsScreenshots();
        }
        catch (Exception e)
        {
            System.out.println("Enjoying Openkey Star Rating Prompt should display only once on second attempt of successfully door open");
            allureReportingManager.stepsScreenshots();
        }
    }

    public void openMainDoorLockMultipleTimes(int numberOfTimes) throws InterruptedException {
        totalNumberOfLockOpeningAttempts=numberOfTimes;
        System.out.println("Clicking on main door key multiple times");
        while (counter < numberOfTimes) {
            try
            {
                Thread.sleep(5000);
                openMainDoorLock();
                mqttClient.moveToPosition(1);
                //accessGrantedCheck();
                verifyDoorOpen();
                pushNotificationsOfShareKeyWithOtherGuests();
                starRatingPrompt();
                mqttClient.moveToPosition(0);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Total number of attempts to open door lock " + numberOfTimes);
        System.out.println("Door Lock opened successfully " + lockOpenSuccessCount + " times");
        System.out.println("Door Lock failed to opened " + lockOpenFailureCount + " times");
        allureReportingManager.stepsScreenshots();
    }

}