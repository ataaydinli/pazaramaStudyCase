package com.automated.pazarama.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static com.automated.pazarama.ExtentReports.ExtentTestManager.getTest;


public class ReusableMethods extends StepInit {
    private static final Logger LOGGER = LogManager.getLogger(ReusableMethods.class);

    public static WebElement waitVisibleByLocator(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            LOGGER.error("Web element is not visible!");
        }
        return element;
    }

    public static void waitVisibleByLocator(By element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            LOGGER.error("Web element is not visible!");
        }
    }

    public static WebElement waitClickableByOfElement(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            LOGGER.error("Web element is not clickable!");
        }
        return element;
    }

    public static void hoverElement(WebElement webElement, int second) {
        action.moveToElement(webElement).pause(Duration.ofSeconds(second)).perform();
    }

    public static String getTextFromElement(WebElement element) {
        return waitVisibleByLocator(element).getText();
    }


    public static void clickElement(WebElement webElement) {
        WebElement element = waitVisibleByLocator(webElement);
        waitClickableByOfElement(element).click();
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }


    public static void Wait(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T> void infoMessage(T message) {
        getTest().info(message.toString());
        LOGGER.info(message.toString());
    }

    public static void sendKeysAsACharacters(WebElement Element, String text) {
        for (int i = 0; i < text.length(); i++) {
            String character = String.valueOf(text.charAt(i));
            Wait(50);
            Element.sendKeys(character);
        }
    }

    public static void scrollToTop(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }
    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


}