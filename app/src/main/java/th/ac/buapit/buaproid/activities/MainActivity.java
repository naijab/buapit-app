package th.ac.buapit.buaproid.activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import th.ac.buapit.buaproid.activities.fragment.MoreFragment;
import th.ac.buapit.buaproid.activities.fragment.CalendarFragment;
import th.ac.buapit.buaproid.activities.fragment.FavFragment;
import th.ac.buapit.buaproid.activities.fragment.NewsFragment;
import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.adapter.viewpager.ViewPagerAll;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    final String TAG = getClass().getName();
    Realm mRealm;
    ViewPager mViewPager;
    Toolbar mToolbar;
    TabLayout mTabLayout;

    private int[] mTabIcons = {
            R.drawable.ic_tab_home_selector,
            R.drawable.ic_tab_calendar_selector,
            R.drawable.ic_tab_fav_selector,
            R.drawable.ic_tab_more_selector
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRealm = Realm.getDefaultInstance();

        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(mToolbar);

        mViewPager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.activity_main_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {
        mTabLayout.getTabAt(0).setIcon(mTabIcons[0]);
        mTabLayout.getTabAt(1).setIcon(mTabIcons[1]);
        mTabLayout.getTabAt(2).setIcon(mTabIcons[2]);
        mTabLayout.getTabAt(3).setIcon(mTabIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAll adapter = new ViewPagerAll(getSupportFragmentManager());
        adapter.addFragment(new NewsFragment(), getString(R.string.menu_bottom_nav_title_home));
        adapter.addFragment(new CalendarFragment(), getString(R.string.menu_bottom_nav_title_calendar));
        adapter.addFragment(new FavFragment(), getString(R.string.menu_bottom_nav_title_fav));
        adapter.addFragment(new MoreFragment(), getString(R.string.menu_bottom_nav_title_plus));
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        try {
            super.onDestroy();
        } catch (NullPointerException npe) {
            Log.e(TAG, "NPE: Bug workaround");
        }

        mRealm.close();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
