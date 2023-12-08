package org.ait.dogservices.mob;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelperMob {
    AndroidDriver driver;

    //AppiumDriver driver;

    public BaseHelperMob(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if(text!= null) {
            waitForElementAndTap(locator,10);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
        driver.hideKeyboard();
       // ((JavascriptExecutor) driver).executeScript("mobile: hideKeyboard");
    }
    public  boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void swipe(double start, double stop) {

        TouchAction action = new TouchAction<>((PerformsTouchActions) driver);

        Dimension size = driver.manage().window().getSize();
        //get x point
        int x = size.width/2;
        //get y point
        int startY = (int) (size.height*start);
        int stopY = (int) (size.height*stop);
        action.longPress(PointOption.point(x,startY))
                .moveTo(PointOption.point(x,stopY))
                .release().perform();
    }
    public void swipeInElement(By locator, double startPoint,double stopPoint) {
        TouchAction action = new TouchAction<>((PerformsTouchActions) driver);

        Dimension size = driver.manage().window().getSize();

        // get activity point(y)
        int y = (int)(size.height*startPoint);
        int y2 = (int)(size.height*stopPoint);

        // get Locator's point
        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX)/2;
        action.longPress(PointOption.point(middleX,y))
                .moveTo(PointOption.point(middleX,y2))
                .release().perform();
    }


    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForElementAndTap(By locator, int timeout){
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

}
