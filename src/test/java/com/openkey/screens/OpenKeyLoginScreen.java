package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class OpenKeyLoginScreen extends BaseScreen {

    public OpenKeyLoginScreen(AndroidDriver driver, MqttClientClass mqttClient) {

        super(driver);

    }

    /**Mobile Elements*/
    By countryCodeDropdown = By.id("com.openkey.guest:id/txtCountryCodeVerify");
    By countryCodeSearch = By.id("com.openkey.guest:id/edtCountrySearch");
    By selectCountryCode = By.id("com.openkey.guest:id/txt_country_name");
   // By selectCountryCode = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]");
    By selectRoomNumber = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]");
    By alertOfMobileNotRegistered = By.id("com.openkey.guest:id/txtErrorMsg");
    By acceptAlert = By.id("com.openkey.guest:id/btnClose");
    By enterMobileNumberField = By.id("com.openkey.guest:id/edtEnterPhoneNumber");
    By requestVerificationCodeButton = By.id("com.openkey.guest:id/btnGetVerifyCode");
    By enterVerificationCodeScreen = By.id("com.openkey.guest:id/txtMsg");
    By clearNotifications = By.id("com.android.systemui:id/dismiss_text");
    By otpValue = By.xpath("//android.widget.TextView[contains(@text, 'your Verification Code for OpenKey.')]");
    By enterVerificationCodeField = By.id("com.openkey.guest:id/edtEnterVerifyCode");
    By getMyKeyButton = By.id("com.openkey.guest:id/btnGetMyKey");
    By downloadMobileKeyScreen = By.id("com.openkey.guest:id/txtCreateCustomKey");

    /** Actions */
    public void clearNotifications() {

        try
        {
            driver.openNotifications();
            System.out.println("Opened Notifications Bar to clear old notifications");
            allureReportingManager.stepsScreenshots();
            //driver.executeScript("mobile: swipe", "direction: down");
            driver.executeScript("mobile: scroll", "direction: down");
            //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(clearNotifications)).click();
            System.out.println("All Notifications are cleared");
            allureReportingManager.stepsScreenshots();
        }
        catch (Exception e)
        {
            driver.navigate().back();
            System.out.println("Notifications are not present");
            allureReportingManager.stepsScreenshots();
        }
    }

    public void selectCountryCode() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(countryCodeDropdown)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryCodeSearch)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryCodeSearch)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryCodeSearch)).sendKeys("United States");
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountryCode)).click();
        allureReportingManager.stepsScreenshots();

    }

    public void invalidEnterMobileNumber() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).sendKeys("1111111111");
        wait.until(ExpectedConditions.visibilityOfElementLocated(requestVerificationCodeButton)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void invalidMobileErrorAlert() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(alertOfMobileNotRegistered)).isDisplayed();
        String invalidPhoneNumberErrorAlertStr = wait.until(ExpectedConditions.visibilityOfElementLocated(alertOfMobileNotRegistered)).getText();
        System.out.println(invalidPhoneNumberErrorAlertStr);
        Assert.assertTrue(invalidPhoneNumberErrorAlertStr.contains("The number you have entered is invalid. Please enter a valid phone number."));
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptAlert)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).clear();
        allureReportingManager.stepsScreenshots();

    }

    public void enterMobileNumber() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberField)).sendKeys("4695450806");
        allureReportingManager.stepsScreenshots();
    }

    public void getVerificationCode() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(requestVerificationCodeButton)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void enterVerificationCodeScreen() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(enterVerificationCodeScreen)).isDisplayed();
        String mobileEnterScreenStr = wait.until(ExpectedConditions.visibilityOfElementLocated(enterVerificationCodeScreen)).getText();
        Assert.assertTrue(mobileEnterScreenStr.contains("Please enter your 8 digit verification code below:"));
        allureReportingManager.stepsScreenshots();
    }


    public void enterVerificationCode() {

        //driver.startActivity(new Activity("com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.ConversationListActivity"));
        driver.openNotifications();
        System.out.println("Opened Notifications Bar to get Verification Code");
        allureReportingManager.stepsScreenshots();
        String otpValueStr = wait.until(ExpectedConditions.visibilityOfElementLocated(otpValue)).getText().split(" is")[0];
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        System.out.println("Redirected back to the Verification Code Screen of OpenKey App");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterVerificationCodeField)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterVerificationCodeField)).sendKeys(otpValueStr);
        allureReportingManager.stepsScreenshots();
    }

    public void getMyKey() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(getMyKeyButton)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void downloadMobileKeyScreen() {

        String downloadMobileKeyScreenStr = wait.until(ExpectedConditions.visibilityOfElementLocated(downloadMobileKeyScreen)).getText();
        Assert.assertTrue(downloadMobileKeyScreenStr.toUpperCase().contains("CREATING DIGITAL KEY"));
        allureReportingManager.stepsScreenshots();
    }

}