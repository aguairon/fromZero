package api.types;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    final public List<Offer> offers = new ArrayList<>();
    public String startTime;
    public String date;
    public Payment payment;
    public Customer customer;
    public Delivery delivery;


}
