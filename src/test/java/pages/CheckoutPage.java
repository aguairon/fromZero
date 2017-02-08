package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends AbstractPage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement customerDetails() {
        return findElement(".client-details");
    }

    public Boolean customerNameFieldHasError() {
        return customerDetails().findElement(By.cssSelector(".form-row.error")).isEnabled();
    }

    public Boolean customerEmailFieldHasError() {
        return customerDetails().findElement(By.cssSelector(".form-grid-2cols .form-row:nth-child(1).error")).isEnabled();
    }

    public Boolean customerPhoneFieldHasError() {
        return customerDetails().findElement(By.cssSelector(".form-grid-2cols .form-row:nth-child(2).error")).isEnabled();
    }

    public void setCustomerName(String customerName) {
        setField("#checkoutItem-appointment-customer-name", customerName);
    }

    public void setCustomerEmail(String customerEmail) {
        setField("#checkoutItem-email-address", customerEmail);
    }

    public void setCustomerPhoneNumber(String phoneNumber) {
        setField("[name='customer-phone-number']", phoneNumber);
    }

    public WebElement subscriptionCheckbox() {
        return findElement(".subscribe");
    }

    public Boolean isSubscriptionCheckboxChecked() {
        try {
            return subscriptionCheckbox().findElement(By.cssSelector(".checked")).isEnabled();
        } catch (NoSuchElementException _) {
            return false;
        }
    }

    public void deselectSubscriptionCheckbox() {
        click(subscriptionCheckbox());
    }

    public Boolean isGiftOptionTurnedOff() {
        return findElement(".gifts .inline-inputs .radio:nth-child(1)").findElement(By.cssSelector(".checked")).isEnabled();
    }

    public void turnOnGiftOption() {
        click(".gifts .inline-inputs .radio:nth-child(2) label");
    }

    public void setGiftRecipientName(String giftRecipientName) {
        setField(".gifts .gift .name-field", giftRecipientName);
    }

    public WebElement prepayMethodRadioButton() {
        return findElement(".b-payment-methods .pre-pay");
    }

    public Boolean prepayMethodsIsSelectedByDefault() {
        return prepayMethodRadioButton().findElement(By.cssSelector(".checked")).isEnabled();
    }

    public void selectPrepayCardMethod() {
        if (!prepayMethodsIsSelectedByDefault()) {
            click(prepayMethodRadioButton());
        }
    }

    public WebElement newCardDetails() {
        return findElement(".new-card");
    }

    public WebElement newCardNumberField() {
        return findElement(".new-card .grid-line:nth-child(3) .form-row:nth-child(1)");
    }

    public void setNewCardNumber(String newCardNumber) {
        setField(newCardNumberField().findElement(By.cssSelector("input")), newCardNumber);
    }

    public Boolean cardNumberFieldReturnsError() {
        return newCardNumberField().getAttribute("class").contains("error");
    }

    public WebElement securityCodeField() {
        return newCardDetails().findElement(By.cssSelector(".grid-line:nth-child(3) .form-row:nth-child(2)"));
    }

    public void setSecurityCode(String securityCode) {
        setField(securityCodeField().findElement(By.cssSelector("input")), securityCode);
    }

    public Boolean cardSecurityCodeFieldReturnsError() {
        return securityCodeField().getAttribute("class").contains(".error");
    }

    public Boolean cardholdersNameFieldReturnsError() {
        return newCardDetails().findElement(By.cssSelector(".grid-line:nth-child(4) .form-row:nth-child(1).error")).isEnabled();
    }

    public Boolean cardExpiryDateFieldReturnsError() {
        return newCardDetails().findElement(By.cssSelector(".grid-line:nth-child(4) .form-row:nth-child(2).error")).isEnabled();
    }

    public void placeOrder() {
        click(".proceed .button");
    }
}
