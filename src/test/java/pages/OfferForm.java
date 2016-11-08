package pages;


import org.openqa.selenium.WebDriver;

public class OfferForm extends AbstractPage {
    public OfferForm(WebDriver driver) {
        super(driver);
    }

    public AvailabilityPage selectSkuAndOpenAvailabilityPage() {
        if (!findElement(".offer-choice-selection").getAttribute("class").contains(".single")) {
            click(".offer-choice-selection .choice:nth-child(1)");
        }
        click(".basket-btn");
        return new AvailabilityPage(getDriver());
    }

    public Boolean appointmentBookingSectionIsSelected() {
//        return findElement("[data-code='APPOINTMENT']").getAttribute("class").contains("on");
        return bookingTabIsSelected("APPOINTMENT");
    }

    public Boolean evoucherBookingSectionIsSelected() {
        return bookingTabIsSelected("EVOUCHER");
//        return findElement("[data-code='EVOUCHER']").getAttribute("class").contains("on");
    }

    public Boolean bookingTabIsSelected(String bookingType) {
        return findElement("[data-code='"+bookingType+"']").getAttribute("class").contains("on");
    }

    public String title() {
        return findElement(".offer-popup .offer-name").getText();
    }

    public String choicesDuration() {
        if (findElements(".choices .choice").size() > 1) {
            return findElement(".choices .choice:nth-child(1) .title").getText() + " - " + findElement(".choices .choice:nth-last-child(1) .title").getText();
        }
        return findElement(".choices .choice .title").getText();
    }

    public Boolean choiceHaveDiscount() {
        if (findElements(".choices .choice .with-full").size() > 0) {
            return true;
        }
        return false;
    }
}
