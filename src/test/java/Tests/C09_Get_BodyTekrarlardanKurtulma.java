package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyTekrarlardanKurtulma {

    @Test
    public void test01() {

        /*
     tests.C09_Get_BodyTekrarlardanKurtulma
     https://restful-booker.herokuapp.com/booking/10 url’ine bir
      GET request gonderdigimizde
     donen Response’un,
     status code’unun 200,
     ve content type’inin application-json,
     ve response body’sindeki
     "firstname“in, "Susan",
     ve "lastname“in, "Jackson",
     ve "totalprice“in, 1000 den kucuk oldugu,
     ve "depositpaid“in, false,
     ve "additionalneeds“in, BosBirakilmadigini
     oldugunu test edin
         */

        //1-End request ve body olusumu (body bu soru icin gercerli degil Only post,patch,put)

        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Body icin uygun asama yoq bu soruda

        //3-Repsonse  gonder ve kaydet

        Response response= given().when().get(url);

        //4-Assertions
        response.prettyPrint();
        //        //ikinci yontem ile yaptigimizda bu testimizdeki yazilanar degismessin diye yorum
        // response.then().assertThat()
        //         .statusCode(200)
        //         .contentType(ContentType.JSON)
        //         .body("firstname", Matchers.equalTo("Eric"))
        //         .body("lastname",Matchers.equalTo("Wilson"))
        //         .body("totalprice",Matchers.lessThan(1000))
        //         .body("depositpaid",Matchers.equalTo(false))
        //         .body("additionalneeds",Matchers.notNullValue());
//2.yol
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Jim"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(false),
                        "additionalneeds",nullValue()
                );

        //bigler update olabilir pretyy ile check  et

    }
}
