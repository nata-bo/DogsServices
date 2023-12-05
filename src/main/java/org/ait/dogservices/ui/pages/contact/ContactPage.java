package org.ait.dogservices.ui.pages.contact;


import org.ait.dogservices.ui.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName= "iframe")
    List<WebElement> iframes;

    public ContactPage returnListOfFrames() {
        System.out.println("The total numbers of iframes: " + iframes.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length"). toString());
        System.out.println("The total numbers of items: " + numberOfIframes);
        return this;
    }


    @FindBy(name= "name")
    WebElement userNameContactField;
    @FindBy(name="email")
    WebElement userEmailContactField;
    @FindBy(id= "message")
    WebElement messageContactField;

    public ContactPage enterUserData(String userNameForContactForm, String userEmailForContactForm,
                                     String messageForContactForm) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", userNameContactField);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        type(userNameContactField,userNameForContactForm);
        click(userEmailContactField);
        type(userEmailContactField,userEmailForContactForm);
        click(messageContactField);
        type(messageContactField,messageForContactForm);
        return this;
    }

    @FindBy(xpath= "//button[contains(text(),'Send message')]")
    WebElement sendMessage;
    public ContactPage sendMessageButton() {
        click(sendMessage);
        return null;
    }

    @FindBy(xpath = "//*[@id='_siteContact_1de5h_1']/section/div")
    WebElement contactData;
    public ContactPage isContactDataPresent(String contact) {
        Assert.assertTrue(isTextPresent(contactData,contact));
        return this;
    }
}


