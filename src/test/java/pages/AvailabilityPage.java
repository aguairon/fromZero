package pages;

import org.openqa.selenium.WebDriver;

public class AvailabilityPage extends AbstractPage {
    public AvailabilityPage(WebDriver driver) {
        super(driver);
    }

    public boolean dateIsSelected(String date) {
        return findElement(".day-selection [data-date='"+date+"']").getAttribute("class").contains("on");
    }
}
