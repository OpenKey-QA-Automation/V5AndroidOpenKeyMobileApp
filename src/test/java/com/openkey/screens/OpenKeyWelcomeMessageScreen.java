package com.openkey.screens;

import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Set;

import static com.openkey.setups.CapabilitiesManager.allureReportingManager;

public class OpenKeyWelcomeMessageScreen extends BaseScreen {

    By welcomeMessageBody = By.xpath("//android.widget.TextView[contains(@text,'a mobile key is waiting for you')]");
    By txtWlcmMsg= By.id("android:id/message_text");
    By screenOpenkeyPlayStore= By.xpath("//android.widget.TextView[contains(@text,'OpenKey')]");
    By btnInstallOpenKeyPlayStore= By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[5]/android.widget.Button");//Change xpath
    By txtUpdateAvailable= By.id("com.openkey.guest:id/description");
    By btnUpdatenow = By.id("com.openkey.guest:id/btnUpdateLater");
    By btnUpdateOpenKeyPlayStore= By.xpath("//android.widget.TextView[@text='Update']");

    public OpenKeyWelcomeMessageScreen(AndroidDriver driver, MqttClientClass mqttClient) {

        super(driver);
    }

    public void verifyWelcomeMessageNotification() {
        driver.openNotifications();
        driver.context("NATIVE_APP");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(txtWlcmMsg)).isDisplayed(),true);
        allureReportingManager.stepsScreenshots();
    }

    public void verifyWelcomeNotificationClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtWlcmMsg)).click();
        System.out.println("Welcome message notification clicked");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyWelcomeMessageBody() {
        driver.context("NATIVE_APP");
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageBody)).getText().contains("a mobile key is waiting for you at Hotel Experience V3. Download the app here https://connector.openkey.co/apps/1"));
        System.out.println ("Welcome message is validated");
        allureReportingManager.stepsScreenshots();
    }

    public void verifyAppLanuchFrmDownloadLink() throws InterruptedException {

        String appdownlodLink = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageBody)).getText().split("Download the app here")[1];
        System.out.println("OpenKey App Download link is :" + appdownlodLink);
        WebElement embedDownloadLink = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageBody));

        Point point = embedDownloadLink.getLocation();
        int x = point.x + 1;
        int y = point.y + embedDownloadLink.getSize().getHeight() - 1;

        if (driver.isAppInstalled("com.openkey.guest")) {
            System.out.println("OpenKey app is already installed in device");
            allureReportingManager.stepsScreenshots();
            new TouchAction(driver).tap(PointOption.point(x, y)).perform();
            Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(screenOpenkeyPlayStore)).getText(), "OpenKey");
            System.out.println("OpenKey app download link navigates to Play Store, Click on Open button to launch the installed build");
            allureReportingManager.stepsScreenshots();
        }

        else
        {
            System.out.println("OpenKey app is not installed in the device");
            allureReportingManager.stepsScreenshots();
            new TouchAction(driver).tap(PointOption.point(x, y)).perform();
            Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(screenOpenkeyPlayStore)).getText(), "OpenKey");
            System.out.println("OpenKey app download link navigates to Play Store, Click on Install button to install the latest build");
            allureReportingManager.stepsScreenshots();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnInstallOpenKeyPlayStore)).get(0).click();
            Thread.sleep(20000);
            Assert.assertTrue(driver.isAppInstalled("com.openkey.guest"));
            System.out.println("OpenKey app is installed in the device");

        }
    }
}