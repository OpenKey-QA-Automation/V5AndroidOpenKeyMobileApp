package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class OpenKeyHomeScreen extends BaseScreen {

    public OpenKeyHomeScreen(AndroidDriver driver, MqttClientClass mqttClient) {

        super(driver);
    }

    /**Mobile Elements*/
    By openkeySplashLogo = By.id("com.openkey.guest:id/imgSplashLogo");
    By allowDeviceLocation = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    //By allowDeviceLocation = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]");
    By allowAccessOfPhotos =  By.id("com.android.permissioncontroller:id/permission_allow_button");
    By allowToSendNotifications = By.id("com.openkey.guest:id/txtDialogPosBtn");
    By enterMobileNumberScreen = By.id("com.openkey.guest:id/txtMsg");
    By btnOpenAppPlayStore = By.xpath("//android.view.View[@content-desc=\"Open\"]");

    /**Actions*/
    public void launchOpenKeyApp() {
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnOpenAppPlayStore)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(openkeySplashLogo)).isDisplayed();
        allureReportingManager.stepsScreenshots();

    }

    public void allowNotification() {

        if (wait.until(ExpectedConditions.visibilityOfElementLocated(allowDeviceLocation)).isDisplayed()) {
            allureReportingManager.stepsScreenshots();
            wait.until(ExpectedConditions.visibilityOfElementLocated(allowDeviceLocation)).click();
            if(wait.until(ExpectedConditions.visibilityOfElementLocated(allowAccessOfPhotos)).isDisplayed()) {
                allureReportingManager.stepsScreenshots();
                wait.until(ExpectedConditions.visibilityOfElementLocated(allowAccessOfPhotos)).click();
                if (wait.until(ExpectedConditions.visibilityOfElementLocated(allowToSendNotifications)).isDisplayed()) {
                    allureReportingManager.stepsScreenshots();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(allowToSendNotifications)).click();
                }
            }
        }
    }

    public void enterMobileNumberScreen() {

        String mobileEnterScreenStr = wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberScreen)).getText();
        Assert.assertTrue(mobileEnterScreenStr.toLowerCase().contains("mobile"));
        allureReportingManager.stepsScreenshots();
    }
}