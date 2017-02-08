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
    final private WebSite site = new WebSite();
    final private SiteCustomerFactory siteCustomerFactory = new SiteCustomerFactory();
    final private SiteCustomer siteCustomer = siteCustomerFactory.build();
    private CheckoutPage checkoutPage;

    @Before
    public void navigateToBrowsePage() {
        BrowsePage browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
        OfferForm offerForm = browsePage.selectFirstAvailableOffer();
        AvailabilityPage availabilityPage = offerForm.selectSkuAndOpenAvailabilityPage();
        checkoutPage = availabilityPage.goToCheckout();
    }

    @Test
    public void customerDetailsNeedToBeFilledIn() {
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.customerNameFieldHasError());
        Assert.assertTrue(checkoutPage.customerEmailFieldHasError());
        Assert.assertTrue(checkoutPage.customerPhoneFieldHasError());
    }

    @Test
    public void cannotUseInvalidEmail() {
        checkoutPage.setCustomerEmail("email");
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.customerEmailFieldHasError());
    }

    @Test
    public void cannotUseInvalidPhoneNumber() {
        checkoutPage.setCustomerPhoneNumber("66666");
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.customerPhoneFieldHasError());
    }

    @Test (expected = NoSuchElementException.class)
    public void clientDetailsAcceptValidInformation() {
        checkoutPage.setCustomerName(siteCustomer.fullName);
        checkoutPage.setCustomerEmail(siteCustomer.emailAddress);
        checkoutPage.setCustomerPhoneNumber(siteCustomer.phoneNumber);
        checkoutPage.placeOrder();
        Assert.assertFalse(checkoutPage.customerNameFieldHasError());
        Assert.assertFalse(checkoutPage.customerEmailFieldHasError());
        Assert.assertFalse(checkoutPage.customerPhoneFieldHasError());
    }

    @Test
    public void subscriptionIsCheckedByDefault() {
        Assert.assertTrue(checkoutPage.isSubscriptionCheckboxChecked());
    }

    @Test
    public void ableToDeselectSubscriptionOption() {
        checkoutPage.deselectSubscriptionCheckbox();
        Assert.assertFalse(checkoutPage.isSubscriptionCheckboxChecked());
    }

    @Test
    public void giftOptionIsTurnedOff() {
        Assert.assertTrue(checkoutPage.isGiftOptionTurnedOff());
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
