package Tests;

import TestdataKlasoru.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.Request;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test
    public void test01()  {


        /*
        C23_Get_TestDataClassKullanimi
https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
         */

    //1-Endpoint/Reqquest
        specJsonPlaceholder.pathParams("pp1","posts","pp2","22");

     //2-Expeceddata

      JSONObject expectedData= TestDataJsonPlaceholder.responseBodyOlurturid22();
        System.out.println(expectedData);
        //3-Request send/save

        Response response= given()
                .spec(specJsonPlaceholder)
                .when()
                .get("/{pp1},{pp2}");

        response.prettyPrint();

    }
}
