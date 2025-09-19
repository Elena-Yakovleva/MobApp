package activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Selectors {

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    MobileElement textChanged;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    MobileElement input;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    MobileElement buttonChange;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    MobileElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    MobileElement activityText;

    private AppiumDriver driver;

    public Selectors(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
