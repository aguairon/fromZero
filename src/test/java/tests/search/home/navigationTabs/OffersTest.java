package tests.search.home.navigationTabs;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BrowsePage;
import pages.HomePage;
import pages.WebSite;

public class OffersTest {
    WebSite site = new WebSite();
    HomePage homePage;

    @Before
    public void navigateToHomepage() {
        homePage = site.navigateHome();
        homePage.openFindSpaOffersTab();
    }

    @Test
    public void searchForAllHairTreatments() {
        homePage.openHairOffersNavigationDropdown();
        BrowsePage browsePage = homePage.selectAllTreatmentsLink();
        Assert.assertTrue(browsePage.getPageType().isDisplayed());
        Assert.assertTrue(browsePage.getTitle().contains("Hairdressers and hair salons"));
    }

    @Test
    public void searchForFirstSpaSuggestion() {
        homePage.openSpaOffersNavigationDropdown();
        BrowsePage browsePage = homePage.selectFirstSuggestionLink();
        Assert.assertTrue(browsePage.getPageType().isDisplayed());
        Assert.assertTrue(browsePage.getTitle().contains("Spa"));
    }

    @Test
    public void searchForVenueType() {
        homePage.openExploreSalonsDropdown();
        homePage.openFirstVenueTypeSubmenu();
        BrowsePage browsePage = homePage.selectFirstVenueTypeSuggestion();
        Assert.assertTrue(browsePage.getPageType().isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
