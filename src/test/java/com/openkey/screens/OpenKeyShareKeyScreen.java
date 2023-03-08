package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenKeyShareKeyScreen extends BaseScreen {
    static int guestCount = 0;
    int removedGuest = 0;
    String name;
    String country;
    String mobileNumber;

    /** Mobile Elements*/
    By shareKeyElement = By.id("com.openkey.guest:id/txtShareKey");
    By shareKeyScreenTitle = By.id("com.openkey.guest:id/txtErrorTitle");
    By backIcon = By.id("com.openkey.guest:id/imgBackIconShare");
    By txtMessage = By.id("com.openkey.guest:id/txtMsg");
    By nameInput = By.id("com.openkey.guest:id/edtName");
    By countryPicker = By.id("com.openkey.guest:id/txtCountryPicker");//click on this to open country drop down
    By countrySearch = By.id("com.openkey.guest:id/edtCountrySearch"); //send keys 'India'
    By countryName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]");
    By phoneNumberInput = By.id("com.openkey.guest:id/edtMobile");
    By shareKeyAddBtn = By.id("com.openkey.guest:id/imgAddBtn");
    By successPopupTitle = By.id("com.openkey.guest:id/txtErrorTitle");
    By successMessage = By.id("com.openkey.guest:id/txtErrorMsg");
    By successOkBtn = By.id("com.openkey.guest:id/btnClose");

    //Error for guest already registered
    By errorPopupTitle = By.id("com.openkey.guest:id/txtErrorTitle"); //ERROR
    By errorMessage = By.id("com.openkey.guest:id/txtErrorMsg"); // Guest has already checked in.
    By errorOkBtn = By.id("com.openkey.guest:id/btnClose");
    By addedGuestName = By.id("com.openkey.guest:id/txtName");
    By addedGuestMobile = By.id("com.openkey.guest:id/txtMobile");
    By removeIcon = By.xpath("//*[@resource-id='com.openkey.guest:id/imgDelete']");
    By checkOutAlertTitle = By.id("com.openkey.guest:id/txtErrorTitle");
    By checkOutErrorMessage = By.id("com.openkey.guest:id/txtErrorMsg");
    By checkOutConfirmBtn = By.xpath("//*[@resource-id='com.openkey.guest:id/btnClose']");
    By checkOutCancelBtn = By.id("com.openkey.guest:id/btnCancel");

    By addedGuestRow = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.View");

    public OpenKeyShareKeyScreen(AndroidDriver driver, MqttClientClass mqttClient)
    {

        super(driver);
    }

    /** Actions*/
    public void clickOnShareKeyBottomNavigation() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(shareKeyElement)).click();
        System.out.println("Guest clicked on ShareKey Icon");
    }

    public String verifyShareKeyScreenTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shareKeyScreenTitle)).getText();
    }

    public Boolean isBackIconDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(backIcon)).isDisplayed();
        return true;
    }

    public Boolean isShareKeyBtnDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shareKeyAddBtn)).isDisplayed();
    }
    public void clickOnShareKey(String name, String country, String mobile) throws InterruptedException {

        Thread.sleep(2000);
        if (guestCount < 5) {
            this.name = name;
            this.country = country;
            this.mobileNumber = mobile;
            //System.out.println("Name : " + name + "Mobile number :" + mobileNumber);
            addGuest();
        }
    }
    public void addGuest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryPicker)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearch)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearch)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearch)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput)).sendKeys(mobileNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(shareKeyAddBtn)).isDisplayed();

        if (ListOfGuests.guestList.size() == 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(shareKeyAddBtn)).click();
            System.out.println("Guest added successfully");
            ListOfGuests.guestList.add(mobileNumber);
            guestCount = guestCount + 1;
        }

        else if(ListOfGuests.guestList.contains(mobileNumber)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(shareKeyAddBtn)).click();
            System.out.println("Guest has already checked in");
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(shareKeyAddBtn)).click();
            System.out.println("Guest added successfully");
            ListOfGuests.guestList.add(mobileNumber);
            guestCount = guestCount + 1;
        }

        //System.out.println("Size of the guest list inside addGuest method "+ListOfGuests.guestList.size());
    }
    public void removeAllAddedGuests() {
        //System.out.print("Guest Count is :"+guestCount);

        for(int i=0;i<guestCount;i++) {
            clickOnX();
            clickOnConfirm();
            removeGuest();
            removedGuest=removedGuest+1;
            System.out.println(removedGuest + " Guest removed");
        }
    }

    public String verifyPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPopupTitle)).isDisplayed();
        return driver.findElement(successPopupTitle).getText();
    }

    public void clickOnOKonSuccessPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successOkBtn)).click();
    }

    public Boolean isAddedGuestNameDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedGuestName)).isDisplayed();
        return true;
    }

    public Boolean isAddedGuestMobileNumberDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addedGuestMobile)).isDisplayed();
    }

    public Boolean isRemoveIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeIcon)).isDisplayed();
    }

    public String getAddedGuestName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addedGuestName)).getText();

    }

    public String getAddedGuestMobile() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addedGuestMobile)).getText();

    }

    public void clickOnX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeIcon)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeIcon)).click();
    }

    public Boolean isCheckoutAlertPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutAlertTitle)).getText().contains("Alert!");
    }

    public void clickOnCancel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutCancelBtn)).click();

    }

    public void clickOnConfirm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutConfirmBtn)).click();
    }

    public void removeGuest() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(addedGuestRow)).isDisplayed();
        if(ListOfGuests.guestList.contains(mobileNumber))
            ListOfGuests.guestList.remove(mobileNumber);
    }

    public void navigateToMyKeyScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(backIcon)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(backIcon)).click();
    }
}