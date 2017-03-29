package factories;


import api.types.Fulfillment;
import api.types.Offer;
import api.types.Offers;
import api.types.Sku;

import java.util.ArrayList;

public class OffersFactory {

    public Offers build() {
        Offers offers = new Offers();

        Offer offer = new Offer();
        offer.serviceId = 1657612;
        offer.fulfillment = Fulfillment.APPOINTMENT;
        ArrayList skuIds = new ArrayList();
        skuIds.add(2162586);
        Sku sku = new Sku();
        sku.skuIds = skuIds;

        System.out.println(sku);

//        offers.offers.add(offer);
        return offers;
    }
}
