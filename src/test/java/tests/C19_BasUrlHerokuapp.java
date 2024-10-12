package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import baseUrl.BaseUrlHeroKuapp;

import static io.restassured.RestAssured.given;

public class C19_BasUrlHerokuapp extends BaseUrlHeroKuapp {


    @Test
    public void test01() {
   /*
 Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
1- https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve Response’ta 12 booking oldugunu test
edin
    */

        //1-Endpoint ve Request body olsutur
        specHeroKuapp.pathParam("pp1","booking");

        //2-ExpectedData

        //3-Request Send/Save

        Response responsense= given()
                .when()
                .spec(specHeroKuapp)
                .get("/{pp1}");

        responsense.prettyPrint();


        //4-Assertion
        JsonPath responseJsonpath=responsense.jsonPath();
        System.out.println(responseJsonpath.getList("bookingid").size());
        responsense
                .then()
                .assertThat()
                .statusCode(200)
                 .body("bookingid", Matchers.hasSize(1200));
    }
}
