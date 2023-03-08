package com.openkey.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HostPortalDashboardScreen extends BaseScreen {

    /**Mobile Elements*/
    //elements for creating a new session
    // test room number = 801
    //test guest name = Priyanka
    //test country code = +91
    //test mobile number  = 8826282580

    By addGuestOption = By.xpath("(//span[@class='mat-button-wrapper'][contains(.,'Add Guest')])[1]");
    By cntryCode = By.xpath("//input[contains(@formcontrolname,'phone_code')]");
    By cntryCodeDropdown = By.xpath("//span[@class='mat-option-text'][contains(.,'India +91')]");
    By phoneNumberForSearch = By.xpath("//input[@formcontrolname='phone']");
    By searchBtn = By.xpath("//span[@class='mat-button-wrapper'][contains(.,'Search')]");

    By roomId = By.xpath("//input[contains(@formcontrolname,'hotel_room_id')]");
    By roomIdDropdown = By.xpath("//span[@class='mat-option-text'][contains(.,'801')]");
    By createNewSessionBtn = By.xpath("//span[@class='mat-button-wrapper'][contains(.,'Create New Session')]");
    By guestName=By.xpath("//input[contains(@formcontrolname,'full_name')]");

    By hamburgerMenu = By.xpath("//android.widget.Button[@text='Toggle navigation')]");
    // By hamburgerMenu=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.Button[1]");
    //By guestsOption = By.xpath("(//a[@class='nav-link active'][contains(.,'Guests')])[2]");

    By findMobile = By.xpath("//div/mat-card/mat-card-content/p[@text= '+919168515566')]");
    By deleteIcon = By.xpath("//button[@data-target='#checkout-confirm'][contains(.,'delete')]");

    By roomNumber = By.xpath("//div[@id='session-cards']//mat-card/mat-card-header/div/mat-card-title/a[contains(text(), '501')]");

    By sessionCreatedToaster = By.xpath("(//span[@data-notify='message'][contains(.,'Session created for guest Monali Gunjan')])[2]");
    By guestNameAdded= By.xpath("//a[@class='mr-1'][contains(.,'Priyanka')]");
    By guestMobileNumberAdded= By.xpath("//mat-card-subtitle[@class='mat-card-subtitle'][contains(.,'+919168515566')]");

    WebElement hemMenu;
    WebElement guestsElement;
    WebElement mobileNumber;
    WebElement delIconElement;
    WebElement roomNum;
    WebElement checkoutConfirmTitle;
    WebElement getCheckoutConfirmBtn;

    /**Actions*/
    public HostPortalDashboardScreen(AndroidDriver driver) {

        super(driver);
    }

    public void createNewSession() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addGuestOption)).click();
        System.out.println("Add Guest option clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cntryCode)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cntryCode)).sendKeys("+91");
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cntryCodeDropdown)).click();
        Thread.sleep(5000);
        System.out.println("Country code for India selected");
        driver.hideKeyboard();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberForSearch)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberForSearch)).sendKeys("9168515566");
        driver.hideKeyboard();
        Thread.sleep(3000);
        System.out.println("Guest mobile number entered");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
        System.out.println("Search Button clicked");
        Thread.sleep(3000);
       //if (wait.until(ExpectedConditions.visibilityOfElementLocated(guestName)).getText().equals("Priyanka")) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(roomId)).sendKeys("501");
           Thread.sleep(3000);
           wait.until(ExpectedConditions.visibilityOfElementLocated(roomIdDropdown)).click();
           driver.hideKeyboard();
           System.out.println("Room Number entered");
          Thread.sleep(5000);

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(createNewSessionBtn)).click();

        //check if the guest actually added


        wait.until(ExpectedConditions.visibilityOfElementLocated(guestNameAdded)).isDisplayed();
        System.out.println("Session created for guest Monali Gunjan");
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestMobileNumberAdded)).isDisplayed();
        System.out.println("Guest mobile number is displayed");
    }

    public void deleteSession() throws InterruptedException {

       /* hemMenu = driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']"));
        Thread.sleep(5000);
        hemMenu.click();
        System.out.println("Hamburger menu Clicked");
        guestsElement = driver.findElement(By.xpath("(//span[@class='sidebar-mini-hide'][contains(.,'Guests')])[1]"));
        guestsElement.click();
        System.out.println("Guests Clicked");*/
       // roomNum = driver.findElement(By.xpath("//a[contains(.,'sensor_door801')]"));
        /*System.out.println("Room displayed");
        Thread.sleep(2000);
        roomNum.click();
        System.out.println("Room clicked");*/
        //xpath for delete icon
        ////span[@class='material-icons'][contains(.,'delete')]
        roomNum = driver.findElement(By.xpath("//p[contains(.,'Room: 501')]"));
        roomNum.isDisplayed();
        System.out.println("Room: 501 is displayed");
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
