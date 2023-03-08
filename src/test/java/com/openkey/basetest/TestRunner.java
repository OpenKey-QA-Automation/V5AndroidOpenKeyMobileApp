package com.openkey.basetest;

import com.openkey.reporting.AllureReport;
import com.openkey.reporting.DataBaseHandler;
import com.openkey.setups.CapabilitiesManager;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.SQLException;

@CucumberOptions(
    monochrome = true,
    //tags = "@WelcomeMessageAndroidApp or @LaunchOpenKeyAndroidApp or @LoginToOpenKeyAndroidApp or @DownloadMobileKey",
    tags = "not @MoreMenuAndroidApp",
    features = "src/main/com.openkey.resources/features",
    glue = {"com.openkey.steps", "com.openkey.reporting"},
    publish = true,
    plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","com.openkey.reporting.AllureReportingManager"}
)

public class TestRunner extends CapabilitiesManager {

    private TestNGCucumberRunner testNGCucumberRunner;
    static AllureReport allureReport ;
    static DataBaseHandler dataBaseHandler;

    public TestRunner() throws IOException {

        allureReport = new AllureReport();
        dataBaseHandler = new DataBaseHandler();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeTest(alwaysRun = true)
    public void cleanOldReportsData() throws IOException {

        allureReport.cleanUpAllureDirectory();
   }

    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {

        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    //If any step method failing execution failed at this point executions stopped
    @AfterMethod
    public void haltExecutionOnFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            testNGCucumberRunner.finish();
        }
    }

    @DataProvider
    public Object[][] scenarios() {

        return testNGCucumberRunner.provideScenarios();
    }

    @AfterTest (alwaysRun = true)
    public void createPropFile() throws IOException, SQLException, ClassNotFoundException {

        allureReport.envFileWriter();
        allureReport.executorFileWriter();
        dataBaseHandler.setupConnection();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {

        if (driver.removeApp(appPackage)) {
            System.out.println("App is uninstalled");
        }
        testNGCucumberRunner.finish();
    }
}


