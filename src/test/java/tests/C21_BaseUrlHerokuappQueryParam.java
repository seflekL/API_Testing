package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import baseUrl.BaseUrlHeroKuapp;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHeroKuapp {

    @Test
    public void test01(){
    /*
    1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
yazarak “firstname” degeri “susan” olan rezervasyon oldugunu test edecek bir GET
request gonderdigimizde, donen response’un status code’unun 200 oldugunu ve “Eric”
ismine sahip en az bir booking oldugunu test edin


     */

    //1-Endpoint/Request
    specHeroKuapp.pathParam("pp1","booking")
            .queryParam("firstname","Susan");


    //2- Expected Data

    //3-Request send/Save
        Response response= given()
                          .when()
                          .spec(specHeroKuapp)
                          .get("/{pp1}");

        response.prettyPrint();
    //4-Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2));
}
}