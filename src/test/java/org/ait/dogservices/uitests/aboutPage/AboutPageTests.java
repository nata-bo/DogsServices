package org.ait.dogservices.uitests.aboutPage;

import org.ait.dogservices.ui.pages.HomePage;
import org.ait.dogservices.ui.pages.about.AboutPage;
import org.ait.dogservices.uitests.TestBaseUi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutPageTests extends TestBaseUi {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAbout();
    }

    @Test
    public void isAboutComponentPresentTest() {
        new AboutPage(driver).verifyAboutElement("Find");
    }
}
