package th.ac.buapit.buaproid.Activities;


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

            ViewInteraction bottomBarTab = onView(
                    allOf(withId(R.id.buttom_nav_item_class),
                            withParent(allOf(withId(R.id.bb_bottom_bar_item_container),
                                    withParent(withId(R.id.bb_bottom_bar_outer_container)))),
                            isDisplayed()));
            bottomBarTab.perform(click());

            ViewInteraction bottomBarTab2 = onView(
                    allOf(withId(R.id.buttom_nav_item_calendar),
                            withParent(allOf(withId(R.id.bb_bottom_bar_item_container),
                                    withParent(withId(R.id.bb_bottom_bar_outer_container)))),
                            isDisplayed()));
            bottomBarTab2.perform(click());

            ViewInteraction bottomBarTab3 = onView(
                    allOf(withId(R.id.buttom_nav_item_fav),
                            withParent(allOf(withId(R.id.bb_bottom_bar_item_container),
                                    withParent(withId(R.id.bb_bottom_bar_outer_container)))),
                            isDisplayed()));
            bottomBarTab3.perform(click());

            ViewInteraction bottomBarTab4 = onView(
                    allOf(withId(R.id.buttom_nav_item_plus),
                            withParent(allOf(withId(R.id.bb_bottom_bar_item_container),
                                    withParent(withId(R.id.bb_bottom_bar_outer_container)))),
                            isDisplayed()));
            bottomBarTab4.perform(click());

            ViewInteraction bottomBarTab0 = onView(
                    allOf(withId(R.id.buttom_nav_item_home),
                            withParent(allOf(withId(R.id.bb_bottom_bar_item_container),
                                    withParent(withId(R.id.bb_bottom_bar_outer_container)))),
                            isDisplayed()));
            bottomBarTab0.perform(click());


    }

}
