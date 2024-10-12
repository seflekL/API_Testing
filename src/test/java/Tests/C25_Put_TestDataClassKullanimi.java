package Tests;

import TestdataKlasoru.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test

    public void test01() {
   /*
            https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
            olladigimizda donen response’in
            tatus kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
            egerinin “keep-alive”
            e response body’sinin asagida verilen ile ayni oldugunu test ediniz
            EST DATA CLASS KULLANIMI
            hmet BULUTLUOZ API FRAMEWORK GELISTIRME
            xpected Data :

            title": "Ahmet",
            body": "Merhaba",
            userId": 10,
            id": 70

            equest Body

            title": "Ahmet",
            body": "Merhaba",
            userId": 10,
            id": 70

    */
        //1-Endpoint/Reqquest

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 70);

        JSONObject requestBody = TestDataJsonPlaceholder.JsonBodyOlustur(10, 70, "Ahmet", "Merhaba");

        //2-Expeceddata

        JSONObject expectedJsonObj = new JSONObject();
        expectedJsonObj = TestDataJsonPlaceholder.JsonBodyOlustur(10, 70, "Ahmet", "Merhaba");

        //3-Request send/save

        Response response = given()
                .spec(specJsonPlaceholder)
                .when()
                .body(requestBody.toString())
                .contentType(ContentType.JSON)
                .put("{pp1}/{pp2}");


        //4- Assertions

        JsonPath  responseJsonPath= response.jsonPath();
        //Status code 200
        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        //content Type
        Assert.assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        //Conenction header
        Assert.assertEquals(TestDataJsonPlaceholder.headerconnection,response.header("Connection"));
        //Body
        Assert.assertEquals(expectedJsonObj.get("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedJsonObj.get("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedJsonObj.getString("body"),responseJsonPath.getString("body"));
        Assert.assertEquals(expectedJsonObj.getString("title"),responseJsonPath.getString("title"));

    }
}
