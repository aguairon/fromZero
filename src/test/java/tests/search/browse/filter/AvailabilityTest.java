package tests.search.browse.filter;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.AvailabilityPage;
import pages.BrowsePage;
import pages.OfferForm;
import pages.WebSite;

public class AvailabilityTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
    }

    @Test
    public void selectNextSevenDays() {
        browsePage.selectNextSevenDaysAvailability();
        Assert.assertTrue(site.getCurrentUrl().contains("available-in-the-next-7-days"));
        Assert.assertTrue(browsePage.bookableOfferTypeFilterIsSelected());
    }

    @Test
    public void selectAnyDay() {
        browsePage.selectAnyDayAvailability();
        Assert.assertFalse(site.getCurrentUrl().contains("available-in-the-next-7-days"));
        Assert.assertTrue(browsePage.bookableOfferTypeFilterIsSelected());
    }

    @Test
    public void selectToday() {
        browsePage.selectTodaysAvailability();
        Assert.assertTrue(site.getCurrentUrl().contains("available-on-" + site.getTodaysDateWithDashes()));
        Assert.assertTrue(browsePage.getTitle().contains(site.getTodayDate()));
    }

    @Test
    public void todayIsAvailableForCheckout() {
        browsePage.selectTodaysAvailability();
        OfferForm offerForm = browsePage.selectFirstAvailableOffer();
        AvailabilityPage availabilityPage = offerForm.selectSkuAndOpenAvailabilityPage();
        Assert.assertTrue(availabilityPage.dateIsSelected(site.getTodayDateNumeric()));
    }

    @Test
    public void cannotSelectTimeAvailabilityIfDateAvailabilityIsNotSelected() {
        Assert.assertNotNull(browsePage.timeAvailabilityDropdownIsDisabled());
    }

    @Test
    public void selectMorningAvailability() {
        browsePage.selectNextSevenDaysAvailability();
        browsePage.openTimeAvailabilityDropdown();
        browsePage.selectMorningAvailability();
        Assert.assertTrue(site.getCurrentUrl().contains("time-range-morning"));
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
