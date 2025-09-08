package com.netology.tabbedapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    String pageOne = "Tab 1";
    String pageTwo = "Tab 2";

    String pageOneText = "Page: 1";
    String pageTwoText = "Page: 2";

    @Test
    public void mainActivityTest() {
        // подтверждение видимости вкладки 1 текста на ней
        ViewInteraction textView = onView(withContentDescription(pageOne));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(withText(pageOneText));
        textView2.check(matches(isDisplayed()));
        textView2.check(matches(withText(pageOneText)));

        // переход на вкладку 2
        ViewInteraction tabView = onView(withContentDescription(pageTwo));
        tabView.check(matches(isDisplayed()));
        tabView.perform(click());

        // подтверждение видимости вкладки 2 и текста на ней
        ViewInteraction textView3 = onView(withContentDescription(pageTwo));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(withText(pageTwoText));
        textView4.check(matches(isDisplayed()));
        textView4.check(matches(withText(pageTwoText)));
    }

}
