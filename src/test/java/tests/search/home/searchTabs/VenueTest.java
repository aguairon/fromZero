package tests.search.home.searchTabs;

import org.junit.*;
import pages.HomePage;
import pages.VenuePage;
import pages.WebSite;

public class VenueTest {
    WebSite site = new WebSite();
    HomePage homePage;

    @Before
    public void navigateToHomepage() {
        homePage = site.navigateHome();
        homePage.openFindSalonTab();
    }

    @Test
    public void searchVenueWithSearchButton() {
        homePage.setVenueName("Czaro");
        VenuePage venuePage = homePage.submitVenueSearch();
        Assert.assertTrue(venuePage.getTitle().contains("Czaro"));
    }

    @Test
    public void searchVenueWithEnter() throws Exception {
        homePage.setVenueName("Czaro");
        VenuePage venuePage = homePage.submitVenueSearchWithKeyboard();
        Assert.assertTrue(venuePage.getTitle().contains("Czaro"));
    }

    @Test
    public void selectVenueFromVenueResults() {
        homePage.setVenueName("Czaro");
        VenuePage venuePage = homePage.selectFirstVenueFromVenueResults();
        Assert.assertTrue(venuePage.getTitle().contains("Czaro"));
    }

    @Test
    public void searchForNonExistingVenue() {
        homePage.setVenueName("jjjjjj");
        Assert.assertTrue(homePage.venueSearchResultsError().isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
