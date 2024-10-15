package Tests;

import TestdataKlasoru.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JPHPojos;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {

    /*
    C31_Put_PojoClass
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
oldugunu test ediniz
content type "application/json; charset=utf-8"
Connection header degerinin "keep-alive"
POJO CLASS ILE EXPECTED DATA TESTI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
     */

    @Test
    public void test01() {

        //1-Endpoint-ReqBody

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "70");


        JPHPojos requestBodyPojo = new JPHPojos("Ahmet", "Merhaba", 10, 70);
//2- ExpectedData

        JPHPojos expectedDataPojo = new JPHPojos("Ahmet", "Merhaba", 10, 70);

//3-Response Create/Send/Save

        Response response = given()
                .spec(specJsonPlaceholder)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyPojo)
                .put("{pp1}/{pp2}");
        //Response  pojo cevirdik
        JPHPojos responsePojo = response.as(JPHPojos.class);
        System.out.println(expectedDataPojo);
        System.out.println(responsePojo);
//4-Assertion Response-===>Pojo

        //Status code TestData dan
        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode, response.statusCode());

        //ConnectionType header degerinin "kep-alive" testi

      //  assertEquals(TestDataJsonPlaceholder.headerconnection, response.header("Cnnection"));

        //response body'sinin asagida verilen ile ayni oldugunu test ediniz

        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());
    }
}
