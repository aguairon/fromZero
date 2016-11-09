package tests.search.checkout;


import factories.SiteCustomerFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import types.SiteCustomer;

public class ClientDetailsTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;
    OfferForm offerForm;
    AvailabilityPage availabilityPage;
    CheckoutPage checkoutPage;
    SiteCustomerFactory siteCustomerFactory = new SiteCustomerFactory();
    SiteCustomer siteCustomer = siteCustomerFactory.build();

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
        offerForm = browsePage.selectFirstAvailableOffer();
        availabilityPage = offerForm.selectSkuAndOpenAvailabilityPage();
        checkoutPage = availabilityPage.goToCheckout();
    }

    @Test
    public void checkFullNameNeedsToBeFilledIn() {
        checkoutPage.setCustomerName("i");
        checkoutPage.placeOrder();
//        Assert.

    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
