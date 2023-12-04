package org.ait.dogservices.mobtests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestMob extends TestBaseMob{


    @Test
    public void registrationDogSitterPositiveTest(){
        String randomEmail = "test" + RandomStringUtils.randomAlphanumeric(5) + "@gmail.de";
        String randomPassword = "TestMob!!" + RandomStringUtils.randomAlphanumeric(8);

        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnRegistrationButton();
        app.getHomePageHelper().fillRegistrationForm("Olya","Brick", "Olya",
                "Bonn","23123",randomEmail,randomPassword,randomPassword);
        app.getHomePageHelper().tapCheckbox();
        app.getHomePageHelper().pause(200);
        app.getHomePageHelper().selectSizeDog(3);
        app.getHomePageHelper().tapOnRegistrationSubmit();

        Assert.assertTrue(app.getHomePageHelper().isMessagePresent());
    }
    @Test
    public void registrationDogLoverPositiveTest(){
        String randomEmail = "test" + RandomStringUtils.randomAlphanumeric(5) + "@gmail.de";
        String randomPassword = "TestMob!!" + RandomStringUtils.randomAlphanumeric(8);

        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnRegistrationButton();
        app.getHomePageHelper().fillRegistrationForm("Vika","Groy","Viki",
                "Kiel","45234",randomEmail,randomPassword,randomPassword);
        app.getHomePageHelper().pause(200);
        app.getHomePageHelper().tapOnRegistrationSubmit();

        Assert.assertTrue(app.getHomePageHelper().isMessagePresent());
    }
    @Test
    public void registrationExistedDogLoverNegativeTest(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnRegistrationButton();
        app.getHomePageHelper().fillRegistrationForm("Vika","Groy","Viki",
                "Kiel","45234","viki4@gmail.com","Viki7777!","Viki7777!");
        app.getHomePageHelper().tapOnRegistrationSubmit();

        Assert.assertTrue(app.getHomePageHelper().isErrorPresent());
    }

}
