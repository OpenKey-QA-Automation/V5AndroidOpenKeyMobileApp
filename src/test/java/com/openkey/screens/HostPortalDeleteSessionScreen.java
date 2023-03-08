package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HostPortalDeleteSessionScreen extends BaseScreen {

    By findMobile = By.xpath("//div/mat-card/mat-card-content/p[@text= '+919168515566')]");
    By deleteIcon = By.xpath("//button[@data-target='#checkout-confirm'][contains(.,'delete')]");

    WebElement delIconElement;
    WebElement roomNum;
    WebElement getCheckoutConfirmBtn;

    public HostPortalDeleteSessionScreen(AndroidDriver driver) {

        super(driver);

    }
    public void deleteSession() throws InterruptedException {

        roomNum = driver.findElement(By.xpath("//p[contains(.,'Room: 800')]"));
        roomNum.isDisplayed();
        System.out.println("Room: 800 is displayed");
        delIconElement=driver.findElement(By.xpath("//span[@class='material-icons'][contains(.,'delete')]"));
        //delIconElement = driver.findElement(By.xpath("//button[@data-target='#checkout-confirm'][contains(.,'delete')]"));
        Thread.sleep(3000);
        delIconElement.click();
        System.out.println("Delete icon clicked");
        Thread.sleep(5000);
        getCheckoutConfirmBtn = driver.findElement(By.xpath("//button[@color='primary'][contains(.,'Check Out')]"));
        getCheckoutConfirmBtn.click();
        System.out.println("Check out option clicked ");

    }

    public Boolean isSessionDeleted() {
        if (!wait.until(ExpectedConditions.visibilityOfElementLocated(deleteIcon)).isDisplayed()) {
            System.out.println("Session Deleted");
            return true;
        } else return false;
    }
}

