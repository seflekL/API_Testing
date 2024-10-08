import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {


    @Test
    public void test01() {

/*
      https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
      gonderdigimizde
      {
      "title":"API",
      "body":"API ogrenmek ne guzel",
      "userId":10,
      }
      donen Response’un,
      status code’unun 201,
      ve content type’inin application/json
      ve Response Body'sindeki,
      "title"'in "API" oldugunu
      "userId" degerinin 100'den kucuk oldugunu
      "body" nin "API" kelimesi icerdigini
      test edin.

 */     //1-EndPoint Ve Request hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts ";


        JSONObject obj1 = new JSONObject();

        obj1.put("title", "API");
        obj1.put("body", "API ogrenmek ne guzel");
        obj1.put("userId", 10);

        //2-Expected Body Hazirlamak

        //3-Request Gonderip Donen Response kaydet

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(obj1.toString())
                .post(url);

         //4-Assertions

        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.lessThan(100))
                .body("title", Matchers.equalTo("API"))
                .body("body",Matchers.containsString("API"));


    }
}
