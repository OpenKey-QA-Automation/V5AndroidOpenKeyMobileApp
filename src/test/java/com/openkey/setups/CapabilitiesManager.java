package com.openkey.setups;

import com.google.common.collect.ImmutableMap;
import com.openkey.reporting.AllureReportingManager;
import com.openkey.server.objects.MqttClientClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.module.Configuration;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CapabilitiesManager {

    /**
     * Make the driver static. This allows it to be created only once
     * and used across all the test classes.
     */
    //protected AppiumDriver driver;
    public static AndroidDriver driver;
    public static String appPackage;
    public static MqttClientClass mqttClient;
    public static String platformName;
    public static String platformVersion;
    public static String deviceName;

    public static int lockCounter=0;

    public static AllureReportingManager allureReportingManager;

    public static Logger logger = LogManager.getLogManager().getLogger("CapabilitiesManager.class");

    public static SessionId sessionId;
    /*// BrowserStack CapabilitiesManager
    public static String userName = "monalirajgor_jbYTIH";
    public static String accessKey = "dHT1pQpC7gmB3xnEdAuh";*/

    // Appium Local service
    //protected AppiumDriverLocalService service;

    /**
     * This method runs before any other method,
     * We are setting up our appium client in order to connect ios and android devices to appium server
     */
    @BeforeTest
    public void preparation() throws IOException, MqttException {

        allureReportingManager = new AllureReportingManager();
        // Use empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
        YamlConfigReader.inititializeyaml();

        // Reading capabilities from yaml file using getDesired_capabilities() method in YamlConfigReader class
        String [] desiredCapabilities= YamlConfigReader.getDesired_capabilities();
        platformName = desiredCapabilities[0];
        platformVersion = desiredCapabilities[1];
        deviceName = desiredCapabilities[2];
        appPackage = desiredCapabilities[3];
        String appActivity = desiredCapabilities[4];
        String orientation = desiredCapabilities[5];
        lockCounter = Integer.parseInt(desiredCapabilities[6]);


        String [] getCredentials= YamlConfigReader.getCredentials();
        String appId = getCredentials[0];
        String userName = getCredentials[1];
        String password = getCredentials[2];

        System.out.println("App Center credentials :");
        System.out.println("Id : " +appId);
        System.out.println("user : " +userName);
        System.out.println("Password : " +password);

        System.out.println("Desired CapabilitiesManager");
        System.out.println("Device Name : " +deviceName);
        System.out.println("deviceType : " +platformName);
        System.out.println("platformVersion : " +platformVersion);
        /** Commented appPackage and appActivity because we've automated installing and launch app through app center*/
       //System.out.println("appPackage : " +appPackage);
       //System.out.println("appActivity : " +appActivity);
        System.out.println("orientation : " +orientation);
        System.out.println("lock counter : " +lockCounter);

        // Read the DesiredCapabilities from ok-envds.yaml for OpenKey V5 Live-Debug App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        /** Commented appPackage and appActivity because we've automated installing and launch app through app center*/
        //capabilities.setCapability("appPackage", appPackage);
        //capabilities.setCapability("appActivity", appActivity);

        /*//Set the DesiredCapabilities for OpenKey V5 Live-Debug App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY22DSLQJ9");
        capabilities.setCapability("appPackage", "com.openkey.guest");
        capabilities.setCapability("appActivity", "com.openkey.guest.ui.activities.LauncherActivity");*/

        // Set Device orientation
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, orientation);

        // Appium CapabilitiesManager
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("ignoreHiddenApiPolicyError", "true");

        /*// BrowserStack CapabilitiesManager
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Motorola Moto G9 Play");
        capabilities.setCapability(MobileCapabilityType.APP, "bs://33ccec19c788f970b360a84a9332a1dde1e94227");

        // BrowserStack CapabilitiesManager Stop app, clear app data and uninstall apk before session starts and after test
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
        capabilities.setCapability("browserstack.video", "true");*/

        // Start Appium Server - Using appium command in Terminal
//        Runtime runtime = Runtime.getRuntime();
//
//        try {
//            runtime.exec("appium");
//            System.out.println("Appium server starting...");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Appium server not started!");
//
//        }

        //setting up chrome as browser capability



        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("appPackage", "com.android.chrome");
        //capabilities.setCapability("appActivity", "com.google.android.apps.chrome.IntentDispatcher");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        //capabilities.setCapability("intentAction", "android.intent.action.LAUNCHER");
        //capabilities.setCapability("intentCategory", "android.intent.category.MAIN");
        capabilities.setCapability("chromedriverExecutableDir", "chromedriver/chromedriver.exe");
        capabilities.setCapability("chromedriver_autodownload", "C://OpenKey Programs//OpenKeyMobileApp//chromedriver");
        //capabilities.setCapability("chromedriverExecutableDir", "C:\\OpenKey Programs\\OpenKeyMobileApp\\chromedriver\\chromedriver.exe");
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        // Start Session in Android Device
        final URL server = new URL("http://localhost:4723/wd/hub");
        mqttClient = new MqttClientClass("tcp://192.168.1.152:1883", "Assa_Rail/command", "Assa_Rail/response"); //Change based on rail
        driver = new AndroidDriver(server, capabilities);




        System.out.println("Appium server started..." + server);
        System.out.println("Android session started:" + capabilities);


        // Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("Browser Launched");
        //driver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
        driver.get("https://host.openkey.co/login");
        System.out.println("Host portal login link is opened");

       /* // Initialize the remote Webdriver using BrowserStack remote URL access credentials and desired capabilities defined above
        driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
        System.out.println("Appium server started..." + "https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub");
        System.out.println("Android session started:" + capabilities);*/
        System.out.println(System.getenv());
        sessionId=driver.getSessionId();
    }

    @AfterTest
        // Stop Appium Server
        public void stopAppiumServer() {

        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("killall node");
            System.out.println("Appium server stopped...");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No matching appium processes belonging to you were found!");

        }
    }
}

/*
        // Set the DesiredCapabilities for WhiteLabel Newbury App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY22DSLQJ9");
        capabilities.setCapability("appPackage", "com.openkey.newbury");
        capabilities.setCapability("appActivity", "com.openkey.whitelabels.ui.activities.LauncherActivity");

        // Set the DesiredCapabilities for React Native API Level App capabilities only for local attached device with system
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY22DSLQJ9");
        capabilities.setCapability("appPackage", "com.openkey");
        capabilities.setCapability("appActivity", "com.openkey.MainActivity");

        //Start Appium Server - First Method not working (Using AppiumDriverLocalService)
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        //Get URL where appium server hosted i.e 'http://127.0.0.1:4723/wd/hub'
        String service_url = service.getUrl().toString();
        System.out.println("Appium Service Address: " + service_url);
        driver = new AppiumDriver(new URL(service_url), capabilities);
        driver.manage().timeouts().wait(30);

        //Build the Appium service - Second Method not working (Using Build Service)
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File("/usr/local/Cellar/node/18.5.0/bin/node"));
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(capabilities);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Appium Server Started");

        Start Appium Server - (Using Appium.js with Node.exe) - Working
        CommandLine cmd = new CommandLine("/usr/local/Cellar/node/18.5.0/bin/node");
        cmd.addArgument("/usr/local/lib/node_modules/appium/build/lib/appium.js");
        cmd.addArgument("--address");
        cmd.addArgument("127.0.0.1");
        cmd.addArgument("--port");
        cmd.addArgument("4723");

        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);

        try {
          executor.execute(cmd, handler);
          Thread.sleep(10000);
          System.out.println("Appium Server Started");
          }
        catch (IOException | InterruptedException e) {
           e.printStackTrace();
           System.out.println("Appium Server not Started");
         }

        Start Appium service - Fourth Method not working (Using node executable & appium executable path with static ip address & port) - Not Working
        String Appium_Node_Path="/usr/local/Cellar/node/18.5.0/bin/node";
        String Appium_JS_Path="/usr/local/lib/node_modules/appium/build/lib/main.js";

        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
            .usingDriverExecutable(new File(Appium_Node_Path))
            .withAppiumJS(new File(Appium_JS_Path))
            .withIPAddress("127.0.0.1")
            .usingPort(4723));
        service.start();

        driver = new AppiumDriver(HttpClient.Factory.create("http://127.0.0.1:4723/wd/hub"), capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().wait(35);*/


