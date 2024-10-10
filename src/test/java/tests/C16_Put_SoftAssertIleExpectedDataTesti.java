package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {

    @Test

    public void test01(){

        /*
         http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40
}
}
Response Body
{ "status": "success",
"data": {
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40 }
},
"message": "Successfully! Record has been updated."}
         */
    //1-Endpoint ve Request Body olustur

        String url=" http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBodyJsonObj= new JSONObject();

        JSONObject dataBilgileriJsonObj=new JSONObject();

        dataBilgileriJsonObj.put("name","Ahmet");
        dataBilgileriJsonObj.put("salary","Ahmet");
        dataBilgileriJsonObj.put("age","44");
        dataBilgileriJsonObj.put("id","40");

        requestBodyJsonObj.put("status","success");
        requestBodyJsonObj.put("data",dataBilgileriJsonObj);

        //3-Request Send/Save

        Response response= given().contentType(ContentType.JSON)
                           .when().body(requestBodyJsonObj.toString())
                            .put(url);
        //4-Assertion

        SoftAssert softAssert = new SoftAssert();
        JsonPath responseJsonPath= response.jsonPath();

        softAssert.assertEquals(responseJsonPath.get("status"),requestBodyJsonObj.get("status"));
        softAssert.assertEquals(responseJsonPath.get("status"),requestBodyJsonObj.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.name"),
                requestBodyJsonObj.getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.status"),
                requestBodyJsonObj.getJSONObject("data.status").get("status"));

        softAssert.assertEquals(responseJsonPath.get("data.data.name"),
                requestBodyJsonObj.getJSONObject("data").getJSONObject("data").get("name"));

        softAssert.assertEquals(responseJsonPath.get("data.data.id"),
                requestBodyJsonObj.getJSONObject("data").getJSONObject("data").get("id"));

        softAssert.assertEquals(responseJsonPath.get("data.data.age"),
                requestBodyJsonObj.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),
                requestBodyJsonObj.getJSONObject("data").getJSONObject("data").get("salary"));


        softAssert.assertAll();
    }

}
