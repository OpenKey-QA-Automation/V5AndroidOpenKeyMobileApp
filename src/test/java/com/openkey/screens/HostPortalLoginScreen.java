package com.openkey.screens;

import com.google.common.collect.ImmutableMap;
import com.openkey.setups.YamlConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class HostPortalLoginScreen extends BaseScreen {

    /**web Elements*/
    By acceptCookies = By.id("hs-eu-confirmation-button");
   // By updateBtnCloseIcon=By.xpath("//android.widget.Button[@text='Close']");
    By userName = By.id("email");
    By password = By.id("password");
    By signInBtn = By.xpath("//div/button[contains(text(), 'Sign In')]");
    By notificationContinue = By.id("com.android.chrome:id/positive_button");
    By permissionAccept = By.id("com.android.permissioncontroller:id/permission_allow_button");

    public HostPortalLoginScreen(AndroidDriver driver)  {
        super(driver);

    }

    /**Actions*/
/*    public void capabiltiesHostPortal() throws IOException {

        // Use empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
        YamlConfigReader.inititializeyaml();

        // Reading capabilities from yaml file using getDesired_capabilities() method in YamlConfigReader class
        String[] desiredCapabilities = YamlConfigReader.getDesired_capabilities();
        String platformName = desiredCapabilities[0];
        String platformVersion = desiredCapabilities[1];
        String deviceName = desiredCapabilities[2];
        String appPackage = desiredCapabilities[3];
        String appActivity = desiredCapabilities[4];
        String orientation = desiredCapabilities[5];
        String[] getCredentials = YamlConfigReader.getCredentials();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

        //setting up chrome as browser capability
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("app-package", "com.android.chrome");
        capabilities.setCapability("app-activity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("chromedriverExecutableDir", "/Users/gunjanrajgor/Desktop/OpenKey/OpenKeyMobileApp/chromedriver");
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, orientation);
        capabilities.setCapability("skipUnlock", "true");
        capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset", "false");

        // Start Session in Android Device
        final URL server = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(server, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://host.openkey.co/login");
    }*/

    public void hostPortalLoginScreen () throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("Accept Chrome Notifications");
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationContinue)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(permissionAccept)).click();
        driver.context("WEBVIEW_chrome");
        System.out.println("The login page of host portal opens");
        allureReportingManager.stepsScreenshots();
        System.out.println("Accept Cookies");
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies)).click();
        System.out.println("Enter User Credentials");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys("mrajgor@openkey.co");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("Lewisville$1103");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn)).click();
        allureReportingManager.stepsScreenshots();
        System.out.println("User Login to Host Portal");
        allureReportingManager.stepsScreenshots();
    }
}