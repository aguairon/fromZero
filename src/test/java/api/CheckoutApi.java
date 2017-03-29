package api;


import api.types.Checkout;

public class CheckoutApi extends SiteApi {
    private final String specificPath = "checkout";

    public String checkout(Checkout checkout) {
        return post(checkout, specificPath, 200);
    }
}
