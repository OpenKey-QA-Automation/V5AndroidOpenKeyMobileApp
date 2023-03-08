package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.mockito.Mock;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenKeyDoorLockOpeningMockObject extends BaseScreen {

    public OpenKeyDoorLockOpeningMockObject(AndroidDriver driver)
    {

        super(driver);
    }

    /**Mobile Elements*/
    By mainDoorKey = By.id("com.openkey.guest:id/imgMainKey");
    By scanningNearByLockInRange = By.id("com.openkey.guest:id/txtScanning");
    By accessGrantedCheck = By.id("com.openkey.guest:id/txtSuccess");
    By redirectToMyKeyScreen = By.id("com.openkey.guest:id/constraintMainRoom");

    /**Actions*/

    /** Mock Object to Open Door Lock using Switch Case */
    public void doorLocksOpenMockObject() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainDoorKey)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(scanningNearByLockInRange)).isDisplayed();
        String locks = "Access Granted";
        switch (locks) {
            case "DRK":
                System.out.println("DRK lock is opened and Access Granted check should be displayed");
            case "ASSA":
                System.out.println("ASSA lock is opened and Access Granted check should be displayed");
            case "KABA":
                System.out.println("KABA lock is opened and Access Granted check should be displayed");
            case "SALTO":
                System.out.println("SALTO lock is opened and Access Granted check should be displayed");
            case "ENTRAVA":
                System.out.println("ENTRAVA lock is opened and Access Granted check should be displayed");
            case "MIWA":
                System.out.println("MIWA lock is opened and Access Granted check should be displayed");
                wait.until(ExpectedConditions.visibilityOfElementLocated(accessGrantedCheck)).isDisplayed();
                wait.until(ExpectedConditions.visibilityOfElementLocated(redirectToMyKeyScreen)).isDisplayed();
        }
    }
}
