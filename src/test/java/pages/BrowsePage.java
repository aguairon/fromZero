package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowsePage extends AbstractPage {
    public BrowsePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPageType() {
        return findElement(".browse");
    }

    public String getTitle() {
        return findElement("h1").getText();
    }

    public void toggleDiscountFilter() {
        click(".off-peak-discount-filter .checkbox");
        waitUntilResultsReturn();
        pause(100);
    }

    public WebElement cookieBanner() {
        return  findElement("#cookie-policy .close");
    }

    public void closeCookieBanner() {
        if (cookieBanner().isDisplayed()) {
            click("#cookie-policy .close");
        }
    }

    public void waitUntilResultsReturn() {
        waitUntilVisible(".results-item");
    }

    public List<WebElement> venueResultsDiscountTooltips() {
        pause(100);
        return findElements(".results-item .discount-types");
    }

    public List<WebElement> offerResultsDiscountPrice() {
        return findElements(".service .price .discount");
    }

    public void openDateAvailabilityDropdown() {
        click(".date-filter");
    }

    public void selectAnyDayAvailability() {
        openDateAvailabilityDropdown();
        click(".datepicker-actions .secondary-action:nth-child(2)");
        pause(50);
        waitUntilResultsReturn();
    }

    public void selectNextSevenDaysAvailability() {
        openDateAvailabilityDropdown();
        click(".datepicker-actions .secondary-action:nth-child(3)");
        pause(50);
        waitUntilResultsReturn();
    }

    public void selectTodaysAvailability() {
        openDateAvailabilityDropdown();
        click(".ui-datepicker-today");
        pause(50);
        waitUntilResultsReturn();
    }

    public WebElement bookableOfferTypeFilter() {
        return findElement(".bookable");
    }

    public Boolean bookableOfferTypeFilterIsSelected() {
        if (bookableOfferTypeFilter().getAttribute("class").contains("on")) {
            return true;
        }
        return false;
    }

    public void selectBookableOfferType() {
        click(bookableOfferTypeFilter());
        waitUntilResultsReturn();
    }

    public WebElement evoucherOfferTypeFilter() {
        return  findElement(".evoucher");
    }

    public Boolean evoucherOfferTypeIsSelected() {
        if (evoucherOfferTypeFilter().getAttribute("class").contains("on")) {
            return true;
        }
        return false;
    }

    public void selectEvoucherOfferType() {
        click(evoucherOfferTypeFilter());
        pause(200);
        waitUntilResultsReturn();
    }

    public WebElement allBookingTypesFilter() {
        return findElement(".b-offer-booking-type .choices li:nth-child(3)");
    }

    public void selectAllBookingTypes() {
        click(allBookingTypesFilter());
        pause(200);
        waitUntilResultsReturn();
    }

    public OfferForm selectFirstAvailableOffer() {
        pause(1500);
        click(".results-list li:nth-child(1) .offers .service:nth-child(1)");
        return new OfferForm(getDriver());
    }

    public WebElement timeAvailabilityDropdown() {
        return findElement(".time-filter");
    }

    public WebElement timeAvailabilityDropdownIsDisabled() {
        return timeAvailabilityDropdown().findElement(By.cssSelector(".ui-selectmenu-disabled"));
    }

    public void openTimeAvailabilityDropdown() {
        pause(50);
        click(timeAvailabilityDropdown());
        pause(500);
    }

    public void selectMorningAvailability() {
        click(timeAvailabilityDropdown().findElement(By.cssSelector(".dropdown-menu li:nth-child(2) a")));
        waitUntilResultsReturn();
    }

    public WebElement locationField() {
        return findElement(".location-filter input");
    }

    public void focusLocationField(){
        click(locationField());
    }

    public void focusWidenSearchArea() {
        click(".location-radius a");
        pause(500);
    }

    public void selectOneMileRadiusExpansion() {
        click(".location-radius .ui-selectmenu-menu li:nth-child(2) a");
        waitUntilResultsReturn();
        pause(200);
    }

    public WebElement firstSublocation() {
        return findElement(".b-sub-locations .choices li:nth-child(1) a");
    }

    public String selectFirstSublocation() {
        click(firstSublocation());
        waitUntilResultsReturn();
        pause(1000);
        return firstSublocation().getText().replaceAll("[^a-zA-Z]", " ").trim();
    }

    public WebElement firstSublocationOnPage() {
        return findElement(".refine-location a:nth-child(3)");
    }

    public String selectFirstSublocationOnPage() {
        String location = firstSublocationOnPage().getText();
        click(firstSublocationOnPage());
        waitUntilResultsReturn();
        pause(300);
        return location;

    }

    public void setLocation(String location) {
        setField(locationField(), location);
        pause(500);
        setField(locationField(), Keys.RETURN);
        waitUntilResultsReturn();
        pause(300);
    }

    public void clickTitleSection() {
        click(".b-location .group-title");
        waitUntilResultsReturn();
        pause(1000);
    }

    public void deleteLocation() {
        click(".location-filter .site-delete-small");
    }

    public WebElement firstPopularLocation() {
        return findElement(".location-filter .search-results li:nth-child(2) a");
    }

    public String selectFirstPopularLocation() {
        pause(50);
        focusLocationField();
        String location =  firstPopularLocation().getText();
        click(firstPopularLocation());
        waitUntilResultsReturn();
        pause(300);
        return location;
    }

    public Boolean checkVenueLocations(String location) {
        pause(1500);
        for (WebElement element: findElements(".location-wrapper-control .place")) {
            return element.getText().contains(location);
        }
        return false;
    }

    public WebElement firstTreatmentType() {
        return findElement(".b-treatment-type .choices:nth-child(2) li:nth-child(2) .radio");
    }


    public WebElement treatmentFilterSection() {
        return findElement(".b-treatment");
    }

    public String selectFirstTreatmentType() {
        String treatmentType = firstTreatmentType().getText().replaceAll("[^a-zA-Z]", " ").trim();
        click(firstTreatmentType());
        waitUntilResultsReturn();
        return treatmentType;
    }

    public void selectAllTreatmentsTypes() {
        click(".b-treatment-type .choices:nth-child(2) li:nth-child(1) .radio");
        waitUntilResultsReturn();
    }

    public List<WebElement> browseResults() {
        return findElements(".results-list .results-item");
    }

    public WebElement browseResultsHaveVenueSummary() {
        WebElement e = getBrowseElements(".venue-summary");
        if (e != null) return e;
        return null;
    }

    public WebElement browseResultsHaveOffers() {
        WebElement e = getBrowseElements(".offers");
        if (e != null) return e;
        return null;
    }

    public List<WebElement> browseResultsVenueSummaries() {
        return findElements(".results-list .results-item .venue-summary");
    }

    public WebElement venueSummariesHaveVenueTitle() {
        WebElement e = getVenueSummariesElements("[data-track-event-property='venue_title']");
        if (e != null) return e;
        return null;
    }

    public WebElement venueSummariesHaveVenueLocation() {
        WebElement e = getVenueSummariesElements(".location");
        if (e != null) return e;
        return null;
    }

    public WebElement venueSummariesHaveVenueRating() {
        WebElement e = getVenueSummariesElements(".rating");
        if (e != null) return e;
        return null;
    }

    public WebElement venueSummariesHaveVenueDescription() {
        WebElement e = getVenueSummariesElements(".description ");
        if (e != null) return e;
        return null;
    }

    private WebElement getBrowseElements(String css) {
        for (WebElement e : browseResults()) {
            return e.findElement(By.cssSelector(css));
        }
        return null;
    }

    private WebElement getVenueSummariesElements(String css) {
        for (WebElement e : browseResultsVenueSummaries()) {
            return e.findElement(By.cssSelector(css));
        }
        return null;
    }

    public WebElement firstBrowseResultVenue() {
        return browseResults().get(0).findElement(By.cssSelector("[data-track-event-property='venue_title']"));
    }

    public String firstBrowseResultVenueName() {
        pause(100);
        return firstBrowseResultVenue().getText().toLowerCase().replaceAll(" ", "-");
    }

    public VenuePage openFirstBrowseResultVenuePage() {
        click(firstBrowseResultVenue());
        pause(500);
        return new VenuePage(getDriver());
    }

    public WebElement firstBrowseResultOffer() {
        return browseResults().get(0).findElement(By.cssSelector(".service"));
    }

    public String firstOfferTitle() {
        return  firstBrowseResultOffer().findElement(By.cssSelector(".name")).getText();
    }

    public String firstOfferDuration() {
        return firstBrowseResultOffer().findElement(By.cssSelector(".global-duration")).getText();
    }

    public WebElement firstOfferPrice() {
        return firstBrowseResultOffer().findElement(By.cssSelector(".button .price"));
    }

    public Boolean firstOfferHasPriceRange() {
        return firstOfferPrice().getCssValue("class").contains(".range");
    }

    public String firstOfferPriceValue() {
        return firstOfferPrice().findElement(By.cssSelector(".price-currency")).getText() + firstOfferPrice().findElement(By.cssSelector(".price-integer")).getText();
    }

    private WebElement getOfferElements(String css) {
        for (WebElement e : findElements(".services")) {
            return e.findElement(By.cssSelector(css));
        }
        return null;
    }

    public WebElement offersHaveTitles(){
        WebElement e = getOfferElements(".name");
        if (e != null) return e;
        return null;
    }

    public WebElement offersHaveDurations() {
        WebElement e = getOfferElements(".global-duration");
        if (e != null) return e;
        return null;
    }

    public WebElement offersHavePrices() {
        WebElement e = getOfferElements("[data-track-event-property='service_price']");
        if (e != null) return e;
        return null;
    }

    public OfferForm openFirstBrowseResultOffer() {
        click(firstBrowseResultOffer());
        return new OfferForm(getDriver());
    }
}
