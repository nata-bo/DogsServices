package org.ait.dogservices.ui.pages.about;


import org.ait.dogservices.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }


    //@FindBy(xpath="//h1[contains(text(),'About us')]")
    @FindBy(xpath = "//a[contains(text(),'Find')]")
    WebElement titleAboutUs;
    public AboutPage verifyAboutElement(String text) {
        Assert.assertTrue(isTextPresent(titleAboutUs, text));
        return this;
    }
}
