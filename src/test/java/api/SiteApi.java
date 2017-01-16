package api;


import com.jayway.restassured.RestAssured;


public class SiteApi extends RestAssured {
    public SiteApi() {
        this("https://www.treatwell.co.uk", "api");
    }

    public SiteApi(String baseURI, String basePath) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
    }

    public String post(String body, String specificPath, int statusCode) {
         return given().contentType("application/json").body(body).
                 when().post(specificPath).
                 then().statusCode(statusCode).
                 extract().response().asString();
    }
}
