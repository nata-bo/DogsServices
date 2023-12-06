package org.ait.dogservices.uitests.kennelsPage;

import org.ait.dogservices.ui.pages.HomePage;
import org.ait.dogservices.ui.pages.kennels.KennelsPage;
import org.ait.dogservices.uitests.TestBaseUi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KennelsPageTests extends TestBaseUi {
    @BeforeMethod
    public void precondition(){
        /*new HomePage(driver).getLoginLink();
        new HomePage(driver)
                .enterLoginData(UserData.USER_NAME, UserData.USER_PASSWORD)
                .submit()
                .verifyLogout("Log Out");*/

        new HomePage(driver).getKennels();

    }

    @Test
    public void isKennelComponentPresentTest() {
        new KennelsPage(driver).verifyKennelsElement("Swow kennels list");
    }


    @Test
    public void showKennelsListByCityTest(){
        new KennelsPage(driver).selectKennelsCity("Berlin").verifyKennelsByCity("Hunde kennel");
    }
    @Test
    public void showKennelsLisTest(){
        new KennelsPage(driver).clickKennelsList().verifyKennels("Kennel for dogs");

    }
}

