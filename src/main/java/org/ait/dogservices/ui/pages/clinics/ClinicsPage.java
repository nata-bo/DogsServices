package org.ait.dogservices.ui.pages.clinics;


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

public class ClinicsPage extends BasePage {
    public ClinicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h1[contains(text(),'Stellen Sie sicher, dass Ihr Hund nict krank ist')]")
    WebElement titleClinics;
    public ClinicsPage verifyClinicsElement(String text) {
        Assert.assertTrue(isTextPresent(titleClinics, text));
        return this;
    }

    @FindBy(xpath = "//*[@id='_mainSection_1prhi_1']/div[2]/div[2]/div/form/div[1]/select")
    WebElement cityField;
    @FindBy(xpath = "//button[contains(text(),'Find clinics')]")
    WebElement cityButton;

  public ClinicsPage selectCity(String city1) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(cityField));
      Select select = new Select(cityField);
      select.selectByVisibleText(city1);
      click(cityButton);
      return this;
  }


    @FindBy(xpath="//button[contains(text(),'Show clinic list')]")
    WebElement clinicsListButton;
    public ClinicsPage clickClinicsList() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", clinicsListButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

      click(clinicsListButton);
      return this;
    }
    @FindBy(xpath="//*[@id='root']/div/section[2]/div/ul/li[1]/div[1]")
    WebElement clinicsListByCity;
    public ClinicsPage verifyClinicsByCity(String clinic) {
      Assert.assertTrue(isTextPresent(clinicsListByCity,clinic));
        return this;
    }
    @FindBy(xpath="//*[@id='root']/div/section[2]/div/ul/li[1]/div[1]")
    WebElement clinicsList;
    public ClinicsPage verifyClinics(String clinic) {
        Assert.assertTrue(isTextPresent(clinicsList,clinic));
        return this;
    }
}
