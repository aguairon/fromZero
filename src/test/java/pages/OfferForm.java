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
        return bookingTabIsSeleccted("APPOINTMENT");
    }

    public Boolean evoucherBookingSectionIsSelected() {
        return bookingTabIsSeleccted("EVOUCHER");
//        return findElement("[data-code='EVOUCHER']").getAttribute("class").contains("on");
    }

    public Boolean bookingTabIsSeleccted(String bookingType) {
        return findElement("[data-code='"+bookingType+"']").getAttribute("class").contains("on");
    }
}
