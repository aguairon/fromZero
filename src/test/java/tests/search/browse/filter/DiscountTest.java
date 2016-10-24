package tests.search.browse.filter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.BrowsePage;
import pages.WebSite;

public class DiscountTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;

    @Before
    public void navigateToBrowsePage() {
        browsePage = site.navigateToBrowsePage();
        browsePage.closeCookieBanner();
        browsePage.toggleDiscountFilter();
    }

    @Test
    public void selectDiscountFilter() {
        Assert.assertTrue(site.getCurrentUrl().contains("discount-dynamic"));
    }

    @Test
    public void deselectDiscountFilter() {
        browsePage.toggleDiscountFilter();
        Assert.assertFalse(site.getCurrentUrl().contains("discount-dynamic"));
    }

    @Test
    public void venuesResultsDisplayTheDiscountLogo() {
        for (WebElement element : browsePage.venueResultsDiscountTooltips()) {
            Assert.assertTrue(element.isEnabled());
        }
    }

    @Test
    public void offersResultsDisplayDiscounts() {
        for (WebElement element : browsePage.offerResultsDiscountPrice()) {
            Assert.assertTrue(element.isEnabled());
        }
    }

    @After
    public void tearDown() throws Exception {
        site.close();
    }
}
