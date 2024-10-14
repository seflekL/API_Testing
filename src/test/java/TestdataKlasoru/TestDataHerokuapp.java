package TestdataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {

    public static JSONObject jsonReqBodyolustur (){

    JSONObject requestBody= new JSONObject();
    JSONObject bookingdatesBody=new JSONObject();

   bookingdatesBody.put("checkin","2021-06-01");
   bookingdatesBody.put("checkout","2021-06-10");

   requestBody.put("firstname","Ahmet");
   requestBody.put("lastname","Bulut");
   requestBody.put("totalprice",500);
   requestBody.put("depositpaid",false);
   requestBody.put("bookingdates",bookingdatesBody);
   requestBody.put("additionalneeds","wi-fi");

   return requestBody;

      }

      public static JSONObject jsonResponseBodyCreate(){

        JSONObject responseBody=new JSONObject();
        JSONObject bookingBody= jsonReqBodyolustur();
        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);

        return responseBody;
      }

      public static Map<String,Object> requestBodyMapOlustur(){

        Map<String,Object>requestBodymap=new HashMap<>();
       requestBodymap.put("firstname","Ahmet");
       requestBodymap.put("lastname","Bulut");
       requestBodymap.put("totalprice",500.0);
       requestBodymap.put("depositpaid",false);
       requestBodymap.put("bookingdates",bookingdatesMapOlustur());
       requestBodymap.put("additionalneeds","wi-fi");

       return requestBodymap;
      }
      public static Map<String,String>bookingdatesMapOlustur(){
        Map<String,String> bookingdatesMap=new HashMap<>();
        bookingdatesMap.put("checkin","2021-06-01");
        bookingdatesMap.put("checkout","2021-06-10");

        return bookingdatesMap;
      }
        public static Map <String,Object> resposneBodyMapOlustur(){

        Map <String,Object>responseBodyMap= new HashMap<>();

        responseBodyMap.put("bookingid",24);
        responseBodyMap.put("booking",requestBodyMapOlustur());
        return responseBodyMap;
        }

    }


