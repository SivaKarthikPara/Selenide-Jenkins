package com.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.properties.PropertiesController;
import com.runner.RunnerMode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManagerUtil implements WebDriverProvider {

    private static final Logger LOG = LoggerFactory.getLogger(WebDriverManagerUtil.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        WebDriver driver = null;
        RunnerMode runnerMode = RunnerMode.valueOf(PropertiesController.getProperty("runner.mode", "LOCAL"));
        String gridUrl = PropertiesController.getProperty("grid.url");

        switch (runnerMode) {
            case LOCAL:
                LOG.info("Launching chrome on local");
                capabilities.merge(Configuration.browserCapabilities);
                WebDriverManager.chromedriver().capabilities(capabilities).setup();
                driver = new ChromeDriver();
                break;
            case GRID:
                try {
                    LOG.info("Connecting to selenium grid");
                    driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        LOG.info("Session capabilities {}", capabilities);
//        assert driver != null;
        return driver;
    }
}
