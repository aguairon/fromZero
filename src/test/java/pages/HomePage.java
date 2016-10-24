package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement venueSearchResults() {
        return findElement(".search-results");
    }

    public WebElement venueSearchResultsError() {
        return venueSearchResults().findElement(By.cssSelector(".ui-autocomplete-error"));
    }

    public VenuePage selectFirstVenueFromVenueResults() {
        click(venueSearchResults().findElement(By.cssSelector(".ui-menu-item")));
        return new VenuePage(getDriver());
    }


    public WebElement venueSearchField() {
        return findElement(".search-venue input");
    }

    public void openFindSalonTab() {
        click("#search-venue-tab .link-value");
        pause(100);
    }

    public void openFindSpaOffersTab() {
        click("[data-tab-content-id='search-spa'] a");
        pause(200);
    }

    public void setVenueName(String venueName) {
        setField(venueSearchField(), venueName);
        waitUntilVisible(venueSearchResults());
    }

    public WebElement spaSearchResults() {
        return findElement(".search-results");
    }

    public WebElement firstSpaSearchResult() {
        return spaSearchResults().findElement(By.cssSelector(".ui-menu-item"));
    }

    public void selectFirstLocationSuggestion() {
        click(firstSpaSearchResult());
    }

    public String getFistSpaLocationCopy() {
        return firstSpaSearchResult().getText();
    }

    public void selectTodaysDate() {
        click(".ui-datepicker-calendar .ui-datepicker-today");
    }

    public WebElement spaLocationField() {
        return findElement("#search-spa .location input");
    }

    public void focusSpaLocationField() {
        click(spaLocationField());
    }

    public void setSpaLocation(String datedLocation) {
        setField(spaLocationField(), datedLocation);
        pause(300);
        waitUntilVisible(spaSearchResults());
    }

    public void focusSpaDateField() {
        click("#search-spa .select-date input");
    }

    public void focusSpaDurationDropdown() {
        click("#search-spa .select-duration .ui-selectmenu");
    }

    public void selectSpaDayOnlyDuration() {
        click(".ui-selectmenu-menu li:nth-child(2) a");
    }

    public VenuePage submitVenueSearchWithKeyboard() {
        pressEnter(venueSearchField());
        return new VenuePage(getDriver());
    }

    public VenuePage submitVenueSearch() {
        click("#search-venue .search");
        return new VenuePage(getDriver());
    }

    public BrowsePage submitSpaSearch() {
        click("#search-spa .search");
        return new BrowsePage(getDriver());
    }

    public void deleteSpaLocation() {
        click(findElement("#search-spa .location .site-delete"));
    }

    public void openHairOffersNavigationDropdown() {
        click("#nav [href='/hair-offers/']");
    }

    public void openSpaOffersNavigationDropdown() {
        click("#nav [href='/spa-days/']");
    }

    public void openExploreSalonsDropdown()  {
        setBrowserSize();
        click("#nav .explore-venues-trigger");
    }

    public BrowsePage selectAllTreatmentsLink() {
        click(".subnav[style='display: block;'] li:last-child a");
        return new BrowsePage(getDriver());
    }

    public BrowsePage selectFirstSuggestionLink() {
        click(".subnav[style='display: block;'] li:nth-child(1) a");
        return new BrowsePage(getDriver());
    }

    public void openFirstVenueTypeSubmenu() {
        click(".explore-venue-treatment-types li:nth-child(1) a");
    }

    public BrowsePage selectFirstVenueTypeSuggestion() {
        click(".explore-venue-treatment-types li:nth-child(1) .popover li:nth-child(1) a");
        return new BrowsePage(getDriver());
    }
}

