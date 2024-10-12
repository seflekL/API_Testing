package TestdataKlasoru;

import org.json.JSONObject;

public class TestDataJsonPlaceholder {

    public static int basariliSorguStatusCode = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String headerconnection = "keep-alive";


    public static JSONObject responseBodyOlurturid22() {
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita ear\n" +
                "um mollitia molestiae aut atque rem suscipit\\nnam impedit esse");
        return expectedData;
    }

    public static JSONObject responseJsonBodyOlustur(int userID, int id, String title, String body) {

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", userID);
        expectedData.put("id", id);
        expectedData.put("title", title);
        expectedData.put("body", body);
        return expectedData;


    }
}
