package com.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final Logger LOG = LoggerFactory.getLogger(RetryAnalyzer.class);
    static final int maxRetryCount = 2;
    static int retryCount = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (iTestResult.getStatus() != 1 && retryCount <= maxRetryCount) {
            retryCount++;
            LOG.info("Retry attempt Number - {}", retryCount);
            return true;
        }

        return false;
    }

}
