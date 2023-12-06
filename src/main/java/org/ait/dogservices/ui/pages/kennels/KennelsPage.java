package org.ait.dogservices.ui.pages.kennels;


import org.ait.dogservices.ui.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class KennelsPage extends BasePage {
    public KennelsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//button[contains(text(),'Swow kennels list')]")
    WebElement titleKennels;
    public KennelsPage verifyKennelsElement(String text) {
        Assert.assertTrue(isTextPresent(titleKennels, text));
        return this;
    }



    @FindBy(xpath = "//*[@id='_mainSection_1n1nd_1']/div[2]/div[2]/div/form/div[1]/select")
    WebElement cityKennelsField;
    @FindBy(xpath = "//button[contains(text(),'Find kennels')]")
    WebElement cityButton;
    public KennelsPage selectKennelsCity(String city1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cityKennelsField));
        Select select = new Select(cityKennelsField);
        select.selectByVisibleText(city1);
        click(cityButton);
        return this;
    }


    @FindBy(xpath="//button[contains(text(),'Swow kennels list')]")
    WebElement kennelsListButton;
    public KennelsPage clickKennelsList() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", kennelsListButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        click(kennelsListButton);
        return this;
    }
    @FindBy(xpath="//*[@id='_clinicsSection_1n1nd_1']/div/ul/li[1]/div[1]")
    WebElement kennelsListByCity;
    public KennelsPage verifyKennelsByCity(String kennel) {
        Assert.assertTrue(isTextPresent(kennelsListByCity,kennel));
        return this;
    }
    @FindBy(xpath="//*[@id='_clinicsSection_1n1nd_1']/div/ul/li[2]/div[1]")
    WebElement kennelsList;
    public KennelsPage verifyKennels(String kennel) {
        Assert.assertTrue(isTextPresent(kennelsList,kennel));
        return this;
    }
}

