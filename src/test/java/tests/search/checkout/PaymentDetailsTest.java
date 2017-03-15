package tests.search.checkout;


import factories.CardFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import types.Card;

public class PaymentDetailsTest {
    private WebSite site = new WebSite();
    private CheckoutPage checkoutPage;

    @Before
    public void navigateToCheckoutPage() {
        BrowsePage browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
        OfferForm offerForm = browsePage.selectFirstAvailableOffer();
        AvailabilityPage availabilityPage = offerForm.selectSkuAndOpenAvailabilityPage();
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
        checkoutPage.setCardNumber("41111");
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

    @Test
    public void noErrorsWhenCardDetailsAreFilledIn() {
        checkoutPage.selectPrepayCardMethod();

        CardFactory cardFactory = new CardFactory();
        Card card = cardFactory.build();
        checkoutPage.setCardNumber(card.cardNumber);
        checkoutPage.setCustomerName(card.cardholderName);
        checkoutPage.setSecurityCode(card.securityCode);
        checkoutPage.setExpiryDate(card.expiryDate);
        checkoutPage.placeOrder();
        Assert.assertTrue(checkoutPage.cardNumberFieldReturnsError());
        Assert.assertTrue(checkoutPage.cardSecurityCodeFieldReturnsError());
        Assert.assertTrue(checkoutPage.cardholdersNameFieldReturnsError());
        Assert.assertTrue(checkoutPage.cardExpiryDateFieldReturnsError());
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
