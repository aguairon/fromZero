package tests.search.checkout;


import api.CheckoutApi;
import api.SiteApi;
import factories.CardFactory;
import org.junit.Assert;
import org.junit.Test;
import pages.*;
import types.Card;

public class CheckoutSubmissionTest {
    WebSite site = new WebSite();
    BrowsePage browsePage;
    OfferForm offerForm;
    AvailabilityPage availabilityPage;
    CheckoutPage checkoutPage;
    CardFactory cardFactory = new CardFactory();
    Card card = cardFactory.build();
    SiteApi siteApi = new SiteApi();
    CheckoutApi checkoutApi = new CheckoutApi();


//    @Before
//    public void navigateToCheckoutPage() {
//        browsePage = site.navigateToBrowsePage();
//        browsePage.closeCookieBanner();
//        offerForm = browsePage.selectFirstAvailableOffer();
//        availabilityPage = offerForm.selectSkuAndOpenAvailabilityPage();
//        checkoutPage = availabilityPage.goToCheckout();
//    }

    @Test
    public void submitCheckout() {
        String body = "{\"offers\":[{\"fulfillment\":\"APPOINTMENT\",\"date\":\"2017-01-16\",\"time\":825,\"offerId\":1178242,\"offerType\":\"SERVICE\",\"quantity\":1,\"skus\":[{\"skuId\":1317696}],\"venueId\":314127,\"recipients\":[{\"name\":\"etwtwtwe\"}]}],\"startTime\":\"825\",\"date\":\"2017-01-16\",\"payment\":{\"advisoryOrderTotal\":\"3\",\"paymentType\":\"CARD\",\"storePaymentCard\":true,\"adyenEncryptedData\":\"adyenjs_0_1_7$dTjmY0yWf5EXWtz8WfekCZ9I4uusWFSUNfQfrYMezqGVSVW7iS0VGWQ5RnxGcTKD2b2PLuftLS+fE2wLEZeb8IRRqiX8jQiWjUsp4Q07/GKqNiUv0pj7KSEI2bLG7z39fpTpEgZ7K863WDNqW08iJiCNr5qcUH77MIqE1p08tN3blBmHZn1fhzjAsNcr/9yYcxWvZi/crgDIPQWGAGjoK+v2kyQZ67EnCbbzxWZicsZUIvAL8lSixVhvunRvgF+GoMz6s5Xjhexb4+bO1T2vcvjftAiygEIRisakpKF9mOeKfJW76+OAWCgRIL+ayl8/8p10X+o+2b7XD7faqIoAcQ==$PIi42wyJt/5xxbLqsHXSfURQx5f1iuoDxmEymqupxrkmDiuwCGyzHTQs8mKL/IrLbvaUv9fqk4ZspvnzJ7pZ26tOKTIU5pjRV3Fl95+ztJKG9j0Qn+F8WaTUt6h7ycWPfylPX00qVmJnQu6oD7JydgQic4MTGUS9dxz0KhrW0FwNeEh4b5A+UhIGNU/WUEq7MPGNEhm/1UxtAWNNanqCQmwskq95ItpCMNyC3WORWMBzzaOosEZMbJyDODyqWq4Drol55+ZlOK5d5+7gH52++26EDAtsK0f8\",\"adyenEncryptedGenerationTime\":\"2017-01-16T13:27:41.915Z\",\"discountCodes\":[]},\"customer\":{\"emailAddress\":\"video@wahanda.com\",\"newsletterSignup\":\"true\",\"gift-option\":\"yes\",\"name\":\"etwtwtwe\",\"phoneNumber\":\"02086400366\",\"guests\":[{\"name\":\"etwtwtwe\"}]},\"delivery\":{\"address\":{}}}";
        String r = checkoutApi.checkout(body);
        Assert.assertTrue(r.contains("error"));
        System.out.println(r);

    }
}
