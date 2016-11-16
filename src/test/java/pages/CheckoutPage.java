package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends AbstractPage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement customerDetails() {
        return findElement(".client-details");
    }

    public Boolean customerNameFieldReturnsError() {
        return customerDetails().findElement(By.cssSelector(".form-row.error")).isEnabled();
    }

    public Boolean customerEmailFieldReturnsError() {
        return customerDetails().findElement(By.cssSelector(".form-grid-2cols .form-row:nth-child(1).error")).isEnabled();
    }

    public Boolean customerPhoneFieldReturnsError() {
        return customerDetails().findElement(By.cssSelector(".form-grid-2cols .form-row:nth-child(2).error")).isEnabled();
    }

    public void setCustomerName(String customerName) {
        setField("#checkout-appointment-customer-name", customerName);
    }

    public void setCustomerEmail(String customerEmail) {
        setField("#checkout-email-address", customerEmail);
    }

    public void setCustomerPhoneNumber(String phoneNumber) {
        setField("[name='customer-phone-number']", phoneNumber);
    }

    public WebElement subscriptionCheckbox() {
        return findElement(".subscribe");
    }

    public Boolean subscriptionCheckboxIsChecked() {
        return subscriptionCheckbox().findElement(By.cssSelector(".checked")).isEnabled();
    }

    public void deselectSubscriptionCheckbox() {
        click(subscriptionCheckbox());
    }

    public void placeOrder() {
        click(".proceed .button");
    }
}
