package tests.search.checkout;


import api.CheckoutApi;
import api.types.Checkout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import factories.CheckoutFactory;
import org.junit.Assert;
import org.junit.Test;

public class CheckoutSubmissionTest {
    CheckoutApi checkoutApi = new CheckoutApi();

    @Test
    public void submitCheckout() {
        Checkout checkout = new CheckoutFactory().build();
        String body = getGson().toJson(checkout);
        System.out.println(body);
        //this is commented out until I have the json set up properly and then I will uncomment
//        String r = checkoutApi.checkoutItem(body);
//        Assert.assertTrue(r.contains("error"));
//        System.out.println(r);

    }

    private Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
    }
}
