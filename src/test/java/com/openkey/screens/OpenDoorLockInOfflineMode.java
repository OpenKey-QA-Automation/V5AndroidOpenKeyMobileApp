package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;
import static com.openkey.setups.CapabilitiesManager.mqttClient;

public class OpenDoorLockInOfflineMode extends BaseScreen {

    public static int counter = 0;
    public static int lockOpenSuccessCount = 0;
    public static int lockOpenFailureCount = 0;
    public static int totalNumberOfLockOpeningAttempts=0;

    String accessGranted;

    public OpenDoorLockInOfflineMode(AndroidDriver driver, MqttClientClass mqttClient) {

        super(driver);
    }

    /**Mobile Elements of Offline Mode Door Lock Opening*/
    By turnOffBluetooth = By.xpath("//android.widget.Switch[@content-desc=\"Bluetooth.\"]");
    By turnOnBluetoothAlert = By.id("android:id/message");
    By turnOnBluetoothAlertAllow = By.id("android:id/button1");
    By turnOffMobileData = By.xpath("//android.widget.Switch[@content-desc=\"Mobile data\"]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView");
   /* By turnOffDataAlert = By.id("android:id/message");
    By turnOffData = By.id("android:id/button1");*/
    By mainDoorKey = By.id("com.openkey.guest:id/imgMainKey");
    By scanningNearByLockInRange = By.id("com.openkey.guest:id/txtScanning");
    By accessGrantedCheck = By.id("com.openkey.guest:id/txtSuccess");
    By pushNotificationsOfShareKeyWithOtherGuests = By.xpath("//android.widget.TextView[contains(@text, 'You can also share your key with other guests')]");
    By redirectToMyKeyScreen = By.id("com.openkey.guest:id/constraintMainRoom");
    By failedToOpenDoorLockError = By.id("com.openkey.guest:id/txtErrorMsg");
    By failedToOpenDoorLockErrorPrompt = By.id("com.openkey.guest:id/btnClose");

    /**Actions*/
    public void turnOffNetowrk() {

        //driver.toggleData();
        driver.openNotifications();
        //driver.toggleAirplaneMode();
        driver.toggleWifi();
        System.out.println("WiFi is Off");
        allureReportingManager.stepsScreenshots();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffMobileData)).isDisplayed();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffMobileData)).click();
//        System.out.println("Mobile Data turn off");
//        allureReportingManager.stepsScreenshots();
/*        if (wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffDataAlert)).isDisplayed()){
            System.out.println("Mobile Data is turn off Alert Prompt should be displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffData)).click();
            System.out.println("Mobile Data turn off");
        }
        else {
            driver.navigate().back();
        }*/

        driver.openNotifications();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffBluetooth)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffBluetooth)).click();
        System.out.println("Bluetooth turn off");
        allureReportingManager.stepsScreenshots();

        driver.navigate().back();
        System.out.println("Guest device does not connected with Networks");
        allureReportingManager.stepsScreenshots();
    }

    public void openDoorLockInOfflineModeBluetoothAlert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainDoorKey)).click();
        System.out.println("Guest try to open lock in Offline Mode");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOnBluetoothAlert)).isDisplayed();
        System.out.println("OpenKey Guest wants to turn on Bluetooth alert prompt should be displayed");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOnBluetoothAlertAllow)).click();
        System.out.println("Turning Bluetooth on... message should be displayed");
        System.out.println("Bluetooth is turned on");
        allureReportingManager.stepsScreenshots();
    }

    public void openDoorLockInOfflineMode() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(mainDoorKey)).click();
        mqttClient.moveToPosition(1);
        System.out.println("Guest clicked on Main Door Key Icon");
        allureReportingManager.stepsScreenshots();
    }

    public void scanningLockInRange() {
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

    public void doorOpenedInOfflineMode() {
        try
        {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(accessGrantedCheck)).isDisplayed()) {
                System.out.println("Access Granted! Door Lock opened successfully in offline mode");
                allureReportingManager.stepsScreenshots();
            }
        }
        catch (Exception e)
        {
            if (driver.findElement(failedToOpenDoorLockError).isDisplayed()) {
                allureReportingManager.stepsScreenshots();
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockError)).getText();
                System.out.println("Door lock failed to open in offline mode error prompt is displayed " + failedToOpenDoorLockError);
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPrompt)).click();
                allureReportingManager.stepsScreenshots();
            }
        }
    }

    public void verifyDoorOpenInOfflineMode() {
        try {
            if (driver.findElement(accessGrantedCheck).isDisplayed()) {
                accessGranted = wait.until(ExpectedConditions.visibilityOfElementLocated(accessGrantedCheck)).getText();
                lockOpenSuccessCount = lockOpenSuccessCount + 1;
                counter = counter + 1;
                if (lockOpenSuccessCount == 1) System.out.println(accessGranted + " Door Lock opened successfully for the first time in offline mode");
                else System.out.println(accessGranted + " Door Lock opened successfully for the " + lockOpenSuccessCount + " times in offline mode");

                Assert.assertEquals(accessGranted, "ACCESS GRANTED");
            }

        } catch (Exception e) {
            allureReportingManager.stepsScreenshots();
            if (driver.findElement(failedToOpenDoorLockError).isDisplayed()) {
                lockOpenFailureCount = lockOpenFailureCount + 1;
                if (lockOpenFailureCount == 1)
                    System.out.println("Door lock failed to open in offline mode " + lockOpenFailureCount + " time");
                else System.out.println("Door lock failed to open in offline mode " + lockOpenFailureCount + " times");
                counter = counter + 1;
                String failedToOpenDoorLockErrorStr = wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockError)).getText();
                Assert.assertTrue(failedToOpenDoorLockErrorStr.toLowerCase().contains("unable to connect"));
                System.out.println("Door lock failed to open in offline mode error prompt is displayed " + failedToOpenDoorLockErrorStr);
                wait.until(ExpectedConditions.visibilityOfElementLocated(failedToOpenDoorLockErrorPrompt)).click();
                allureReportingManager.stepsScreenshots();
            }
        }
    }

    public void openMainDoorLockMultipleTimes(int numberOfTimes) throws InterruptedException {
        totalNumberOfLockOpeningAttempts=numberOfTimes;
        System.out.println("Clicking on main door key multiple times in offline mode");
        while (counter < numberOfTimes) {
            try {
                Thread.sleep(5000);
                openDoorLockInOfflineMode();
                mqttClient.moveToPosition(1);
                //accessGrantedCheck();
                verifyDoorOpenInOfflineMode();
                mqttClient.moveToPosition(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total number of attempts to open door lock in offline mode " + numberOfTimes);
        System.out.println("Door Lock opened successfully in offline mode " + lockOpenSuccessCount + " times");
        System.out.println("Door Lock failed to opened in offline mode " + lockOpenFailureCount + " times");
        allureReportingManager.stepsScreenshots();
    }

    public void navigateBackToMyKeyScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(redirectToMyKeyScreen)).isDisplayed();
        System.out.println("Guest redirected back to the My Key Screen");
        allureReportingManager.stepsScreenshots();
        //driver.toggleAirplaneMode();
        driver.toggleWifi();
        System.out.println("WiFi is On");
        allureReportingManager.stepsScreenshots();
        //driver.toggleData();
        driver.openNotifications();
//      wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffMobileData)).isDisplayed();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffMobileData)).click();
//        System.out.println("Mobile Data turn on ");
        System.out.println("Guest device is connected with Networks");
        allureReportingManager.stepsScreenshots();
    }

    public void pushNotificationsOfShareKeyWithOtherGuestsNotTriggered() {
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pushNotificationsOfShareKeyWithOtherGuests)).isDisplayed();
            System.out.println("Push Notification You can also share your key with other guests should be triggered");
            allureReportingManager.stepsScreenshots();
        }
        catch (Exception e)
        {
            //boolean pushNotificationNotTriggered = wait.until(ExpectedConditions.visibilityOfElementLocated(pushNotificationsOfShareKeyWithOtherGuests)).isDisplayed();
            //Assert.assertFalse(pushNotificationNotTriggered, "Push Notification You can also share your key with other guests should not be triggered");
            System.out.println("Push Notification You can also share your key with other guests should not be triggered, it should triggered only one time when guest successfully opening door lock first time");
            driver.navigate().back();
        }
    }
}
