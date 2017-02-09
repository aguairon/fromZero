package api.types;


import java.util.List;

public class Offer {
    public Fulfillment fulfillment;
    public String date;
    public String time;
    public Integer offerId;
    public OfferType offerType;
    public Integer quantity;
    public List<Sku> skus;
    public Integer venueId;
    public List<Recipient> recipients;
}
