package com.testng;

import com.codeborne.selenide.Configuration;
import com.utils.WebDriverManagerUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestCase {
    Capabilities capabilities = Configuration.browserCapabilities;
    WebDriver driver = new WebDriverManagerUtil().createDriver(capabilities);

    @BeforeMethod
    void setup() {
        driver = new WebDriverManagerUtil().createDriver(capabilities);
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }
}
