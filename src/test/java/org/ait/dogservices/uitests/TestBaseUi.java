package org.ait.dogservices.uitests;

import org.ait.dogservices.ui.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class TestBaseUi {
    Logger logger = LoggerFactory.getLogger(TestBaseUi.class);
    String browser = System.getProperty("browser", Browser.CHROME.browserName());

    public WebDriver driver;

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("*****************************");
        logger.info("Start method --> " + m.getName());
    }


    @BeforeMethod
    public void init() {
        System.err.close();
        //driver = new ChromeDriver();
        if (browser.equalsIgnoreCase(Browser.CHROME.browserName())) {
            driver = new ChromeDriver();
            logger.info("All test run in Chrome browser");
        } else if (browser.equalsIgnoreCase(Browser.FIREFOX.browserName())) {
            driver = new FirefoxDriver();
            logger.info("All test run in Firefox browser");
        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator(listener).decorate(driver);
        driver.get("https://dog-app-iw6ow.ondigitalocean.app/");
        logger.info("The link --> " + driver.getCurrentUrl());
        logger.info("***********************************");
        driver.manage().window().maximize();
        Duration timeout = Duration.ofSeconds(10);
        driver.manage().timeouts().implicitlyWait(timeout.getSeconds(), TimeUnit.SECONDS);

    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}

