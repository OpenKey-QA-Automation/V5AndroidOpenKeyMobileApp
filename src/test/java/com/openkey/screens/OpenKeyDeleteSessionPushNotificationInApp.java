package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenKeyDeleteSessionPushNotificationInApp extends BaseScreen {

    /**Mobile Elements*/
    By pushNotification;
    By feedbackScreenText = By.xpath("//android.widget.TextView[contains(@text, 'Your mobile key has expired')]");
    By feedbackScreenFaceImg = By.id("com.openkey.guest:id/imgNutralFace");
    By submitFeedback = By.id("com.openkey.guest:id/btnWriteSubmitReview");
    By successPopUpOK = By.id("com.openkey.guest:id/btnClose");
    By SearchPageTitle = By.id("com.openkey.guest:id/txtHeader");
    By findOKHotels = By.id("com.openkey.guest:id/txtMsg");

    //elements on alert popup when no key is associated with mobile number
    By alertTitle = By.id("com.openkey.guest:id/txtErrorTitle");
    By alertMsg = By.id("com.openkey.guest:id/txtErrorMsg");
    By alertOK = By.id("com.openkey.guest:id/btnClose");

    /**Actions*/
    public OpenKeyDeleteSessionPushNotificationInApp(AndroidDriver driver) {

        super(driver);
    }

    public void verifyPushNotificationWhenSessionDeleted() {
        try {
            Thread.sleep(5000);
            driver.openNotifications();
            System.out.println("Push Notification Bar Opens ");
            driver.context("NATIVE_APP");
            System.out.println("Updated Context is : " + driver.getContext());
            try {
                pushNotification = By.id("android:id/text");
                wait.until(ExpectedConditions.visibilityOfElementLocated(pushNotification)).click();
                System.out.println("Push Notification clicked");
            } catch (Exception e) {
                System.out.println("Push Notification ERROR");
                e.printStackTrace();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void verifyFeedbackScreen() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackScreenText)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackScreenFaceImg)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackScreenFaceImg)).click();
        System.out.println("Feedback icon selected");
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitFeedback)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitFeedback)).click();
        System.out.println("Feedback submitted");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPopUpOK)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPopUpOK)).click();
    }
    public String verifySearchPage() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPageTitle)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(findOKHotels)).isDisplayed();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPageTitle)).getText();
    }

   /* public void loginWithMobNumberWithExpiredKey() {
        driver.startActivity(new Activity("com.openkey.guest", "com.openkey.guest.ui.activities.LauncherActivity"));
        System.out.println("The App is launched and  it opens search page");
    }*/
}


