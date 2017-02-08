package api.types;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    public String advisoryOrderTotal;
    public PaymentType paymentType;
    public Boolean storePaymentCard;
    public String adyenEncryptedData;
    public String adyenEncryptedGenerationTime;
    final public List<DiscountCode> discountCodes  = new ArrayList<>();
}
