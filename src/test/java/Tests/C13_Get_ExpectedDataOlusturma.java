package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {

    @Test
    public void test01(){
/*
tests.C13_Get_ExpectedDataOlusturma
https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
um mollitia molestiae aut atque rem suscipitnam impedit esse"
}
 */
        //1-EndPoint ve Request Body

        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2-ExpectedData Olusturma

        JSONObject expectedData= new JSONObject();

        expectedData.put( "userId", 3);
        expectedData.put( "id", 22);
        expectedData.put( "title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put( "body", "eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");


        //3-Request gonder Donen Response Kaydet

        Response response= given().when().get(url);

        //4-Assertion

      //  response.then().assertThat()
      //          .body("userId", equalTo(3))
      //          .body("id",equalTo(22))
      //          .body("title",equalTo("dolor sint quo a velit explicabo quia nam"));

        //UsefulWay

        JsonPath responseJsonPath=response.jsonPath();

        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
    }
}
