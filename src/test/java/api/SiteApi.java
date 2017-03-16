package api;


import api.types.Offers;
import com.jayway.restassured.RestAssured;
import java.util.List;


public class SiteApi extends RestAssured {
    public SiteApi() {
        this("https://www.treatwell.co.uk", "api");
    }

    public SiteApi(String baseURI, String basePath) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
    }

    public String post(String body, String specificPath, int statusCode) {
         return
             given().contentType("application/json").body(body).
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
}
