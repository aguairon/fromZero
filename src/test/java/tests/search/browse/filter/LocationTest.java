package tests.search.browse.filter;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BrowsePage;
import pages.WebSite;

public class LocationTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
    }

    @Test
    public void deleteDefaultLocation() {
        browsePage.deleteLocation();
        browsePage.clickTitleSection();
        Assert.assertTrue(site.getCurrentUrl().endsWith("/places/"));
        Assert.assertFalse(browsePage.checkVenueLocations("London"));
    }

    @Test
    public void ableToSelectFirstRecommendedLocation() {
        String location = browsePage.selectFirstPopularLocation();
        checkUrlForLocation(location);
        Assert.assertTrue(browsePage.checkVenueLocations(location));
    }

    @Test
    public void ableToSearchForLocation() {
        String location = "Mitcham";
        browsePage.focusLocationField();
        browsePage.deleteLocation();
        browsePage.setLocation(location);
        checkUrlForLocation(location);
        Assert.assertTrue(browsePage.checkVenueLocations(location));
    }

    @Test
    public void ableToWidenSearchArea() {
        browsePage.focusWidenSearchArea();
        browsePage.selectOneMileRadiusExpansion();
        Assert.assertTrue(site.getCurrentUrl().contains("within-1-miles-of"));
    }

    @Test
    public void ableToSelectSubLocations() {
        String location = browsePage.selectFirstSublocation();
        checkUrlForLocation(location);
        Assert.assertTrue(site.getCurrentUrl().contains("sub-locations"));
    }

    @Test
    public  void ableToSelectSubLocationsOnPage() {
        String location = browsePage.selectFirstSublocationOnPage();
        checkUrlForLocation(location);
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }

    private void checkUrlForLocation(String location) {
        Assert.assertTrue(site.getCurrentUrl().replaceAll("-", " ").contains(location.toLowerCase()));
    }
}
