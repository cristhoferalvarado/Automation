package org.project.configurations.testng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.project.configurations.selenium.TestCaseBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CustomListener2  implements ITestListener {
    int _TestCaseCount = 0;
    @Override
    public void onTestStart(ITestResult iTestResult) {
       // System.out.println("\t|-- Estamos en el metodo onTestStart");
        _TestCaseCount ++;
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
       // System.out.println("\t|-- Estamos en el metodo onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //System.out.println("\t|-- Estamos en el metodo onTestFailure");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("\t|-- Estamos en el metodo onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //System.out.println("\t|-- Estamos en el metodo onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //System.out.println("\t|-- Estamos en el metodo onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("\t|-- Se corrieron "+_TestCaseCount);
    }

}
