package org.ait.dogservices.apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LogoutTestApi extends TestBaseApi{
    @BeforeMethod
    public void precondition(){
        String username = "nat@mail.com";
        String password = "Qwerty8888!";


        Response authResponse = RestAssured.given()
                .param("username", username)
                .param("password", password)
                .post("login");

    }
    @Test
    public void logoutTest() {
        given()
                .contentType(ContentType.URLENC)
                .post("/logout")
                .then()
                .assertThat().statusCode(200)
                .body("message", equalTo("Logout successful"));

        
    }
}
