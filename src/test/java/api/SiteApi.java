package api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;


public class SiteApi extends RestAssured {
    public SiteApi() {
        this("https://www.treatwell.co.uk", "api");
    }

    public SiteApi(String baseURI, String basePath) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
    }

    public String post(Object body, String specificPath, int statusCode) {
        String bodyJson = getGson().toJson(body);
         return
             given().contentType("application/json").body(bodyJson).
             when().post(specificPath).
             then().statusCode(statusCode).
             extract().response().asString();
    }

    private Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
    }
}
