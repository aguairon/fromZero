package tests.search.browse.filter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BrowsePage;
import pages.OfferForm;
import pages.WebSite;

public class BookingTypeTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
    }

    @Test
    public void ableToSelectLocalBookingType() {
        browsePage.selectBookableOfferType();
        Assert.assertTrue(browsePage.bookableOfferTypeFilterIsSelected());
        Assert.assertTrue(site.getCurrentUrl().contains("buy-as-booking"));
    }

    @Test
    public void appointmentTabSelectedOnOfferPopupWhenBookingTypeIsSelected() {
        browsePage.selectBookableOfferType();
        OfferForm offerForm = browsePage.selectFirstAvailableOffer();
        Assert.assertTrue(offerForm.appointmentBookingSectionIsSelected());
    }

    @Test
    public void ableToSelectEvoucherBookingType() {
        browsePage.selectEvoucherOfferType();
        Assert.assertTrue(browsePage.evoucherOfferTypeIsSelected());
        Assert.assertTrue(site.getCurrentUrl().contains("buy-as-voucher"));
    }

    @Test
    public void evoucherTabSelectedOnOfferPopupWhenEvoucherTypeIsSelected() {
        browsePage.selectEvoucherOfferType();
        OfferForm offerForm = browsePage.selectFirstAvailableOffer();
        Assert.assertTrue(offerForm.evoucherBookingSectionIsSelected());
    }

    @Test
    public void ableToSelectAllBookingTypes() {
        browsePage.selectAllBookingTypes();
        Assert.assertFalse(site.getCurrentUrl().contains("buy-as-voucher"));
        Assert.assertFalse(site.getCurrentUrl().contains("buy-as-booking"));
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
