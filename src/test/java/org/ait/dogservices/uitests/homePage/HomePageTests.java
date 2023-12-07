package org.ait.dogservices.uitests.homePage;

import org.ait.dogservices.ui.data.UserData;
import org.ait.dogservices.ui.pages.HomePage;
import org.ait.dogservices.ui.utils.DataProviders;
import org.ait.dogservices.uitests.TestBaseUi;
import org.testng.annotations.Test;

public class HomePageTests extends TestBaseUi {

    @Test
    public void isHomeComponentPresentTest() {
        new HomePage(driver).isHomeComponentPresent();
    }

    @Test
    public void isRegistrationLinkPresentTest() {
        new HomePage(driver).isRegistrationLinkPresent();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationDataFormCSVFile")
    public void fillRegistrationFormUsingDataProviderPositiveTest(String firstName, String lastName,
                                                                  String username, String city, String zip,
                                                                  String email, String password,
                                                                  String repeatPassword) {
        new HomePage(driver).getRegistrationLink()
                .enterRegistrationData(firstName, lastName, username, city, zip, email, password, repeatPassword)
                .clickOnCheckBox()
                .submitInRegistrationForm()
                .verifyFinishingRegistration("Ende der Registrierung")
                .clickOk();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationDataFormCSVFile")
    public void fillRegistrationFormUsingDataProviderNegativeTest(String firstName, String lastName,
                                                                  String username, String city, String zip,
                                                                  String email, String password,
                                                                  String repeatPassword) {
        new HomePage(driver).getRegistrationLink()
                .enterRegistrationData(firstName, lastName, username, city, zip, email, password, repeatPassword)
                .clickOnCheckBox()
                .submitInRegistrationForm()
                .warningWrongEmail();
    }

    @Test
    public void loginPositiveTest1() {
        new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_NAME, UserData.USER_PASSWORD)
                .submit()
                .verifyLogout("Log Out");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveLoginDataFormCSVFile")

    public void fillLoginFormUsingDataProviderTest(String username, String password) {
        new HomePage(driver).getLoginLink()
                .enterLoginData(username, password)
                .submit()
                .verifyLogout("Log Out");

    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeLoginDataFormCSVFile")

    public void fillLoginFormUsingDataProviderNegativeTest(String username, String password) {
        new HomePage(driver).getLoginLink()
                .enterLoginData(username, password)
                .submit()
                .warningWrongUserName("Incorrect username or password");
    }

    @Test
    void imgTest() {
        new HomePage(driver).returnListOfImg();
    }
}