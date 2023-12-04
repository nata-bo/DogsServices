package org.ait.dogservices.mob;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class KennelPageHelper extends BaseHelperMob{
    public KennelPageHelper(AndroidDriver driver) {
        super(driver);
    }


    public String selectCity(int index) {


        WebElement dropdown = driver.findElement(By.xpath("//*/div[2]/div[2]/div/form/div[1]/select"));
        dropdown.click();

        List<WebElement> options = driver.findElements(By.xpath("//*/div[2]/div[2]/div/form/div[1]/select/option"));
        if (index >= 0 && index < options.size()) {
            options.get(index).click();
            return options.get(index).getText();
        }

        return null;

    }

    public void tabOnButtonFind() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//button[contains(text(),'Find kennels')]")));
        tap(By.xpath("//button[contains(text(),'Find kennels')]"));
    }

    public void tabOnButtonShow() {     //android.widget.Button[@text="Swow kennels list"]
        tap(By.xpath("//button[contains(text(),'Swow kennels list')]"));
    }

    public boolean isKennelPresent() {     //android.widget.ListView/android.view.View[2]
        return isElementPresent(By.xpath("//*/div/ul/li[2]"));
    }

    public boolean isKennelsPresent() {
        return isElementPresent(By.xpath("//*/div/ul"));
    }









}

