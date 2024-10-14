package Tests;

import TestdataKlasoru.TestDataHerokuapp;
import TestdataKlasoru.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.Assertion;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_DeSerializationMap extends BaseUrlJsonPlaceholder {

    @Test
    public void test01 (){



        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
oldugunu test ediniz
DE-SERIALIZATION ILE EXPECTED DATA TESTI
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
        //1-EndPoint ve ReqBody
        specJsonPlaceholder.pathParams("pp1","posts","pp2","70");
        Map<String,Object> requestBodyMap= TestDataJsonPlaceholder.bodyolusturMap();

        //2-ExpectedBody

        Map<String,Object>expectedDAta=TestDataJsonPlaceholder.bodyolusturMap();//ecpected/req ayni

        //3-Req Send/Save

        Response response=given()
                .spec(specJsonPlaceholder)
                .when()
                .contentType(ContentType.JSON)
                .body(requestBodyMap)
                .put("{pp1}/{pp2}");

        //4-Assertions

        Map<String,Object>responseMap=response.as(HashMap.class);

        assertEquals(expectedDAta.get("title"),responseMap.get("title"));
        assertEquals(expectedDAta.get("body"),responseMap.get("body"));
        assertEquals(expectedDAta.get("id"),responseMap.get("id"));
        assertEquals(expectedDAta.get("userId"),responseMap.get("userId"));
     }
}
