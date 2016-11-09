package factories;

import types.SiteCustomer;

public class SiteCustomerFactory {
    public SiteCustomer build() {
        SiteCustomer siteCustomer = new SiteCustomer();
        RandomStringFactory randomStringFactory = new RandomStringFactory();
        siteCustomer.fullName = randomStringFactory.build();
        EmailAddressFactory emailAddressFactory = new EmailAddressFactory();
        siteCustomer.emailAddress = emailAddressFactory.build();
        PhoneNumberFactory phoneNumberFactory = new PhoneNumberFactory();
        siteCustomer.phoneNumber = phoneNumberFactory.build();
        siteCustomer.subscribe = true;
        return siteCustomer;
    }
}
