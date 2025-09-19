package calc;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    enum Platform {Android, IOS}

    Platform platform = Platform.Android;

    private AppiumDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        if (platform == Platform.Android) {
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("appium:deviceName", "some name");
            desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
            desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            driver = new AndroidDriver(getUrl(), desiredCapabilities);
        } else if (platform == Platform.IOS) {
            desiredCapabilities.setCapability("platformName", "IOS");
            desiredCapabilities.setCapability("appium:deviceName", "iPhone 11");
            desiredCapabilities.setCapability("appium:bundleId", "com.shubham-iosdev.Calculator-UI");
            desiredCapabilities.setCapability("appium:automationName", "XCUITest");
            driver = new IOSDriver(getUrl(), desiredCapabilities);
        }

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sampleTest() {
        if (platform == Platform.Android) {
            WebElement el1 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
            el1.isDisplayed();
            el1.click();

            WebElement el2 = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
            el2.isDisplayed();
            el2.click();

            WebElement el3 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
            el3.isDisplayed();
            el3.click();

            WebElement el4 = driver.findElement(By.id("com.google.android.calculator:id/eq"));
            el4.isDisplayed();
            el4.click();

            WebElement el5 = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
            Assertions.assertEquals("4", el5.getText());
        } else if (platform == Platform.IOS) {

            WebElement el1 = driver.findElement(By.xpath("com.google.android.calculator:id/digit_2"));
            el1.isDisplayed();
            el1.click();

            WebElement el2 = driver.findElement(By.xpath("com.google.android.calculator:id/op_add"));
            el2.isDisplayed();
            el2.click();

            WebElement el3 = driver.findElement(By.xpath("com.google.android.calculator:id/digit_2"));
            el3.isDisplayed();
            el3.click();

            WebElement el4 = driver.findElement(By.xpath("com.google.android.calculator:id/eq"));
            el4.isDisplayed();
            el4.click();

            WebElement el5 = driver.findElement(By.xpath("com.google.android.calculator:id/result_final"));
            Assertions.assertEquals("4", el5.getText());
        }


    }

}
