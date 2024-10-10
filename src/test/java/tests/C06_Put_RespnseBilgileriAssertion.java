package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;

public class C06_Put_RespnseBilgileriAssertion {

    @Test
    public void test01() {

        /*
        C06_Put_ResponseBilgileriAssertion
https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
PUT request gonderdigimizde
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
        donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin cloudflare,
        ve status Line’in HTTP/1.1 200 OK
        test edin
         */
//1-End Point ve request Body hazirla
String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqeustBody= new JSONObject();

        reqeustBody.put("title", "Konya");
        reqeustBody.put("body", "Merhaba");
        reqeustBody.put( "userId", 10);
        reqeustBody.put( "id", 70);

        //2- expectedbody olustur

        //3-Request Gonder ve donen response kaydet

        Response response  = given()
                            .contentType(ContentType.JSON)
                            .when().body(reqeustBody.toString())
                            .put(url);
        //4-Assertion
        response.then().
                assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");










    }
}
