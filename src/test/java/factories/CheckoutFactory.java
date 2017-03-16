package factories;

import api.types.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CheckoutFactory {
    LocalDate currentDate = LocalDate.now();
    String usableDate = currentDate.plusDays(2).toString();
    String usableTime = "825";

    public Checkout build() {
        Checkout checkout = new Checkout();
        checkout.startTime = usableTime;
        checkout.date = usableDate;

        checkout.payment = new PaymentFactory().build();

        String customerName = new RandomStringFactory().build();
        checkout.customer = new CustomerFactory().build(customerName);
        
        checkout.delivery = new Delivery();

        Offer offer = new Offer();
        offer.fulfillment = Fulfillment.APPOINTMENT;
        offer.date = usableDate;
        offer.time = usableTime;
        offer.offerId = 1178242;
        offer.offerType = OfferType.SERVICE;
        offer.quantity = 1;
        Sku sku = new Sku();
        sku.skuId = 1317696;
        offer.skus.add(sku);
        offer.venueId = 314127;
        Recipient recipient = new Recipient();
        recipient.name = customerName;
        offer.recipients.add(recipient);
        checkout.offers.add(offer);
        return checkout;
    }
}
