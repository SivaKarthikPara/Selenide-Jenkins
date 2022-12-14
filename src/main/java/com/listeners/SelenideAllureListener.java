package com.listeners;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

public class SelenideAllureListener extends ExitCodeListener {

    private static final Logger LOG = LoggerFactory.getLogger(SelenideAllureListener.class);

    @Override
    public void onStart(ITestContext context) {
        super.onStart(context);
        LOG.info("{} Test Execution started", context.getName());
        Configuration.browser = "com.utils.WebDriverManagerUtil";
        Configuration.reportsFolder = "target/test-reports";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
               .screenshots(true)
               .savePageSource(true)
        );
    }

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("Test Execution result = {} ", result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("Test Execution result = {} ", result.getStatus());
    }
}
