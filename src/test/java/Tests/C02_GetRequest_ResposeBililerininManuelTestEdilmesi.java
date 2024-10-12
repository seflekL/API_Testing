package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResposeBililerininManuelTestEdilmesi {

    @Test
    public void Test01() {
        /*
 C02_Get_ApiResponseBilgileriGoruntuleme
 https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
gonderdigimizde donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin Cowboy,
ve status Line’in HTTP/1.1 200 OK
ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

        //1- Requst body ve end-point hazirlama

        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Expected data hazirlama


        //3-Request Gonder ve donen Response Kaydet

        Response response=given().when().get(url);
        System.out.println(response.prettyPrint());//body yazar
        System.out.println("status code: "+response.statusCode());
        System.out.println("Content Type: "+response.contentType());
        System.out.println("Server Header: "+response.getHeader("Server"));
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Response Suresi: "+response.getTime());



    }
}
