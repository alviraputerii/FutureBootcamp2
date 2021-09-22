package org.example.app.utils;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

@Slf4j
public class Utility extends PageObject {

    public static AndroidDriver ANDROID_DRIVER;

    public static void clickByWebElement(WebElement element, WebDriver webDriver) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", new Object[]{element});
    }

    protected void clickByWebElementFacade(WebElementFacade webElementFacade) {
        try {
            webElementFacade.click();
        } catch (Exception e) {
            System.out.println("click normal failed");
            clickByWebElement(webElementFacade, getDriver());
        }
    }

    protected void moveToXpath(WebElementFacade webElementFacade) {
        withAction().moveToElement(webElementFacade).build().perform();
    }

    protected Boolean verifyUrlIsOpened(String url) {
        System.out.println("currentUrl: " + getDriver().getCurrentUrl());
        System.out.println("expected: " + url);
        return getDriver().getCurrentUrl().contains(url);
    }

    protected String getTextByWebElementFacade(WebElementFacade webElementFacade) {
        waitFor(webElementFacade);
        return webElementFacade.getText();
    }

    protected Boolean isElementVisibleByWebElementFacade(WebElementFacade webElementFacade) {
        return webElementFacade.isVisible();
    }

    protected void typeValueByWebElementFacade(WebElementFacade webElementFacade, String value) {
        waitFor(webElementFacade);
        webElementFacade.typeAndEnter(value);
    }

    protected void typeValueWithoutEnterByWebElementFacade(WebElementFacade webElementFacade, String value) {
        waitFor(webElementFacade);
        webElementFacade.type(value);
    }

    protected void clickByXpath(String xpath) {
        WebElementFacade webElementFacade = find(By.xpath(xpath));
        webElementFacade.click();
    }

    public static AndroidDriver getAndroidDriver(){
        return (AndroidDriver) ((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver();
    }

    public static void swipe(int startX, int startY, int endX, int endY, int duration){
        log.info("Swipe (" + startX + "," + startY + "," + endX + "," + endY + "," + duration + ")");
        new TouchAction<>((PerformsTouchActions) ANDROID_DRIVER)
                .press(new PointOption().withCoordinates(startX, startY))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(duration)))
                .moveTo(new PointOption().withCoordinates(endX,endY))
                .release()
                .perform();
    }
}
