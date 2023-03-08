package com.openkey.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/** OpenKey Guest Mobile Android App Home Screen */
public class OpenKeyLaunchAppSteps extends BaseSteps {

    @Before
    public void setupSteps() {

        setupScreens(driver, mqttClient);
    }

    @Given("^OpenKey App is Launched$")
    public void openKey_app_is_launched() {
        openKeyHomeScreen.launchOpenKeyApp();
        System.out.println("OpenKey Mobile App Launched");
    }

    @When("^Allow Notifications$")
    public void allow_notifications() {
        openKeyHomeScreen.allowNotification();
        System.out.println("Allow OpenKey Guest to access this device's location?");
        System.out.println("Allow OpenKey Guest to access photos and media on your device?");
        System.out.println("Allow OpenKey would Like to send You Notifications");
    }

    @Then("^Enter Mobile Number Screen should be displayed$")
    public void enter_mobile_number_screen_should_be_displayed() {
        openKeyHomeScreen.enterMobileNumberScreen();
        System.out.println("Enter Mobile Number Screen should be displayed");
    }


/*    @BeforeSuite
    //Start Appium Server object
    public void configureAppium() throws Exception {
        preparation();
    }

    @AndroidFindBy(id = "com.openkey.guest:id/txtHeader")
    private MobileElement homeScreen;

    @Test
    //LaunchOpenKeyApp
    //@Given("^UI connection to \"OpenKeyAndroidApplication\"$")
    public void LaunchOpenKeyApp() {

        driver.findElement(By.id("com.openkey.guest:id/txtHeader")).isDisplayed();
        System.out.println("OpenKey Mobile App Launched");

        //Push Notification Screen
        fluentWait.until(ExpectedConditions.presenceOfElementLocated
            (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")));
        el.click();
        //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
        System.out.println("Allow OpenKey Guest to access this device's location?");

        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        System.out.println("Allow OpenKey Guest to access photos and media on your device?");

        driver.findElement(By.id("com.openkey.guest:id/txtDialogPosBtn")).click();
        System.out.println("Allow OpenKey would Like to send You Notifications");

        //Enter Mobile Number
        driver.findElement(By.id("com.openkey.guest:id/edtEnterPhoneNumber")).click();
        driver.findElement(By.id("com.openkey.guest:id/edtEnterPhoneNumber")).sendKeys("2145552222");
        driver.findElement(By.id("com.openkey.guest:id/btnGetVerifyCode")).click();
        System.out.println("Entered Mobile Number and Clicked on Get Verification Code Button");

        //Verify Verification Code
        driver.findElement(By.id("com.openkey.guest:id/edtEnterVerifyCode")).click();
        driver.findElement(By.id("com.openkey.guest:id/edtEnterVerifyCode")).sendKeys("55555555");
        driver.findElement(By.id("com.openkey.guest:id/btnGetMyKey")).click();
        System.out.println("Entered Verification Code and Clicked on Get My Key Button");

        //Welcome to key downloading screen
        driver.findElement(By.id("com.openkey.guest:id/txtCreateCustomKey")).isDisplayed();
        System.out.println("Digital Mobile Key is getting downloaded");

        //My Key Screen
        driver.findElement(By.id("com.openkey.guest:id/txtHotelName")).isDisplayed();
        System.out.println("Digital key Downloaded Successfully");

        //Open the Door Lock
        driver.findElement(By.id("com.openkey.guest:id/imgMainKey")).click();
        System.out.println("Door Lock is opening...");
        driver.findElement(By.id("com.openkey.guest:id/txtScanning")).isDisplayed();
        System.out.println("Access Granted! Door Lock opened successfully");

    }

    @AfterSuite
    public void postCleanUp(){
        stopAppiumServer();
        System.out.println("Appium server stopped...");
    }
}*/

}


