package api;


import com.jayway.restassured.RestAssured;

import api.types.Offers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



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

    public String toma(String specificPath, Offers offers) {
        return
            given().contentType("application/json").param("proposedServices", offers).
            when().get(specificPath).
            then().extract().body().asString();
    }

//    protected ValidatableResponse httpGetWithParameter(String urlPath, String parameter) {
//        return requestBuilder().param("include", parameter)
//                .when().get(utility.siteUrl(UrlPrefix.connect) + urlPath)
//                .then();
//    }

//    protected RequestSpecification requestBuilder() {
//        return RestAssured.given().cookie(apiVenueDetails.cookies.toString());
//    }
    private Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
    }
}
