package org.example.app.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import net.thucydides.core.webdriver.DriverSource;
import org.example.app.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyAndroidDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability( "platformName", "Android");
        dc.setCapability( "platformVersion", "11");
        dc.setCapability( "automationName", "UiAutomator2");
        dc.setCapability( "appPackage", "com.google.android.youtube");
        dc.setCapability( "appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
        dc.setCapability("noReset",true);

//        String apkPath = System.getProperty("user.dir") + "/src/test/resources/apps/calculator.apk";
//        dc.setCapability("app", apkPath);
        URL url = null;

        try{
            url = new URL("http://127.0.0.1:4723/wd/hub");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        if(url != null) {
            AndroidDriver androidDriver = new AndroidDriver<>(url, dc);

            Utility.ANDROID_DRIVER = androidDriver;
            return androidDriver;
        }
        else
            return null;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}