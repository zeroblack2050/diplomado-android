package com.cosmo.arquitecturamvpbase.views.taller;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.cosmo.arquitecturamvpbase.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Superadmin1 on 10/10/2017.
 */

@RunWith(AndroidJUnit4.class)
public class CreateContactActivityTest {


    @Rule
    public ActivityTestRule<ContactActivity> ActivityContactA = new ActivityTestRule<>(ContactActivity.class);

    /*@Rule
    public ActivityTestRule<CreateContactActivity> ActivityCreateContact = new ActivityTestRule<>(CreateContactActivity.class);
*/

    @Test   public void EditTextNameIsCreateAndChecked() throws InterruptedException{
        Thread.sleep(1000);
        onView(withId(R.id.createContact)).perform(click());
        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_name_editex)).check(matches(isDisplayed()));

        onView(withId(R.id.contactcreate_name_editex)).perform(typeText("Jasmany"), ViewActions.closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_name_editex)).check(matches(withText("Jasmany")));

    }

    @Test   public void EditTextSurnameIsCreateAndChecked() throws InterruptedException{
        Thread.sleep(1000);
        onView(withId(R.id.createContact)).perform(click());
        Thread.sleep(1000);

        onView(withId(R.id.contactcreate_username_edittex)).check(matches(isDisplayed()));

        onView(withId(R.id.contactcreate_username_edittex)).perform(typeText("Jaramillo"), ViewActions.closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_username_edittex)).check(matches(withText("Jaramillo")));

    }

    @Test   public void EditTextNumberIsCreateAndChecked() throws InterruptedException{
        Thread.sleep(1000);
        onView(withId(R.id.createContact)).perform(click());
        Thread.sleep(1000);

        onView(withId(R.id.contactcreate_number_edittex)).check(matches(isDisplayed()));

        onView(withId(R.id.contactcreate_number_edittex)).perform(typeText("123456"), ViewActions.closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_number_edittex)).check(matches(withText("123456")));

    }

    @Test   public void EditTextTypeIsCreateAndChecked() throws InterruptedException{
        Thread.sleep(1000);
        onView(withId(R.id.createContact)).perform(click());
        Thread.sleep(1000);

        onView(withId(R.id.contactcreate_type_edittex)).check(matches(isDisplayed()));

        onView(withId(R.id.contactcreate_type_edittex)).perform(typeText("Point"), ViewActions.closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_type_edittex)).check(matches(withText("Point")));

    }

    @Test   public void EditTextAltitudIsCreateAndChecked() throws InterruptedException{
        Thread.sleep(1000);
        onView(withId(R.id.createContact)).perform(click());
        Thread.sleep(1000);

        onView(withId(R.id.contactcreate_cordinates_altitud)).check(matches(isDisplayed()));

        onView(withId(R.id.contactcreate_cordinates_altitud)).perform(typeText("1234"), ViewActions.closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_cordinates_altitud)).check(matches(withText("1234")));

    }

    @Test   public void EditTextLatitudIsCreateAndChecked() throws InterruptedException{
        Thread.sleep(1000);
        onView(withId(R.id.createContact)).perform(click());
        Thread.sleep(1000);

        onView(withId(R.id.contactcreate_cordinates_latitud)).check(matches(isDisplayed()));

        onView(withId(R.id.contactcreate_cordinates_latitud)).perform(typeText("5678"), ViewActions.closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_cordinates_latitud)).check(matches(withText("5678")));

    }

    @Test   public void EditTextButtonIsCreateAndChecked() throws InterruptedException{
        Thread.sleep(1000);
        onView(withId(R.id.createContact)).perform(click());
        Thread.sleep(1000);

        onView(withId(R.id.contactcreate_button)).check(matches(isDisplayed()));

        Thread.sleep(1000);
        onView(withId(R.id.contactcreate_button)).perform(click());

    }

}