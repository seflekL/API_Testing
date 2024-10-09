import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.AssertionSupport;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class  C11_Post_JsonPathIleBodyTesti {

    @Test

    public void test01(){

        /*

https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2023-01-10",
"checkout" : "2023-01-20"
},
"additionalneeds" : "wi-fi"
}
POST REQUEST, RESPONSE BODY BILGILERINI
ASSERT YAPARKEN JSONPATH KULLANMA
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2023-01-10
ve "checkout" tarihinin 2023-01-20
ve "additionalneeds“in,"wi-fi"
oldugunu test edin

         */

        //1-EndPoint ve RequestBody Olustur

        String url= "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody=new JSONObject();

        JSONObject rezervasyonTarihler=new JSONObject();

        rezervasyonTarihler.put("checkin","2023-01-10");
        rezervasyonTarihler.put("checkout","2023-01-20");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);

        requestBody.put("bookingdates",rezervasyonTarihler);
        requestBody.put("additionalneeds","wi-fi");

        //2- ExpectedData Olusturma

        //3-request gonder, donen response;i kaydet

        Response response= given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);

        //4-Assertion

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Ahmet"))
                .body("booking.lastname",equalTo("Bulut"))
                .body("booking.totalprice",equalTo(500))
                .body("booking.depositpaid",equalTo(false))
                .body("booking.bookingdates.checkin", equalTo("2023-01-10"))
                .body("booking.bookingdates.checkout",equalTo("2023-01-20"))
                .body("booking.additionalneeds",equalTo("wi-fi"));

    }

}
