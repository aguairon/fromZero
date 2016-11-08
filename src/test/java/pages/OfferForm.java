package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfferForm extends AbstractPage {
    public OfferForm(WebDriver driver) {
        super(driver);
    }

    public WebElement firstChoice() {
        return findElement(".offer-choice-selection .choice:nth-child(1)");
    }

    public AvailabilityPage selectSkuAndOpenAvailabilityPage() {
        if (!findElement(".offer-choice-selection").getAttribute("class").contains(".single")) {
            click(firstChoice());
        }
        click(".basket-btn");
        return new AvailabilityPage(getDriver());
    }

    public String firstChoicePrice() {
        return firstChoice().findElement(By.cssSelector(".price .sale ")).getText();
    }

    public Boolean formHasCorrectNumberChoices(Boolean range) {
        if (range && findElements(".choices .choice").size() > 1 || !range && findElements(".choices .choice").size() == 1) return true;
        return false;
    }

    public String choicesDuration() {
        if (findElements(".choices .choice").size() > 1) {
            return findElement(".choices .choice:nth-child(1) .title").getText() + " - " + findElement(".choices .choice:nth-last-child(1) .title").getText();
        }
        return findElement(".choices .choice .title").getText();
    }

    public Boolean choiceHaveDiscount() {
        return findElements(".choices .choice .with-full").size() > 0;
    }

    public Boolean appointmentBookingSectionIsSelected() {
        return bookingTabIsSelected("APPOINTMENT");
    }

    public Boolean evoucherBookingSectionIsSelected() {
        return bookingTabIsSelected("EVOUCHER");
    }

    public Boolean bookingTabIsSelected(String bookingType) {
        return findElement("[data-code='"+bookingType+"']").getAttribute("class").contains("on");
    }

    public String title() {
        return findElement(".offer-popup .offer-name").getText();
    }
}
