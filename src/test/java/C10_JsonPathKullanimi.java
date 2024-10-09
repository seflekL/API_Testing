import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void test01(){


        JSONObject kisibiligileriJsonObj=new JSONObject();

        JSONObject adressJsonObj= new JSONObject();
        adressJsonObj.put("streetAddress","naist street");
        adressJsonObj.put("city","nara");
        adressJsonObj.put("postalCode","630-0192");

        JSONArray telefonbileriArr=new JSONArray();

        JSONObject ceptelJsonObj=new JSONObject();

        ceptelJsonObj.put("type","iphone");
        ceptelJsonObj.put("number","0123-4567-8888");


        JSONObject evtelJsonObj=new JSONObject();

        evtelJsonObj.put("type","home");
        evtelJsonObj.put("number","0123-4567-8910");

        telefonbileriArr.put(ceptelJsonObj);
        telefonbileriArr.put(evtelJsonObj);

        kisibiligileriJsonObj.put("firstName","John");
        kisibiligileriJsonObj.put("lastName","doe");
        kisibiligileriJsonObj.put("age",26);

        kisibiligileriJsonObj.put("address",adressJsonObj);
        kisibiligileriJsonObj.put("phoneNumbers",telefonbileriArr);

        System.out.println("fistname :" + kisibiligileriJsonObj.get("firstName"));
        System.out.println("lastname"+kisibiligileriJsonObj.get("lastName"));

        System.out.println("cadde: "+kisibiligileriJsonObj.getJSONObject("address").get("streetAddress"));

        System.out.println("city : "+kisibiligileriJsonObj.getJSONObject("address").get("city"));









    }
}
