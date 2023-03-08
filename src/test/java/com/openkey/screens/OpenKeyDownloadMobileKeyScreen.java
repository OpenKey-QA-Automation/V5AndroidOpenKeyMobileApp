package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class OpenKeyDownloadMobileKeyScreen extends BaseScreen {

    public OpenKeyDownloadMobileKeyScreen(AndroidDriver driver, MqttClientClass mqttClient)

    {
        super(driver);
    }

    Boolean flag;

    /**Mobile Elements*/
    By animatedImage = By.id("com.openkey.guest:id/imgAnimatedImage");
    By playAnimationImage= By.id("com.openkey.guest:id/imgPlayAnimation");
    By hangTightText = By.id("com.openkey.guest:id/txtHangTight");
    By welcomeToLabel = By.id("com.openkey.guest:id/txtWelcomeTo");
    By roomNumberLabel = By.id("com.openkey.guest:id/txtRoomNumber");
    By imgMenuHeaderPush = By.id("com.openkey.guest:id/imgMenuHeader");

    /**Actions*/
    public void verifyKeyDownloadingScreen() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(animatedImage)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(playAnimationImage)).isDisplayed();
    }

    public void verifyActiveKeyScreen() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(hangTightText)).isDisplayed();

    }

    public void verifyAccessToRoomNumber() {

        String roomNumberStr = wait.until(ExpectedConditions.visibilityOfElementLocated(roomNumberLabel)).getText().split(" room")[0];
        wait.until(ExpectedConditions.visibilityOfElementLocated(roomNumberLabel)).isDisplayed();
        allureReportingManager.stepsScreenshots();
        flag = driver.findElement(roomNumberLabel).getText().contains(roomNumberStr);
        System.out.println("Access to Room number : "+roomNumberStr);
        driver.navigate().back();

    }

    public void verifyPushNotificationForAccess() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(imgMenuHeaderPush)).isDisplayed();
    }

    public void verifyContentOnActiveKeyScreen() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeToLabel)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(roomNumberLabel)).isDisplayed();
    }

}