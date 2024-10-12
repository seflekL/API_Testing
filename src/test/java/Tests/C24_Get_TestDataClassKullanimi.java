package Tests;

import TestdataKlasoru.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {


    @Test
    public void test01() {


  /*  https://jsonplaceholder.typicode.com/posts/40 url'ine bir GET request yolladigimizda donen
    response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
    ediniz
    Response body :
    {
        "userId": 4,
            "id": 40,
            "title": "enim quo cumque",
            "body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis
ipsum rem optio mollitia quas
voluptatem eum voluptas qui
unde omnis voluptatem iure quasi maxime voluptas nam"
    }
         */

        //1-Endpoint/Reqquest

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "40");


        //2-Expeceddata
        JSONObject expetectedData = TestDataJsonPlaceholder.responseJsonBodyOlustur(4, 40, "enim quo cumque", "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");



        //3-Request send/save

        Response response = given().spec(specJsonPlaceholder).when().get("{pp1}/{pp2}");


        //4- Assertions
        JsonPath responseJsonpath = response.jsonPath();
        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode, response.statusCode());
        Assert.assertEquals(expetectedData.getInt("userId"), responseJsonpath.getInt("userId"));
        Assert.assertEquals(expetectedData.getInt("id"), responseJsonpath.getInt("id"));
        Assert.assertEquals(expetectedData.getString("title"), responseJsonpath.getString("title"));
        Assert.assertEquals(expetectedData.get("body"), responseJsonpath.getString("body"));

    }
}
