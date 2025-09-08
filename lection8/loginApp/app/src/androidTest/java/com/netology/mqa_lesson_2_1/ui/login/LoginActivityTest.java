package com.netology.mqa_lesson_2_1.ui.login;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.netology.mqa_lesson_2_1.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    String typeEmail = "test@mail.ru";
    String typePassword = "123456";
    String typeLoginResult = "Welcome !test@mail.ru";
    String typeTextButton = "Sign in or register";


    @Test
    public void loginActivityTest1() {
        ViewInteraction appCompatEditText = onView(withId(R.id.username));
        appCompatEditText.check(matches(isDisplayed()));
        appCompatEditText.perform(replaceText(typeEmail), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(withId(R.id.password));
        appCompatEditText2.check(matches(isDisplayed()));
        appCompatEditText2.perform(replaceText(typePassword), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.login));
        materialButton.check(matches(isDisplayed()));
        materialButton.check(matches(withText(typeTextButton)));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.result));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText(typeLoginResult)));
    }



}
