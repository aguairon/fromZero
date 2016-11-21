package tests.search.checkout;


import factories.SiteCustomerFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
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
    public void customerDetailsNeedToBeFilledIn() {
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.customerNameFieldReturnsError());
        Assert.assertTrue(checkoutPage.customerEmailFieldReturnsError());
        Assert.assertTrue(checkoutPage.customerPhoneFieldReturnsError());
    }

    @Test
    public void cannotUseInvalidEmail() {
        checkoutPage.setCustomerEmail("email");
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.customerEmailFieldReturnsError());
    }

    @Test
    public void cannotUseInvalidPhoneNumber() {
        checkoutPage.setCustomerPhoneNumber("66666");
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.customerPhoneFieldReturnsError());
    }

    @Test (expected = NoSuchElementException.class)
    public void clientDetailsAcceptValidInformation() {
        checkoutPage.setCustomerName(siteCustomer.fullName);
        checkoutPage.setCustomerEmail(siteCustomer.emailAddress);
        checkoutPage.setCustomerPhoneNumber(siteCustomer.phoneNumber);
        checkoutPage.placeOrder();
        Assert.assertFalse(checkoutPage.customerNameFieldReturnsError());
        Assert.assertFalse(checkoutPage.customerEmailFieldReturnsError());
        Assert.assertFalse(checkoutPage.customerPhoneFieldReturnsError());
    }

    @Test
    public void subscriptionIsCheckedByDefault() {
        Assert.assertTrue(checkoutPage.subscriptionCheckboxIsChecked());
    }

    @Test(expected = NoSuchElementException.class)
    public void ableToDeselectSubscriptionOption() {
        checkoutPage.deselectSubscriptionCheckbox();
        Assert.assertFalse(checkoutPage.subscriptionCheckboxIsChecked());
    }

    @Test
    public void giftOptionIsTurnedOff() {
        Assert.assertTrue(checkoutPage.giftOptionIsTurnedOff());
    }

    @Test
    public void ableToSetAnotherClient() {
        checkoutPage.turnOnGiftOption();
        checkoutPage.setGiftRecipientName(siteCustomer.giftRecipientName);
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
