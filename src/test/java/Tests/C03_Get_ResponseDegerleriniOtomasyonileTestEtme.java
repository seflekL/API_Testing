package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonileTestEtme {

    @Test
    public void test01() {

        /*
C03_Get_ResponseBilgileriAssertion
https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
gonderdigimizde donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin Cowboy,
ve status Line’in HTTP/1.1 200 OK test ediniz
         */

        //1-End Point Request Body olustur
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Expected body olustur

        //3-Request gonderip donen response kaydet
        Response response= given().when().get(url);

        //4-Assertions
        response
                .then()
                .assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }
}
