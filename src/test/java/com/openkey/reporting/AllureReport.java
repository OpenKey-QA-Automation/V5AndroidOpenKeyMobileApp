package com.openkey.reporting;

import com.openkey.screens.OpenKeyDoorLockScreen;
import com.openkey.setups.CapabilitiesManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.util.Properties;

public class AllureReport extends CapabilitiesManager {

    String path;
    String allureDirectPath = "allure-results";
    Properties properties;
    File screenshotFile;
    File fl = new File(allureDirectPath);

    /**Checking if allure-results is not empty and clean it*/
    public void createAllureDirectory() {

        if (fl.mkdir()==true) {

            System.out.println("'allure-results' directory is now created");
        }

        else {

            System.out.println("Unable to create Directory");
        }
    }

    public void cleanUpAllureDirectory() throws IOException {

        if (fl.exists() && fl.isDirectory()) {

            if (new File("allure-results").list().length > 0) {

                FileUtils.cleanDirectory(new File(allureDirectPath));
            }
        }
        else {

            createAllureDirectory();
        }
    }

    /**Writing Data into the Environment variable*/
    public void envFileWriter() throws IOException {

        path = "allure-results/environment.properties";

        FileOutputStream outputStream = new FileOutputStream(path, true);

        properties = new Properties();

        properties.put("Device Name :", deviceName);
        properties.put("deviceType :", platformName);
        properties.put("platformVersion :", platformVersion);
        properties.put("Total number of times the test executed :", String.valueOf(OpenKeyDoorLockScreen.totalNumberOfLockOpeningAttempts));
        properties.put("Number of times lock opened successfully :", String.valueOf(OpenKeyDoorLockScreen.lockOpenSuccessCount));
        properties.put("Number of times lock failed to open :",  String.valueOf(OpenKeyDoorLockScreen.lockOpenFailureCount));
        properties.store(outputStream,"Allure Report Results");
    }

    /**Writing Data into the Executor Details*/
    public void executorFileWriter() throws IOException {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", System.getenv("USER"));
        jsonObject.put("buildName", appPackage);
        jsonObject.put("type", "LocalRun");

        FileWriter fr = new FileWriter("allure-results/executor.json");
        fr.write(jsonObject.toString());
        fr.flush();
    }

        public void methodtakescreenShot() throws IOException {

        screenshotFile  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File targetFile=new File("allure-results/"+System.currentTimeMillis()+".png");

        FileUtils.copyFile(screenshotFile,targetFile);
    }

    public void addScreenshot(String name) throws FileNotFoundException {

        Allure.addAttachment(name, new FileInputStream(screenshotFile));
    }
}
