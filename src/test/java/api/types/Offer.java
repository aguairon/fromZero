package api.types;


import java.util.ArrayList;
import java.util.List;

public class Offer {
    public Fulfillment fulfillment;
    public String date;
    public String time;
    public Integer offerId;
    public OfferType offerType;
    public Integer quantity;
    final public List<Sku> skus = new ArrayList<>();
    public Integer venueId;
    final public List<Recipient> recipients = new ArrayList<>();
}
