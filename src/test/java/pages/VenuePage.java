package pages;


import org.openqa.selenium.WebDriver;

public class VenuePage extends AbstractPage {
    public VenuePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return findElement(".venue-title").getText();
    }
}
