package pages;


import org.openqa.selenium.WebDriver;

public class CheckoutPage extends AbstractPage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setCustomerName(String customerName) {
        setField("#checkout-appointment-customer-name", customerName);
    }

    public void placeOrder() {
        click(".proceed .button");
    }
}
