package tests.search.browse.filter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import pages.BrowsePage;
import pages.WebSite;

public class TreatmentTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
    }

    @Test
    public void ableToSelectFirstTreatmentType() {
        String treatmentType = browsePage.selectFirstTreatmentType();
        Assert.assertTrue(browsePage.treatmentFilterSection().isDisplayed());
        Assert.assertTrue(site.getCurrentUrl().replaceAll("-", " ").contains(treatmentType.toLowerCase()));
    }

    @Test(expected = TimeoutException.class)
    public void selectAllTreatmentTypes() {
        browsePage.selectAllBookingTypes();
        Assert.assertFalse(site.getCurrentUrl().replace("-", " ").contains("treatment"));
        Assert.assertFalse(browsePage.treatmentFilterSection().isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
