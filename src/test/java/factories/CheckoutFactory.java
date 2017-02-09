package factories;

import api.types.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CheckoutFactory {
    public Checkout build() {
        Checkout checkout = new Checkout();
        checkout.startTime = "825";
        LocalDate currentDate = LocalDate.now();
        checkout.date = currentDate.toString();

        checkout.payment = new Payment();
        checkout.payment.advisoryOrderTotal = "3";
        checkout.payment.paymentType = PaymentType.CARD;
        checkout.payment.storePaymentCard = true;
        checkout.payment.adyenEncryptedData = "adyenjs_0_1_7$dTjmY0yWf5EXWtz8WfekCZ9I4uusWFSUNfQfrYMezqGVSVW7iS0VGWQ5RnxGcTKD2b2PLuftLS+fE2wLEZeb8IRRqiX8jQiWjUsp4Q07/GKqNiUv0pj7KSEI2bLG7z39fpTpEgZ7K863WDNqW08iJiCNr5qcUH77MIqE1p08tN3blBmHZn1fhzjAsNcr/9yYcxWvZi/crgDIPQWGAGjoK+v2kyQZ67EnCbbzxWZicsZUIvAL8lSixVhvunRvgF+GoMz6s5Xjhexb4+bO1T2vcvjftAiygEIRisakpKF9mOeKfJW76+OAWCgRIL+ayl8/8p10X+o+2b7XD7faqIoAcQ==$PIi42wyJt/5xxbLqsHXSfURQx5f1iuoDxmEymqupxrkmDiuwCGyzHTQs8mKL/IrLbvaUv9fqk4ZspvnzJ7pZ26tOKTIU5pjRV3Fl95+ztJKG9j0Qn+F8WaTUt6h7ycWPfylPX00qVmJnQu6oD7JydgQic4MTGUS9dxz0KhrW0FwNeEh4b5A+UhIGNU/WUEq7MPGNEhm/1UxtAWNNanqCQmwskq95ItpCMNyC3WORWMBzzaOosEZMbJyDODyqWq4Drol55+ZlOK5d5+7gH52++26EDAtsK0f8";
        LocalDateTime time = LocalDateTime.now();
        checkout.payment.adyenEncryptedGenerationTime = time.toString();
        checkout.payment.discountCodes = new ArrayList<>();

        checkout.customer = new Customer();
        checkout.customer.emailAddress = new EmailAddressFactory().build();
        checkout.customer.giftOption = GiftOption.yes;
        String customerName = new RandomStringFactory().build();
        checkout.customer.name = customerName;
        checkout.customer.newsletterSignup = true;
        checkout.customer.phoneNumber = new PhoneNumberFactory().build();
        Guest guest = new Guest();
        guest.name = customerName;
        checkout.customer.guests = new ArrayList<>();
        checkout.customer.guests.add(guest);

        checkout.delivery = new Delivery();
        checkout.delivery.address  = null;

        checkout.offers = new ArrayList<>();
        Offer offer = new Offer();
        offer.fulfillment = Fulfillment.APPOINTMENT;
        offer.date = currentDate.toString();
        offer.time = "825";
        offer.offerId = 1178242;
        offer.offerType = OfferType.SERVICE;
        offer.quantity = 1;
        Sku sku = new Sku();
        sku.skuId = 1317696;
        offer.skus = new ArrayList<>();
        offer.skus.add(sku);
        offer.venueId = 314127;
        Recipient recipient = new Recipient();
        recipient.name = customerName;
        offer.recipients = new ArrayList<>();
        offer.recipients.add(recipient);
        checkout.offers.add(offer);
        return checkout;
    }
}
