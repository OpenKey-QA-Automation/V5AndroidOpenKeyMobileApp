package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class OpenKeyMoreMenuScreen extends BaseScreen {

    /** Mobile Element */
    By btnWifiFooterMenu = By.id ("com.openkey.guest:id/txtWifi");
    By wifiScreenHeader = By.id("com.openkey.guest:id/txtErrorTitle");
    By btnPopupClose = By.id("com.openkey.guest:id/btnClose");

    /** More Menu */
    By btnMoreFooterMenu = By.id("com.openkey.guest:id/txtBottomMenu");
    By listOptionHotelInfo = By.id("com.openkey.guest:id/txtHotelInfo");
    By listOptionExpressCheckout = By.id("com.openkey.guest:id/txtExpressCheckOut");
    By listOptionPromotions = By.id("com.openkey.guest:id/txtPromotion");



    /** Hotel Information */
    By facebookIcon = By.id("com.openkey.guest:id/imageFacebook");
    By logoFacebook = By.xpath("//android.widget.Image[contains(@text, 'facebook')]");
    By linkedinIcon = By.id("com.openkey.guest:id/imageLinkedIn");
    By logoLinkedIn = By.id("com.linkedin.android:id/ad_full_logo_image");
    By instaGramIcon = By.id("com.openkey.guest:id/imageInstagram");
    By logoInstagram = By.xpath("//android.widget.Button[contains(@text, 'Instagram')]");
    By twitterIcon = By.id("com.openkey.guest:id/imageTwitter");
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
    By callDialerConsole = By.id("com.google.android.dialer:id/digits");

    /** Promotions */
    By headerPromotionsScreen = By.xpath("//android.widget.TextView[ contains(@text,'Promotions')]");

    /** Express Checkout */
    By headerExpChkoutScreen = By.xpath("//android.widget.TextView[ contains(@text,'Express Checkout')]");
    By btnCheckout = By.id("com.openkey.guest:id/btnCheckOut");

    By headerExpiredKeyScreen = By.id("com.openkey.guest:id/txtExpireTitle");

    By btnFeedbackSadEmoji = By.id ("com.openkey.guest:id/imgSadFace");

    By btnFeedbackNeutralEmoji = By.id("com.openkey.guest:id/imgNutralFace");

    By btnFeedbackHappyEmoji = By.id("com.openkey.guest:id/imgHappyFace");

    By textBoxFeedback = By.id("com.openkey.guest:id/edtFeedback");

    By btnSubmitFeedback = By.id("com.openkey.guest:id/btnWriteSubmitReview");

    By popupFeedbackSuccess = By.xpath("//android.widget.TextView[contains(@text,'Success')]");

    By postSubmitScreen = By.xpath("//android.widget.TextView[contains(@text,'Search')]");

    By btnSkip = By.id("com.openkey.guest:id/txtSkip");

    By txtHappyEmoji = By.id("com.openkey.guest:id/txtLeaveCommentReviewTitle");


    public OpenKeyMoreMenuScreen(AndroidDriver driver, MqttClientClass mqttClient) {
        super(driver);
    }


    /** Actions */
    public void verifyWifiFooterMenu() {

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(btnWifiFooterMenu)).isDisplayed(),true);
        System.out.println("Wifi button is displayed on My Key screen footer");
        allureReportingManager.stepsScreenshots();

    }

    public void verifyWifiScreenActions() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnWifiFooterMenu)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(wifiScreenHeader)).getText(),"Wifi Access");
        System.out.println("Wifi Access screen is displayed");
        driver.navigate().back();

    }

    public void verifyMoreMenu() {

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(btnMoreFooterMenu)).isDisplayed(),true);
        System.out.println("More menu button is displayed");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyMoreMenuActions() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnMoreFooterMenu)).click();
        allureReportingManager.stepsScreenshots();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(listOptionHotelInfo)).getText(),"Hotel Information");
        System.out.println("Hotel Information menu option is displayed");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(listOptionExpressCheckout)).getText(),"Express Checkout");
        System.out.println("Express Checkout menu option is displayed");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(listOptionPromotions)).getText(),"Promotions");
        System.out.println("Promotions menu option is displayed");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyHotelInformationOption() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(listOptionHotelInfo)).click();
        System.out.println("Hotel Information menu option is selected");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyHotelInformationActions() throws InterruptedException {

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(facebookIcon)).isDisplayed(), true);
        System.out.println("Facebook icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(facebookIcon)).click();
        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(logoFacebook)).isDisplayed(), true);
        allureReportingManager.stepsScreenshots();
        Thread.sleep(5000);
        System.out.println("Facebook app is launched");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(linkedinIcon)).isDisplayed(), true);
        System.out.println("LinkedIn icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkedinIcon)).click();
        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(logoLinkedIn)).isDisplayed(), true);
        allureReportingManager.stepsScreenshots();
        Thread.sleep(5000);

        System.out.println("LinkedIn app is launched");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(instaGramIcon)).isDisplayed(), true);
        System.out.println("Instagram icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(instaGramIcon)).click();
        allureReportingManager.stepsScreenshots();
        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(logoInstagram)).isDisplayed(), true);
        Thread.sleep(5000);

        System.out.println("Instagram app is launched");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(twitterIcon)).isDisplayed(), true);
        System.out.println("Twitter icon is displayed over Hotel Information screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(twitterIcon)).click();
        allureReportingManager.stepsScreenshots();
        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(logoTwitter)).isDisplayed(), true);
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
        //driver.navigate().back();
        Thread.sleep(3000);
    }

    public void verifyPromotions() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnMoreFooterMenu)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOptionPromotions)).click();
        allureReportingManager.stepsScreenshots();
        System.out.println("Promotions option is selected");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(headerPromotionsScreen)).getText(), "Promotions");
        System.out.println("Promotions screen is displayed");
        allureReportingManager.stepsScreenshots();
        driver.navigate().back();
        allureReportingManager.stepsScreenshots();

    }

    public void verifyExpressCheckoutOption() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnMoreFooterMenu)).click();
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOptionExpressCheckout)).click();
        System.out.println("Express Checkout option is selected");
        allureReportingManager.stepsScreenshots();


    }

    public void verifyExpressCheckoutScreenItems() {

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(headerExpChkoutScreen)).getText(), "Express Checkout");
        System.out.println("Express Checkout screen is displayed");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnCheckout)).click();
        allureReportingManager.stepsScreenshots();

    }

    public void verifyExpressCheckoutSuccess() {

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(headerExpiredKeyScreen)).getText(), "EXPIRED KEY");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyFeedbackEmojiSelection() {

        Assert.assertEquals (wait.until(ExpectedConditions.visibilityOfElementLocated(btnFeedbackSadEmoji)).isEnabled(),true);
        System.out.println("Sad emoji is appearing enabled");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnFeedbackSadEmoji)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals (wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxFeedback)).isDisplayed(),true);
        System.out.println("Sad emoji is selected");

        Assert.assertEquals (wait.until(ExpectedConditions.visibilityOfElementLocated(btnFeedbackNeutralEmoji)).isEnabled(),true);
        System.out.println("Neutral emoji is appearing enabled");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnFeedbackNeutralEmoji)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertEquals (wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxFeedback)).isDisplayed(),true);
        System.out.println("Neutral emoji is selected");

        Assert.assertEquals (wait.until(ExpectedConditions.visibilityOfElementLocated(btnFeedbackHappyEmoji)).isEnabled(),true);
        System.out.println("Happy emoji is appearing enabled");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnFeedbackHappyEmoji)).click();
        allureReportingManager.stepsScreenshots();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(txtHappyEmoji)).isDisplayed());
        System.out.println("Happy emoji is selected");

    }

    public void verifyFeedbackCommentSubmit() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxFeedback)).sendKeys("Test");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmitFeedback)).click();
        allureReportingManager.stepsScreenshots();

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(popupFeedbackSuccess)).getText(), "Success");
        System.out.println("Feedback is submitted successfully");
        allureReportingManager.stepsScreenshots();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnPopupClose)).click();
        allureReportingManager.stepsScreenshots();
    }

    public void verifyPostFeedbackSubmission() {

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(postSubmitScreen)).getText(), "Search");
        System.out.println("Guest is navigated back to Hotel Search Screen after submitting feedback");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyActionSkipORFeedbackComment() {

        if (driver.findElement(txtHappyEmoji).isDisplayed()) {
            allureReportingManager.stepsScreenshots();
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnSkip)).click();
            allureReportingManager.stepsScreenshots();
            System.out.println("Guest Clicks on Skip button");
        }
        else
        {
            verifyFeedbackCommentSubmit();

        }
    }
}
