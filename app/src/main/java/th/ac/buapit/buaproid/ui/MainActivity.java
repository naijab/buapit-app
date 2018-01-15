package th.ac.buapit.buaproid.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.ui.calendar.CalendarFragment;
import th.ac.buapit.buaproid.ui.favorite.FavoriteFragment;
import th.ac.buapit.buaproid.ui.more.MoreFragment;
import th.ac.buapit.buaproid.ui.news.NewsFragment;
import th.ac.buapit.buaproid.ui.news.NewsXFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    ViewPager mViewPager;
    Toolbar mToolbar;
    TabLayout mTabLayout;

    private int[] mTabIcons = {
            R.drawable.ic_tab_home_selector,
            R.drawable.ic_tab_calendar_selector,
            R.drawable.ic_tab_calendar_selector,
            R.drawable.ic_tab_fav_selector,
            R.drawable.ic_tab_more_selector
    };

    private int[] mTabTitle = {
            R.string.menu_bottom_nav_title_home,
            R.string.menu_bottom_nav_title_newsx,
            R.string.menu_bottom_nav_title_calendar,
            R.string.menu_bottom_nav_title_fav,
            R.string.menu_bottom_nav_title_plus
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mViewPager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.activity_main_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        setupTablayout();

    }

    private void setupTablayout() {

        try {

            TextView mTitleHome = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_text_on_tablayout, null);
            mTitleHome.setCompoundDrawablesWithIntrinsicBounds(0, mTabIcons[0], 0, 0);
            mTitleHome.setText(getString(mTabTitle[0]));
            mTabLayout.getTabAt(0).setCustomView(mTitleHome);

            TextView mTitleNews = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_text_on_tablayout, null);
            mTitleNews.setCompoundDrawablesWithIntrinsicBounds(0, mTabIcons[1], 0, 0);
            mTitleNews.setText(getString(mTabTitle[1]));
            mTabLayout.getTabAt(1).setCustomView(mTitleNews);

            TextView mTitleCal = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_text_on_tablayout, null);
            mTitleCal.setCompoundDrawablesWithIntrinsicBounds(0, mTabIcons[2], 0, 0);
            mTitleCal.setText(getString(mTabTitle[2]));
            mTabLayout.getTabAt(2).setCustomView(mTitleCal);

            TextView mTitleFav = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_text_on_tablayout, null);
            mTitleFav.setCompoundDrawablesWithIntrinsicBounds(0, mTabIcons[3], 0 , 0);
            mTitleFav.setText(getString(mTabTitle[3]));
            mTabLayout.getTabAt(3).setCustomView(mTitleFav);

            TextView mTitleMore = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_text_on_tablayout, null);
            mTitleMore.setCompoundDrawablesWithIntrinsicBounds(0, mTabIcons[4], 0 , 0);
            mTitleMore.setText(getString(mTabTitle[4]));
            mTabLayout.getTabAt(4).setCustomView(mTitleMore);

        }catch(NullPointerException e){
            Log.e(TAG,"NullPointerException in setupTablayout: "+ e);
        }

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAll adapter = new ViewPagerAll(getSupportFragmentManager());
        adapter.addFragment(new NewsFragment(), getString(mTabTitle[0]));
        adapter.addFragment(new NewsXFragment(), getString(mTabTitle[1]));
        adapter.addFragment(new CalendarFragment(), getString(mTabTitle[2]));
        adapter.addFragment(new FavoriteFragment(), getString(mTabTitle[3]));
        adapter.addFragment(new MoreFragment(), getString(mTabTitle[4]));
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

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
