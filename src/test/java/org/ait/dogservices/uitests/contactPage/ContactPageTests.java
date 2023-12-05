package org.ait.dogservices.uitests.contactPage;

import org.ait.dogservices.ui.pages.HomePage;
import org.ait.dogservices.ui.pages.contact.ContactPage;
import org.ait.dogservices.uitests.TestBaseUi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ait.dogservices.ui.data.UserData.*;


public class ContactPageTests extends TestBaseUi {
    @BeforeMethod
    public void precondition(){
     new HomePage(driver).getContact();
    }

    @Test
    public void isContactDataPresentTest() {
        new ContactPage(driver).isContactDataPresent("Germany, Berlin");
    }

    @Test
    public void isGoingToGoogleMapsTest() {
        new ContactPage(driver).returnListOfFrames();
    }
    @Test
    public void fillInTouchFormTest() {
        new ContactPage(driver).enterUserData(USER_NAME_FOR_CONTACT_FORM,
                USER_EMAIL_FOR_CONTACT_FORM, MESSAGE_FOR_CONTACT_FORM)
                .sendMessageButton();
    }
}
