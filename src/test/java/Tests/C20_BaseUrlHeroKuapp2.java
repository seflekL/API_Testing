package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import baseUrl.BaseUrlHeroKuapp;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHeroKuapp2 extends BaseUrlHeroKuapp {


    @Test

    public void test01 (){

     /*
     2- https://restful-booker.herokuapp.com/booking
endpointine yandaki body’ye sahip bir POST request
gonderdigimizde donen response’un status code’unun
200 oldugunu ve “firstname” degerinin “Ahmet”
oldugunu test edin

{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}
      */


        //1-Endpoint ve Request body olsutur
        specHeroKuapp.pathParam("pp1","booking");
        JSONObject requestBodyJsonobj= new JSONObject();
        JSONObject rezTarihleriJsonObj=new JSONObject();

        rezTarihleriJsonObj.put("checkin" , "2021-06-01");
        rezTarihleriJsonObj.put("checkout" , "2021-06-10");
        requestBodyJsonobj.put("firstname","Ahmet");
        requestBodyJsonobj.put("lastname" , "Bulut");
        requestBodyJsonobj.put("totalprice",500);
        requestBodyJsonobj.put("depositpaid",false);
        requestBodyJsonobj.put("bookingdates",rezTarihleriJsonObj);
        requestBodyJsonobj.put("additionalneeds","wi-fi");


        //2-ExpectedData


        //3-Request Send/Save

        Response responsense= given().contentType(ContentType.JSON)
                .when()
                .spec(specHeroKuapp)
                .body(requestBodyJsonobj.toString())
                .post("/{pp1}");



        //4-Assertion
        JsonPath responseJsonpath=responsense.jsonPath();

        responsense
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname",Matchers.equalTo("Ahmet"));
    }
}
