package tests.search.browse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BrowsePage;
import pages.OfferForm;
import pages.WebSite;

public class ResultsTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
    }

    @Test
    public void browseReturnsResults() {
        Assert.assertTrue(browsePage.browseResults().size() > 0);
    }

    @Test
    public void browseResultsHaveVenueSummaryAndOffers() {
        Assert.assertTrue(browsePage.browseResultsHaveVenueSummary().isEnabled());
        Assert.assertTrue(browsePage.browseResultsHaveOffers().isEnabled());
    }

    @Test
    public void venueSummaryHaveTheCorrectElements() {
        Assert.assertTrue(browsePage.venueSummariesHaveVenueTitle().isEnabled());
        Assert.assertTrue(browsePage.venueSummariesHaveVenueLocation().isEnabled());
        Assert.assertTrue(browsePage.venueSummariesHaveVenueRating().isEnabled());
        Assert.assertTrue(browsePage.venueSummariesHaveVenueDescription().isEnabled());
    }

    @Test
    public void ableToOpenVenuePageUsingVenueName() {
        String venueName = browsePage.firstBrowseResultVenueName();
        browsePage.openFirstBrowseResultVenuePage();
        Assert.assertTrue(site.getCurrentUrl().contains(venueName));
    }

    @Test
    public void offersHaveCorrectElements() {
        Assert.assertTrue(browsePage.offersHaveTitles().isEnabled());
        Assert.assertTrue(browsePage.offersHaveDurations().isEnabled());
        Assert.assertTrue(browsePage.offersHavePrices().isEnabled());
    }

    @Test
    public void offerFormAndBrowseOfferTitleAreTheSame() {
        OfferForm offerForm = browsePage.openFirstBrowseResultOffer();
        Assert.assertTrue(browsePage.firstOfferTitle().equals(offerForm.title()));
    }

    @Test
    public void offerFormAndBrowseOfferDurationAreTheSame() {
        OfferForm offerForm = browsePage.openFirstBrowseResultOffer();
        Assert.assertTrue(browsePage.firstOfferDuration().equals(offerForm.choicesDuration()));
    }

    @Test
    public void offerFormAndBrowseOfferSavingAreTheSame() {
        Boolean discountPresent  = browsePage.offerResultsDiscountPrice().get(0).isEnabled();
        OfferForm offerForm = browsePage.openFirstBrowseResultOffer();
        Boolean choicesDiscountPresent = offerForm.choiceHaveDiscount();
        Assert.assertEquals(discountPresent, choicesDiscountPresent);
    }

    @Test
    public void offerFormAndBrowseOfferPriceAreTheSame() {
        OfferForm offerForm = browsePage.openFirstBrowseResultOffer();
        Assert.assertTrue(offerForm.formHasCorrectNumberChoices(browsePage.firstOfferHasPriceRange()));
        Assert.assertTrue(offerForm.firstChoicePrice().equals(browsePage.firstOfferPriceValue()));
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
