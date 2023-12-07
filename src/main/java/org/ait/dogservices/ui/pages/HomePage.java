package org.ait.dogservices.ui.pages;

import org.ait.dogservices.ui.pages.about.AboutPage;
import org.ait.dogservices.ui.pages.clinics.ClinicsPage;
import org.ait.dogservices.ui.pages.contact.ContactPage;
import org.ait.dogservices.ui.pages.kennels.KennelsPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/img[1]")
    WebElement firstPicture;

    public boolean isHomeComponentPresent() {
        return firstPicture.isDisplayed();
    }


    public boolean isRegistrationLinkPresent() {
        return registrationLink.isDisplayed();
    }


    @FindBy(css = "#name-input[name='firstName']")
    WebElement firstNameField;
    @FindBy(css = "#name-input[name='lastName']")
    WebElement lastNameField;
    @FindBy(css = "#name-input[name='userName']")
    WebElement usernameField;
    @FindBy(css = "#name-input[name='city']")
    WebElement cityField;
    @FindBy(css = "#name-input[name='zip']")
    WebElement zipField;
    @FindBy(css = "#name-input[name='username']")
    WebElement emailField;
    @FindBy(css = "#password-input[name='password']")
    WebElement passwordField;
    @FindBy(css = "#password-repeat-input[name='passwordRepeat']")
    WebElement repeatPasswordField;

    public HomePage enterRegistrationData(String firstName, String lastName, String username,
                                          String city, String zip, String email, String password,
                                          String repeatPassword) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(usernameField, username);
        type(cityField, city);
        type(zipField, zip);
        type(emailField, email);
        type(passwordField, password);
        type(repeatPasswordField, repeatPassword);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Betreten')]")
    WebElement loginLink;

    public HomePage getLoginLink() {
        click(loginLink);
        return this;
    }

    @FindBy(css = "#name-input[name='username']")
    WebElement userLoginField;

    public HomePage enterLoginData(String username, String password) {
        type(userLoginField, username);
        type(passwordField, password);
        return this;
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
    WebElement submitFormButton;

    public HomePage submit() {
        click(submitFormButton);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement OkButton;

    public HomePage clickOk() {
        pause(1000);
        click(OkButton);
        return this;
    }


    @FindBy(xpath = "//button[contains(text(),'Log Out')]")
    WebElement logoutLink;

    public HomePage verifyLogout(String logout) {
        Assert.assertTrue(shouldHaveText(logoutLink, logout, 10));
        pause(10);
        return this;
    }
    @FindBy(xpath = "//button[contains(text(),'Anmeldung')]")
            WebElement registrationLink;

    public HomePage getRegistrationLink() {
        click(registrationLink);
        return this;
    }


    @FindBy(css = ".form-check-input")
    WebElement checkbox;

    public HomePage clickOnCheckBox() {
        click(checkbox);
        return this;
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
    WebElement submitButton;
       public HomePage submitInRegistrationForm() {
        pause(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();
            return this;
          }

    @FindBy(css = ".invalid-feedback.mb-3")
    WebElement wrongUserName;

    public void warningWrongUserName(String textAboutMistake) {
        Assert.assertTrue(shouldHaveText(wrongUserName, textAboutMistake, 10));
    }


    @FindBy(css = ".invalid-feedback.mb-3")
    WebElement wrongEmail;

    public boolean warningWrongEmail() {
        return wrongEmail.isDisplayed();
    }


    @FindBy(xpath = "//a[contains(text(),'Clinics')]")
    WebElement clinicsLink;

    public ClinicsPage getClinics() {
        click(clinicsLink);
        return new ClinicsPage(driver);

    }

    @FindBy(xpath = "//a[contains(text(),'Kennels')]")
    WebElement kennelsLink;

    public KennelsPage getKennels() {
        click(kennelsLink);
        return new KennelsPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Um')]")
    WebElement aboutLink;

    public AboutPage getAbout() {
        pause(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutLink).click().perform();
      //  click(aboutLink);
        return new AboutPage(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Ende der Registrierung')]")
    WebElement finishingRegistrationLink;

    public HomePage verifyFinishingRegistration(String text) {
        Assert.assertTrue(shouldHaveText(finishingRegistrationLink, text, 20));
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Kontakt')]")
    WebElement contactLink;

    public ContactPage getContact() {
        click(contactLink);
        return new ContactPage(driver);
    }


    @FindBy(xpath = "//*[@id='root']/footer/div[1]/div[1]/div[2]/a[1]")
    WebElement facebookLink;

    public HomePage isFacebookComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pause(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(facebookLink)).click();
      //  click(facebookLink);
        return this;
    }
    public HomePage switchToFacebookTab(int index) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pause(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(facebookLink)).click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

        Set<Cookie> cookiesBefore = driver.manage().getCookies();
        for (Cookie cookie : cookiesBefore) {
            System.out.println("Before adding cookie: " + cookie.getName() + ": " + cookie.getValue());
        }

        Cookie cookie = new Cookie("datr", "NDXeZNiVURwRhdsUjf25WUCL");
        driver.manage().addCookie(cookie);

        Set<Cookie> cookiesAfter = driver.manage().getCookies();
        for (Cookie addedCookie : cookiesAfter) {
            System.out.println("After adding cookie: " + addedCookie.getName() + ": " + addedCookie.getValue());
        }

        return this;
    }
    @FindBy(xpath = "//*[@id='mount_0_0_Hh']/div/div[1]/div/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[2]")
    WebElement title;
    @FindBy(xpath = "//*[@id='mount_0_0_J+']/div/div[1]/div/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[1]/div/i")
    WebElement cross;
    public HomePage verifyNewFacebookTitle(String text) {
        click(cross);
        Assert.assertTrue(isTextPresent(title,text));
        return this;
    }

    @FindBy(xpath = "//*[@id='root']/footer/div[1]/div[1]/div[2]/a[2]")
    WebElement instagramLink;

    public HomePage isInstagramComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", instagramLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        click(instagramLink);
        return this;
    }

    @FindBy(xpath = "//*[@id='root']/footer/div[1]/div[1]/div[2]/a[3]")
    WebElement youtubeLink;

    public HomePage isYoutubeComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", youtubeLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        click(youtubeLink);
        return this;
    }

    public HomePage switchToYoutubeTab(int index) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pause(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(youtubeLink)).click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
    @FindBy(xpath = "//yt-formatted-string[text()='Hunde Sitters']")
    WebElement youtubetitle;
    public HomePage verifyNewYoutubeTitle(String text) {
        Assert.assertTrue(isTextPresent(youtubetitle,text));
        return this;
    }
    @FindBy(xpath = "//div[contains(@class, '_ftInfoItem_tqan6_36') and contains(., 'Germany, Berlin')]")
    WebElement linkMainAddress;

    public HomePage verifyMainAddress(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pause(500);
        Assert.assertTrue(isTextPresent(linkMainAddress, text));
        return this;
    }

    @FindBy(xpath = "//div[contains(@class, '_ftInfoItem_tqan6_36') and contains(., '+49 175 9587225')]")
    WebElement linkPhone;

    public HomePage verifyPhone(String text) {
        Assert.assertTrue(isTextPresent(linkPhone, text));
        return this;
    }

    @FindBy(xpath = "//div[contains(@class, '_ftInfoItem_tqan6_36') and contains(., 'Petscare@gmail.com')]")
    WebElement linkEmail;

    public HomePage verifyEmail(String text) {
        Assert.assertTrue(isTextPresent(linkEmail, text));
        return this;
    }


    @FindBy(xpath = "//a[contains(text(),'Verkauf von Hunde')]")
    WebElement linkVerkaufVonHunde;

    public HomePage verifyVerkaufVonHunde(String text) {
        Assert.assertTrue(isTextPresent(linkVerkaufVonHunde, text));
        return this;
    }

    public HomePage isVerkaufVonHundeLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkVerkaufVonHunde);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkVerkaufVonHunde);
        return this;
    }


    @FindBy(xpath = "//*[@id='root']/footer/div[1]/div[2]/div[1]//a[2]")
    WebElement linkHotelForDog;

    public HomePage verifyHotelForDogs(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(isTextPresent(linkHotelForDog, text));
        return this;
    }

    public HomePage isHotelForDogsLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkHotelForDog);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkHotelForDog);
        return this;
    }

    @FindBy(xpath = "//*[@id='root']/footer/div[1]/div[2]/div[1]/a[3]")
    WebElement linkHundeverpaarrung;

    public HomePage verifyHundeverpaarrung(String text) {
        Assert.assertTrue(isTextPresent(linkHundeverpaarrung, text));
        return this;
    }

    public HomePage isHundeverpaarrungLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkHundeverpaarrung);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkHundeverpaarrung);
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Hundesitter')]")
    WebElement linkHundesitter;

    public HomePage verifyHundesitter(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(isTextPresent(linkHundesitter, text));
        return this;
    }

    public HomePage isHundesitterLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkHundesitter);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkHundesitter);
        return this;
    }

    @FindBy(xpath = "//*[@id='root']/footer/div[1]/div[2]/div[2]/a[1]")
    WebElement linkDatenschutzbestimmungen;

    public HomePage verifyDatenschutzbestimmungen(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(isTextPresent(linkDatenschutzbestimmungen, text));
        return this;
    }

    public HomePage isDatenschutzbestimmungenLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkDatenschutzbestimmungen);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkDatenschutzbestimmungen);
        return this;
    }
    //*[@id="root"]/footer/div[1]/div[2]/div[2]/a[4]
    @FindBy(xpath = "//a[contains(text(),'Nutzungsvertrag')]")
    WebElement linkNutzungsvertrag;

    public HomePage verifyNutzungsvertrag(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(isTextPresent(linkNutzungsvertrag, text));
        return this;
    }

    public HomePage isNutzungsvertragLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkNutzungsvertrag);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkNutzungsvertrag);
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Zahlung')]")
    WebElement linkZahlung;

    public HomePage verifyZahlung(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(isTextPresent(linkZahlung, text));
        return this;
    }

    public HomePage isZahlungLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkZahlung);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkZahlung);
        return this;
    }


    @FindBy(xpath = "//a[contains(text(),'Registriren')]")
    WebElement linkRegistriren;

    public HomePage verifyRegistriren(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(isTextPresent(linkRegistriren, text));
        return this;
    }

    public HomePage isRegistrirenLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pause(500);
        click(linkRegistriren);
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Eine fragen stelen')]")
    WebElement linkEineFragenStelen;

    public HomePage verifyEineFragenStelen(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Assert.assertTrue(isTextPresent(linkEineFragenStelen, text));
        return this;
    }

    public HomePage isEineFragenStelenLinkClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linkEineFragenStelen);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkEineFragenStelen);
        return this;
    }


    @FindBy(tagName = "img")
    List<WebElement> images;

    public HomePage returnListOfImg() {
        System.out.println("The total numbers of iframes: " + images.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfImg = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total numbers of items: " + numberOfImg);
        return this;
    }


}

