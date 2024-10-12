package Tests;

import baseUrl.BaseUrlHeroKuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHeroKuapp {

    @Test

    public void test01(){
        /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
yazarak “firstname” degeri “Eric” ve “Jones” degeri “susan Ericson” olan rezervasyon
oldugunu test edecek bir GET request gonderdigimizde, donen response’un status
code’unun 200 oldugunu ve “Susan Ericson” ismine sahip en az bir booking oldugunu test
edin
         */

        specHeroKuapp.pathParam("pp1","booking")
                     .queryParams("firstname","Josh","lastname","Allen");


        //3-Request send/Save
        Response response= given()
                .when()
                .spec(specHeroKuapp)
                .get("/{pp1}");
response.prettyPrint();
         //4-Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.notNullValue());
    }

    }




