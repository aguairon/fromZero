package api.types;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String emailAddress;
    public Boolean newsletterSignup;
    public GiftOption giftOption;
    public String name;
    public String phoneNumber;
    final public List<Guest> guests = new ArrayList<>();


}
