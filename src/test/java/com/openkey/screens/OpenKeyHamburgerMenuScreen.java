package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class OpenKeyHamburgerMenuScreen extends BaseScreen {

    // Set<String> contextNames;
    String contextName;
    /** Mobile Element */

    /** Hamburger Menu */
    By hamburgerMenu = By.id("com.openkey.guest:id/imgMenuIcon");
    By btnPopupClose = By.id("com.openkey.guest:id/btnClose");
    By searchHotelMenu = By.xpath("//android.widget.TextView[contains(@text, 'SEARCH HOTELS')]");
    By settingsMenu = By.xpath("//android.widget.TextView[contains(@text, 'SETTINGS')]");
    By learnMoreMenu = By.xpath("//android.widget.TextView[contains(@text, 'LEARN MORE')]");
    By callHotelMenu = By.xpath("//android.widget.TextView[contains(@text, 'CALL HOTEL')]");
    By privacyPolicyLink = By.xpath("//android.widget.TextView[contains(@text, 'PRIVACY POLICY')]");
    By tosLink = By.xpath("//android.widget.TextView[contains(@text, 'TERMS OF USE')]");

    /** Search Hotels*/
    By searchHotelField = By.id("com.openkey.guest:id/edtSearchHotel");
    By searchHotelIcon = By.id("com.openkey.guest:id/imgSearchIcon");
    By searchHotelResult = By.id("com.openkey.guest:id/txtHotelName");
    By facebookIcon = By.id("com.openkey.guest:id/imageFacebook");
    By logoFacebook = By.xpath("//android.widget.Image[contains(@text, 'facebook')]");
    By linkedinIcon = By.id("com.openkey.guest:id/imageLinkedIn");
    By logoLinkedIn = By.id("com.linkedin.android:id/ad_full_logo_image");
    By instaGramIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView");
    By logoInstagram = By.xpath("//android.widget.Button[contains(@text, 'Instagram')]");
    By twitterIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.ImageView");
    By logoTwitter = By.id("com.twitter.android:id/header_title");

    By txtTwitterJoin = By.xpath("//android.widget.TextView [contains(@text,'Twitter')]");
    By wifiIcon = By.xpath("//android.widget.TextView [contains(@text, 'WiFi')]");
    //By wifiIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.ImageView");
     //By wifiIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.ImageView");
    By announceHeader = By.xpath("//android.widget.TextView[contains(@text, 'Announcements')]");
    By highlightHeader = By.xpath("//android.widget.TextView[contains(@text, 'Highlights')]");
    By wifiPopupHeader = By.id("com.openkey.guest:id/txtErrorTitle");
    By btnCallHotelInformation = By.id("com.openkey.guest:id/txtBtnCallHotel");
    By btnTextHotelInformation = By.id("com.openkey.guest:id/txtBtnSmsHotel");
    By txtMsgCompose = By.id("com.google.android.apps.messaging:id/compose_message_text");

    /** Settings */
    By headerSettingsScreen = By.id("com.openkey.guest:id/txtTitleBar");
    By menuIconSettingsScreen = By.id("com.openkey.guest:id/imgDrawerIcon");
    By txtEditGuestName = By.id("com.openkey.guest:id/edtGuestName");
    By txtEditGuestEmail = By.id("com.openkey.guest:id/edtEmail");
    By btnUpdateGuestInfo = By.id("com.openkey.guest:id/btnUpdate");
    By updateSuccessPopup = By.id("com.openkey.guest:id/txtErrorTitle");
    By btnToggleLock = By.id("com.openkey.guest:id/toggleBtnLock");
    By drawPatternTxt = By.id("com.openkey.guest:id/txtDrawPatternTitle");

    /** Learn More */
    By learnMoreMenuHeader = By.id("com.openkey.guest:id/txtErrorTitle");
    By btnPlayPause = By.id("com.openkey.guest:id/imgPlayPause");

    /** Call Hotel */
    By phoneSelect = By.xpath("\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.ImageView");
    By callDialerConsole = By.id("com.google.android.dialer:id/digits");

    /** Privacy Policy */
    By privPolicyPageHeader = By.xpath("//android.widget.TextView[contains(@text, 'Privacy Policy')]");

    /** Terms Of Service */
    By tosPageHeader = By.xpath("//android.widget.TextView[contains(@text, 'TERMS OF SERVICE')]");


    /** Actions */
    public OpenKeyHamburgerMenuScreen(AndroidDriver driver, MqttClientClass mqttClient) {

        super(driver);
    }

    public void verifyHamburgerMenu() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu)).isDisplayed());
        System.out.println("Hamburger Menu is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu)).click();
    }

    public void verifyHamburgerMenuItems() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(searchHotelMenu)).isDisplayed());

        System.out.println("'SEARCH HOTELS' menu item is displayed");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(settingsMenu)).isDisplayed());
        System.out.println("'SETTINGS' menu item is displayed");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(learnMoreMenu)).isDisplayed());
        System.out.println("'LEARN MORE' menu item is displayed");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(callHotelMenu)).isDisplayed());
        System.out.println("'CALL HOTEL' menu item is displayed");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyLink)).isDisplayed());
        System.out.println("'PRIVACY POLICY' link is displayed");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(tosLink)).isDisplayed());
        System.out.println("'TERMS OF USE' link is displayed");

    }

    public void verifySearchHotelsMenuFeatures() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHotelMenu)).click();
        System.out.println("Search Hotels menu selected");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHotelField)).sendKeys("Plano");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHotelIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHotelResult)).click();
        allureReportingManager.stepsScreenshots();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(facebookIcon)).isDisplayed(), true);
        System.out.println("Facebook icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(facebookIcon)).click();
        allureReportingManager.stepsScreenshots();

        //System.out.println(driver.currentActivity());

        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(logoFacebook)).isDisplayed(), true);
        Thread.sleep(5000);
        //System.out.println(driver.getCurrentUrl());
        System.out.println("Facebook app is launched");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(linkedinIcon)).isDisplayed(), true);
        allureReportingManager.stepsScreenshots();
        System.out.println("LinkedIn icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkedinIcon)).click();
        allureReportingManager.stepsScreenshots();

        //Set<String> contextNames = driver.getContextHandles();
        //Object contextArray[] = contextNames.toArray();
        //System.out.println("In ForEach LOOP IN COLLECTION");
        //for (String contextName : contextNames) {
        //  System.out.println(contextName);
        //}

        //System.out.println("context values in array");

        //for (int i=0;i<contextArray.length;i++)
        //{
        //System.out.println(contextArray[i]);

        // if (contextArray[i].equals("WEBVIEW_chrome")) {
        // System.out.println("inside if condition");
        //driver.context("WEBVIEW");
        //System.out.println("webview context is set");
        //String appwebviewURL= driver.getCurrentUrl();
        //System.out.println("user should get the URL");
        //System.out.println(appwebviewURL);

        //}


        // System.out.println(driver.currentActivity());

        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(logoLinkedIn)).isDisplayed(), true);

        Thread.sleep(5000);

        //System.out.println(driver.getCurrentUrl());
        System.out.println("LinkedIn app is launched");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(instaGramIcon)).isDisplayed(), true);
        allureReportingManager.stepsScreenshots();
        System.out.println("Instagram icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(instaGramIcon)).click();
        allureReportingManager.stepsScreenshots();

        Thread.sleep(5000);

        System.out.println("Instagram app is launched");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(twitterIcon)).isDisplayed(), true);
        allureReportingManager.stepsScreenshots();
        System.out.println("Twitter icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(twitterIcon)).click();
        allureReportingManager.stepsScreenshots();

        //System.out.println(driver.currentActivity());
        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(logoTwitter)).isDisplayed(), true);
        //System.out.println(driver.getCurrentUrl());
        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(txtTwitterJoin)).isDisplayed(), true);
        Thread.sleep(5000);

        System.out.println("Twitter app is launched");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        //driver.navigate().back();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(announceHeader)).getText(), "Announcements");
        System.out.println("Announcements section is displayed");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(highlightHeader)).getText(), "Highlights");
        System.out.println("Highlights section is displayed");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(wifiIcon)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(wifiPopupHeader)).getText(), "WiFi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPopupClose)).click();
        allureReportingManager.stepsScreenshots();
        System.out.println("WiFi option under 'Highlights' section is displayed");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(btnCallHotelInformation)).getText(), "CALL HOTEL");
        System.out.println("Call Hotel button is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnCallHotelInformation)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(callDialerConsole)).isDisplayed(), true);
        System.out.println("Call Dialer screen is displayed");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(btnTextHotelInformation)).getText(), "TEXT HOTEL");
        System.out.println("Text Hotel button is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnTextHotelInformation)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(txtMsgCompose)).isDisplayed(), true);
        System.out.println("Compose Message screen is displayed");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
    }

    public void verifySettingsMenuFeatures() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsMenu)).click();
        allureReportingManager.stepsScreenshots();
        System.out.println("Settings menu selected");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(headerSettingsScreen)).getText(), "Settings");
        System.out.println("Settings screen is displayed");
        allureReportingManager.stepsScreenshots();


        wait.until(ExpectedConditions.visibilityOfElementLocated(txtEditGuestName)).sendKeys("Monali" + Math.round(Math.random() * 100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtEditGuestEmail)).sendKeys("mrajgor" + Math.round(Math.random() * 100) + "@openkey.co");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnUpdateGuestInfo)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(updateSuccessPopup)).getText(), "Success");
        System.out.println("Guest info is updated successfully");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPopupClose)).click();
        allureReportingManager.stepsScreenshots();

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnToggleLock)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(drawPatternTxt)).getText(), "Draw Your Pattern");
        System.out.println("Pattern lock is enabled");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuIconSettingsScreen)).click();
        allureReportingManager.stepsScreenshots();

        //System.out.println("'Settings' features are implemented properly and running successfully");
    }

    public void verifyLearnMoreMenuFeatures() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(learnMoreMenu)).click();
        allureReportingManager.stepsScreenshots();
        System.out.println("Learn More menu is selected");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(learnMoreMenuHeader)).getText(), "LEARN MORE");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(btnPlayPause)).isEnabled(), true);
        allureReportingManager.stepsScreenshots();
        System.out.println("Learn More screen is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPlayPause)).click();
        //System.out.println("'Learn more' features are implemented properly and running successfully");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
    }

    public void verifyCallHotelMenuFeatures() {

        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(callHotelMenu)).click();
        System.out.println("Call Hotel Menu is selected");
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(callDialerConsole)).isDisplayed(), true);
        System.out.println("Call Dialer screen is displayed");

        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
    }

    public void verifyPrivPolicyFeatures() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyLink)).click();
        allureReportingManager.stepsScreenshots();
        System.out.println("Privacy Policy link is clicked");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(privPolicyPageHeader)).getText(), "Privacy Policy");
        System.out.println("Privacy Policy is displayed");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
    }

    public void verifyTOSFeatures() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(tosLink)).click();
        System.out.println("Terms of use link is clicked");
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(tosPageHeader)).getText(), "TERMS OF SERVICE");
        System.out.println("Terms of use is displayed");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();
    }
}