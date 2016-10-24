package tests.search.home.searchTabs;


import org.junit.*;
import org.openqa.selenium.TimeoutException;
import pages.BrowsePage;
import pages.HomePage;
import pages.WebSite;

public class SpaOffersTest {
    WebSite site = new WebSite();
    HomePage homePage;
    String location = "Mitcham";

    @Before
    public void navigateToHomepage() {
        homePage = site.navigateHome();
        homePage.openFindSpaOffersTab();
        homePage.focusSpaLocationField();
    }

    @Test
    public void searchDatedOffersWithLocation() {
        homePage.setSpaLocation(location);
        homePage.selectFirstLocationSuggestion();
        submitSearchAndCheckTitle("Spa");
    }

    @Test
    public void searchDatedOffersWithSuggestedLocationFromDropdown() {
        location = homePage.getFistSpaLocationCopy();
        homePage.selectFirstLocationSuggestion();
        submitSearchAndCheckTitle("Spa");
    }

    @Test(expected = TimeoutException.class)
    public void deselectSelectedLocation()  {
        homePage.setSpaLocation(location);
        homePage.selectFirstLocationSuggestion();
        homePage.deleteSpaLocation();
        BrowsePage browsePage = homePage.submitSpaSearch();
        Assert.assertTrue(browsePage.getPageType().isDisplayed());
    }

    @Test
    public void searchSpaOffersWithLocationAndDate() {
        homePage.setSpaLocation(location);
        homePage.selectFirstLocationSuggestion();
        homePage.focusSpaDateField();
        homePage.selectTodaysDate();
        BrowsePage browsePage = submitSearchAndCheckTitle("Spa");
        Assert.assertTrue(browsePage.getTitle().contains(site.getTodayDate()));
    }

    @Test
    public void searchSpaOffersWithLocationAndDuration() {
        homePage.setSpaLocation(location);
        homePage.selectFirstLocationSuggestion();
        homePage.focusSpaDurationDropdown();
        homePage.selectSpaDayOnlyDuration();
        submitSearchAndCheckTitle("Spa days");
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }


    private BrowsePage submitSearchAndCheckTitle(String offerType) {
        BrowsePage browsePage = homePage.submitSpaSearch();
        Assert.assertTrue(browsePage.getPageType().isDisplayed());
        Assert.assertTrue(browsePage.getTitle().contains(location));
        Assert.assertTrue(browsePage.getTitle().contains(offerType));
        return browsePage;
    }


}
