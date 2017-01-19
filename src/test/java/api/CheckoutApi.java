package api;


public class CheckoutApi extends SiteApi {
    private final String specificPath;

    public CheckoutApi() {
        this.specificPath = "checkout";
    }

    public String checkout(String body) {
        return post(body, specificPath, 200);
    }
}
