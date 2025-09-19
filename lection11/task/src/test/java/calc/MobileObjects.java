package calc;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    @iOSXCUITFindBy(xpath = "btn2")
    MobileElement btn2;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    @iOSXCUITFindBy(xpath = "plus")
    MobileElement btnPlus;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    @iOSXCUITFindBy(xpath = "ravno")
    MobileElement btnRavno;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    @iOSXCUITFindBy(xpath = "result")
    MobileElement result;

    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

    }
}


/*
    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        if (driver instanceof AndroidDriver) {
            btn2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
            btnPlus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
            btnRavno = driver.findElement(By.id("com.google.android.calculator:id/eq"));
            result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        } else if (driver instanceof IOSDriver) {
            btn2 = driver.findElement(By.xpath("btn2"));
            btnPlus = driver.findElement(By.xpath("plus"));
            btnRavno = driver.findElement(By.xpath("ravno"));
            btn2 = driver.findElement(By.xpath("result"));
        }
    }
 */
