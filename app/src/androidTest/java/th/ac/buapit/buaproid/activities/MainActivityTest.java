package th.ac.buapit.buaproid.activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import th.ac.buapit.buaproid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {

            ViewInteraction recyclerView = onView(
                    allOf(withId(R.id.RecyclerViewHome),
                            withParent(withId(R.id.SwipRefreshLayoutHome)),
                            isDisplayed()));
            recyclerView.perform(actionOnItemAtPosition(0, click()));

            ViewInteraction appCompatImageButton = onView(
                    allOf(withContentDescription("นำทางขึ้น"),
                            withParent(allOf(withId(R.id.toolbar),
                                    withParent(withId(R.id.collapsingToolbarLayout)))),
                            isDisplayed()));
            appCompatImageButton.perform(click());


    }

}
