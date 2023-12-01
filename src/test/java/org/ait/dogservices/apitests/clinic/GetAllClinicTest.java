package org.ait.dogservices.apitests.clinic;

import org.ait.dogservices.api.ClinicDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllClinicTest extends TestBaseApi {

    @Test
    public void getAllClinicsSuccessTest() {
        List<ClinicDto> clinics = given()
                .when()
                .get("clinics")
                .then()
                .assertThat().statusCode(200)
                .extract().body().jsonPath().getList(".", ClinicDto.class);

        for (ClinicDto clinic : clinics) {
            System.out.println(clinic.getId() + "***" + clinic.getName());
            System.out.println("=========================================");
        }

    }


}

