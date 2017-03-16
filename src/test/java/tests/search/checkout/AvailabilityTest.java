package tests.search.checkout;


import api.CheckoutAvailabilityApi;
import org.junit.Test;

public class AvailabilityTest {

    //check that the availability shown is the same returned from the api

    @Test
    public void test() {
        CheckoutAvailabilityApi checkoutAvailabilityApi = new CheckoutAvailabilityApi();
       String result =  checkoutAvailabilityApi.getAvailability();
//        System.out.println(result);
    }
}
