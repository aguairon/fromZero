package factories;


import api.types.Customer;
import api.types.GiftOption;
import api.types.Guest;

public class CustomerFactory {

    public Customer build(String customerName) {
        Customer customer = new Customer();
        customer.emailAddress = new EmailAddressFactory().build();
        customer.giftOption = GiftOption.yes;
        customer.name = customerName;
        customer.newsletterSignup = true;
        customer.phoneNumber = new PhoneNumberFactory().build();
        Guest guest = new Guest();
        guest.name = customerName;
        customer.guests.add(guest);
        return customer;
    }
}
