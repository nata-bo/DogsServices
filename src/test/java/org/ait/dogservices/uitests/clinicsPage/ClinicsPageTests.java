package org.ait.dogservices.uitests.clinicsPage;

import org.ait.dogservices.ui.pages.HomePage;
import org.ait.dogservices.ui.pages.clinics.ClinicsPage;
import org.ait.dogservices.uitests.TestBaseUi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClinicsPageTests extends TestBaseUi {
    @BeforeMethod
    public void precondition(){
       /* new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_NAME, UserData.USER_PASSWORD)
                .submit()
                .verifyLogout("Log Out");*/

        new HomePage(driver).getClinics();

    }

    @Test
    public void isClinicsComponentPresentTest() {
        new ClinicsPage(driver).verifyClinicsElement("Stellen Sie sicher, dass Ihr Hund nict krank ist");
    }

    @Test
    public void showClinicsListByCity(){
        new ClinicsPage(driver).selectCity("Berlin").verifyClinicsByCity("Tierarztpraxis");
    }
    @Test
    public void showClinicsList(){
        new ClinicsPage(driver).clickClinicsList().verifyClinics("Pets clinic");

    }
}
