package tests.search.checkout.api;


import api.CheckoutApi;
import api.types.Checkout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import factories.CheckoutFactory;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CheckoutSubmissionTest {
    CheckoutApi checkoutApi = new CheckoutApi();

    @Test
    public void submitCheckoutWithIncorrectAdyenCode() {
        Checkout checkout = new CheckoutFactory().build();
        String body = getGson().toJson(checkout);
        String r = checkoutApi.checkout(body);
        System.out.println(r);
        Assert.assertTrue(r.contains("error"));
        Assert.assertTrue(r.contains("PAYMENT_FAILURE"));
    }

    @Test
    public void submitCheckoutForSlotInThePast() {
        LocalDate currentDate = LocalDate.now();
        String usableDate = currentDate.minusDays(1).toString();
        Checkout checkout = new CheckoutFactory().build();
        checkout.date = usableDate;
        checkout.offers.get(0).date = usableDate;

        String body = getGson().toJson(checkout);
        String r = checkoutApi.checkout(body);
        System.out.println(r);
        Assert.assertTrue(r.contains("error"));
        Assert.assertTrue(r.contains("APPOINTMENT_SLOT_FILLED"));
    }

    private Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
    }
}
