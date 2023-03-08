package com.openkey.setups;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Success of test cases and its details are : "+result.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Failure of test cases and its details are : "+result.getMethod());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Skip of test cases and its details are : "+result.getMethod());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("Failure of test cases with success percentage and its details are : "+result.getMethod());
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Test is getting started:");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Test is now finished:");
    }
}
