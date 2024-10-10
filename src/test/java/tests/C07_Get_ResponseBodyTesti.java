package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_ResponseBodyTesti {


    @Test
    public void test01() {


        /*

     https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda

     donen Response’in

     status code'unun 200,

     ve content type'inin Aplication.JSON,

     ve response body'sinde bulunan userId'nin 1,

     ve response body'sinde bulunan title'in "optio dolor molestias sit"

     oldugunu test edin
         */

        //1-END POINT VE REQUEST BODY HAZIRLA

        String url="https://jsonplaceholder.typicode.com/posts/4";

        //2-Expected Data  ( bu soruda yok)

        //3- Request yollayip donen sonucu kaydet

        Response response= given().when().get(url);

        //4-Assertion

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",Matchers.equalTo(1))
                .body("title",Matchers.equalTo("eum et est occaecati"));



    }


}
