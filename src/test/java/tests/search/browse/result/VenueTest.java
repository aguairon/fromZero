package tests.search.browse.result;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BrowsePage;
import pages.WebSite;

public class VenueTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
    }

//    @Test
//    public void browseReturnsResults() {
//        Assert.assertTrue(browsePage.browseResults().size() > 0);
//    }
//
//    @Test
//    public void browseResultsHaveVenueSummaryAndOffers() {
//        Assert.assertTrue(browsePage.browseResultsHaveVenueSummary().isEnabled());
//        Assert.assertTrue(browsePage.browseResultsHaveOffers().isEnabled());
//    }
//
//    @Test
//    public void venueSummaryHasTheCorrectElements() {
//        Assert.assertTrue(browsePage.venueSummariesHaveVenueTitle().isEnabled());
//        Assert.assertTrue(browsePage.venueSummariesHaveVenueLocation().isEnabled());
//        Assert.assertTrue(browsePage.venueSummariesHaveVenueRating().isEnabled());
//        Assert.assertTrue(browsePage.venueSummariesHaveVenueDescription().isEnabled());
//    }

    @Test
    public void ableToOpenVenuePageUsingVenueName() {
        String venueName = browsePage.firstBrowseResultVenueName();
        browsePage.openFirstBrowseResultVenuePage();
        Assert.assertTrue(site.getCurrentUrl().endsWith(venueName));
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
