package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    private final WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(String css) {
        waitUntilVisible(css);
        return getDriver().findElement(By.cssSelector(css));
    }

    protected List<WebElement> findElements(String css) {
        waitUntilVisible(css);
        return getDriver().findElements(By.cssSelector(css));
    }

    protected WebElement waitUntilVisible(String css) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }

    protected WebElement waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    protected void click(String css) {
        findElement(css).click();
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void setField(WebElement element, String copy)  {
        element.sendKeys(copy);
    }

    protected void setField(WebElement element, Keys copy)  {
        element.sendKeys(copy);
    }

    protected void pressEnter(WebElement element) {
        setField(element, Keys.RETURN);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void pause(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void setBrowserSize() {
        driver.manage().window().setSize(new Dimension(1366, 768));
    }
}
