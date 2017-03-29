package api;
import api.types.Offers;
import factories.OffersFactory;


public class CheckoutAvailabilityApi extends SiteApi {
    public String specificPath = "checkout/availability";


    public String getAvailability() {

        Offers offers = new OffersFactory().build();
        System.out.println(offers);
        return toma(specificPath, offers);

//        [{"serviceId":1657612,"fulfillment":"APPOINTMENT","skuIds":[2162586]}]
    }

}
