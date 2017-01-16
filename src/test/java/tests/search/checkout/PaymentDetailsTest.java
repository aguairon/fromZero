package tests.search.checkout;


import factories.CardFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import types.Card;

public class PaymentDetailsTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;
    OfferForm offerForm;
    AvailabilityPage availabilityPage;
    CheckoutPage checkoutPage;
    CardFactory cardFactory = new CardFactory();
    Card card = cardFactory.build();

    @Before
    public void navigateToCheckoutPage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
        offerForm = browsePage.selectFirstAvailableOffer();
        availabilityPage = offerForm.selectSkuAndOpenAvailabilityPage();
        checkoutPage = availabilityPage.goToCheckout();
    }

    @Test
    public void cardDetailsNeedToBeFilledInWhenCardOptionIsSelected() {
        checkoutPage.selectPrepayCardMethod();
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.cardNumberFieldReturnsError());
        Assert.assertTrue(checkoutPage.cardSecurityCodeFieldReturnsError());
        Assert.assertTrue(checkoutPage.cardholdersNameFieldReturnsError());
        Assert.assertTrue(checkoutPage.cardExpiryDateFieldReturnsError());
    }

    @Test
    public void cannotUseInvalidNewCardNumber() {
        checkoutPage.selectPrepayCardMethod();
        checkoutPage.setNewCardNumber("41111");
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.cardNumberFieldReturnsError());
    }

    @Test
    public void cannotUseInvalidSecurityCode() {
        checkoutPage.selectPrepayCardMethod();
        checkoutPage.setSecurityCode("1111");
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.cardSecurityCodeFieldReturnsError());
    }



    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
