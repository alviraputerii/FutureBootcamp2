package org.example.app.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        if (System.getProperty("driver").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            FirefoxOptions opt = new FirefoxOptions();
            opt.addArguments("--private");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(opt);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}