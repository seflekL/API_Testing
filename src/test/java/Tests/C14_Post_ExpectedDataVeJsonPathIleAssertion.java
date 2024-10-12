package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {


    @Test

    public void test01() {

        /*
      14_Post_ExpectedDataVeJsonPathIleAssertion
      https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
      onderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
      OST REQUEST, RESPONSE BODY BILGILERINI
      SSERT YAPARKEN JSONPATH KULLANMA
      esponse Body

      bookingid": 24,
      booking": {
      firstname": "Ahmet",
      lastname": "Bulut",
      totalprice": 500,
      depositpaid": false,
      bookingdates": {
      checkin": "2021-06-01",
      checkout": "2021-06-10"
      ,
      additionalneeds": "wi-fi"


      request body

      firstname" : "Ahmet",
      lastname" : “Bulut",
      "totalprice" : 500,
      depositpaid" : false,
      bookingdates" : {
      checkin" : "2021-06-01",
      checkout" : "2021-06-10"
      ,
      additionalneeds" : "wi-fi"

              */


        //1- End UrLpoint/Request Body

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject reqBodyJsonObj = new JSONObject();
        JSONObject rezJsonObj = new JSONObject();

        rezJsonObj.put("checkin", "2021-06-01");
        rezJsonObj.put("checkout", "2021-06-10");

        reqBodyJsonObj.put("firstname", "Ahmet");
        reqBodyJsonObj.put("lastname", "Bulut");
        reqBodyJsonObj.put("totalprice", 500);
        reqBodyJsonObj.put("depositpaid", false);
        reqBodyJsonObj.put("bookingdates", rezJsonObj);
        reqBodyJsonObj.put("additionalneeds", "wi-fi");


//2-Expected Data olustur

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid", 24);
        expectedData.put("booking", reqBodyJsonObj);

        //3-request gonderip,donen response

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBodyJsonObj.toString())
                .post(url);

         //4-Assertion
        //ilk yazilan expected olucak ikinicisi actual
        JsonPath actualjsonPath=response.jsonPath();
                                                  //jasonbj bu sekilde                JsonPat de booking.firstname
        Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"),actualjsonPath.get("booking.firstname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("lastname"),actualjsonPath.get("booking.lastname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("totalprice"),actualjsonPath.get("booking.totalprice"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),actualjsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),actualjsonPath.get("booking.additionalneeds"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                actualjsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                actualjsonPath.get("booking.bookingdates.checkout"));




    }

}