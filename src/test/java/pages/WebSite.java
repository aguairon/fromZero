package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WebSite implements AutoCloseable {
    private final WebDriver driver;
    private final String baseUrl;

    public WebSite() {
        this(new ChromeDriver(), "https://www.treatwell.co.uk/");
    }

    public WebSite(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public HomePage navigateHome() {
        driver.get(baseUrl);
        return new HomePage(driver);
    }

    public BrowsePage navigateToBrowsePage() {
        driver.get(baseUrl + "places/");
        return new BrowsePage(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTodayDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return LocalDate.now().format(formatter);
    }

    public String getTodayDateNumeric() {
        return LocalDate.now().toString();
    }

    public String getTodaysDateWithDashes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return LocalDate.now().format(formatter).toLowerCase();
    }

    public void close() throws Exception {
        driver.quit();
//        driver.close();
    }
}
