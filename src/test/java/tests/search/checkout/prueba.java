package tests.search.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by begona on 15/11/16.
 */
public class prueba {

//    public void selectServices(List<String> services) {
//        for (int i = 0; i < services.size(); i++) {
//            if (i != 0) {
//                AbstractTest.webDriver.findElement(By.cssSelector(
//                        "#react-root > div > div:nth-child(9) > div > div.ui-dialog.dialog2.react-dialog.calendar-item-editor.top > div > div > div:nth-child(5) > div:nth-child(1) > div > div.content-scroll > div.js-appointments > div:nth-child("
//                                + (i + 1)
//                                + ") > form > div.appointment--item--content.clearfix > div.appointment--content--item > div.js-offerId.is-react > div > div"))
//                        .click();
//            } else {
//                DriverUtility.click(serviceSelectMenu);
//            }
//
//            TestUtility.pause(1000); // Wait for animation
//
//            List<WebElement> elements = AbstractTest.webDriver.findElement(By.className("open"))
//                    .findElements(By.className("select-dropdown-item"));
//
//            for (WebElement element : elements) {
//                if (element.getText().toLowerCase().equals(services.get(i).toLowerCase())) {
//                    element.click();
//                }
//            }
//
//            if (i == services.size() - 1) {
//                return;
//            } else {
//                DriverUtility.click(addNextServiceButton);
//            }
//        }
//    }
//
//    public void selectServicesDos(List<String> services) {
//        if (services.size() > 1 ) {
//            for (int i = 0; i < services.size(); i++) {
//                AbstractTest.webDriver.findElement(By.cssSelector(
//                        "#react-root > div > div:nth-child(9) > div > div.ui-dialog.dialog2.react-dialog.calendar-item-editor.top > div > div > div:nth-child(5) > div:nth-child(1) > div > div.content-scroll > div.js-appointments > div:nth-child("
//                                + (i + 1)
//                                + ") > form > div.appointment--item--content.clearfix > div.appointment--content--item > div.js-offerId.is-react > div > div"))
//                        .click();
//
//                TestUtility.pause(1000); // Wait for animation
//
//
//                for (WebElement element : AbstractTest.webDriver.findElement(By.className("open")).findElements(By.className("select-dropdown-item"))) {
//                    if (element.getText().toLowerCase().equals(services.get(i).toLowerCase())) {
//                        element.click();
//                    }
//                }
//
//                if (i != services.size() - 1) {
//                    DriverUtility.click(addNextServiceButton);
//                }
//            }
//        } else {
//            DriverUtility.click(serviceSelectMenu);
//        }
//
//    }
}
