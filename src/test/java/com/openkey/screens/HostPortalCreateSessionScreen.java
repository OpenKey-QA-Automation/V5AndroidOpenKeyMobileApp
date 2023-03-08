package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class HostPortalCreateSessionScreen extends BaseScreen {

        By addGuestOption = By.xpath("(//span[@class='mat-button-wrapper'][contains(.,'Add Guest')])[1]");
        By cntryCode = By.xpath("//input[contains(@formcontrolname,'phone_code')]");
        By cntryCodeDropdown = By.xpath("//span[@class='mat-option-text'][contains(.,'Canada / United States +1')]");
        By phoneNumberForSearch = By.xpath("//input[@formcontrolname='phone']");
        By searchBtn = By.xpath("//span[@class='mat-button-wrapper'][contains(.,'Search')]");

        By roomId = By.xpath("//input[contains(@formcontrolname,'hotel_room_id')]");
        //By roomId = By.id("mat-input-2");
        //By roomIdDropdown = By.id("mat-chip-list-input-0");
        By roomIdDropdown = By.xpath("//span[@class='mat-option-text'][contains(.,'547')]"); //Programmatically change
        By createNewSessionBtn = By.xpath("//span[@class='mat-button-wrapper'][contains(.,'Create New Session')]");

        By sessionCreatedToaster = By.xpath("(//span[@data-notify='message'][contains(.,'Session created for guest')])[2]");
        By guestNameAdded= By.xpath("//a[@class='mr-1'][contains(.,'Aaron')]"); //Programmatically change
        By guestMobileNumberAdded= By.xpath("//mat-card-subtitle[@class='mat-card-subtitle'][contains(.,'+14695450806')]"); //Programmatically change


    public HostPortalCreateSessionScreen(AndroidDriver driver) {

            super(driver);
    }

    public void createNewSession() throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOfElementLocated(addGuestOption)).click();
            allureReportingManager.stepsScreenshots();
            System.out.println("Add Guest option clicked");
            wait.until(ExpectedConditions.visibilityOfElementLocated(cntryCode)).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(cntryCode)).sendKeys("Canada");
            allureReportingManager.stepsScreenshots();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(cntryCodeDropdown)).click();
            allureReportingManager.stepsScreenshots();
            Thread.sleep(5000);
            //System.out.println("Country code for India selected");
            allureReportingManager.stepsScreenshots();
            driver.hideKeyboard();
            //Thread.sleep(2000);
            allureReportingManager.stepsScreenshots();
            wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberForSearch)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberForSearch)).sendKeys("4695450806");//Programmatically change
            driver.hideKeyboard();
            allureReportingManager.stepsScreenshots();
            //Thread.sleep(3000);
            System.out.println("Guest mobile number entered");
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
            System.out.println("Search Button clicked");
            allureReportingManager.stepsScreenshots();
            //Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(roomId)).sendKeys("547");//Programmatically change
           // wait.until(ExpectedConditions.visibilityOfElementLocated(roomId)).sendKeys("547");//Programmatically change
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(roomIdDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(roomIdDropdown)).click();
            allureReportingManager.stepsScreenshots();
            driver.hideKeyboard();
            System.out.println("Room Number entered");
            //Thread.sleep(5000);
            allureReportingManager.stepsScreenshots();

            JavascriptExecutor js= (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,1000)");
            wait.until(ExpectedConditions.visibilityOfElementLocated(createNewSessionBtn)).click();
            allureReportingManager.stepsScreenshots();

            //check if the guest actually added
            wait.until(ExpectedConditions.visibilityOfElementLocated(guestNameAdded)).isDisplayed();
            allureReportingManager.stepsScreenshots();
            System.out.println("Session created for guest");
            wait.until(ExpectedConditions.visibilityOfElementLocated(guestMobileNumberAdded)).isDisplayed();
            System.out.println("Guest mobile number is displayed");

        }
    }
