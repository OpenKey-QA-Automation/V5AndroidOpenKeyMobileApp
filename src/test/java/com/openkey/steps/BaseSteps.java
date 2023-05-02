package com.openkey.steps;

import com.openkey.reporting.AllureReportingManager;
import com.openkey.screens.*;
import com.openkey.server.objects.MqttClientClass;
import com.openkey.setups.CapabilitiesManager;
import io.appium.java_client.android.AndroidDriver;

public class BaseSteps extends CapabilitiesManager {

    protected OpenKeyHomeScreen openKeyHomeScreen;
    protected OpenKeyLoginScreen openKeyLoginScreen;
    protected OpenKeyDownloadMobileKeyScreen openKeyDownloadMobileKeyScreen;
    protected OpenKeyDoorLockScreen openDoorLockScreen;
    protected OpenKeyWelcomeMessageScreen openKeyWelcomeMessageScreen;
    protected MqttClientClass mqttClient;

    public void setupScreens(AndroidDriver driver, MqttClientClass mqttClient) {

        openKeyHomeScreen = new OpenKeyHomeScreen(driver, mqttClient);
        openKeyLoginScreen = new OpenKeyLoginScreen(driver, mqttClient);
        openKeyDownloadMobileKeyScreen = new OpenKeyDownloadMobileKeyScreen(driver, mqttClient);
        openDoorLockScreen = new OpenKeyDoorLockScreen(driver, mqttClient);
        openKeyWelcomeMessageScreen = new OpenKeyWelcomeMessageScreen(driver, mqttClient);

    }

}


