package th.ac.buapit.buaproid.Activities;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import th.ac.buapit.buaproid.Adapter.ViewPager.ViewPagerHomeAdapter;
import th.ac.buapit.buaproid.Fragment.CalendarFragment;
import th.ac.buapit.buaproid.Fragment.FavFragment;
import th.ac.buapit.buaproid.Fragment.NewsFragment;
import th.ac.buapit.buaproid.Model.RealmObject.NewsRealmModel;
import th.ac.buapit.buaproid.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    final String TAG = getClass().getName();
    Realm mRealm;
    private ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    NewsFragment newsFragment;
    CalendarFragment calendarFragment;
    FavFragment favFragment;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRealm = Realm.getDefaultInstance();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

//        initFragment();
//        initBottomBar();

        setupBottomNav();
    }

//    private void initFragment(){
//        NewsFragment mFragmentNews = new NewsFragment();
//        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.layout_fragment_container, mFragmentNews);
//        transaction.commit();
//    }

//    public void pushNewFragment(Fragment newFrag) {
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.layout_fragment_container, newFrag);
//        transaction.commit();
//    }

//    private void initBottomBar(){
//
//        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
//
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                switch (tabId) {
//                    case R.id.buttom_nav_item_home:
//                        Log.d(TAG, "Open News Fragment");
//                        Fragment mNewsFragment = new NewsFragment();
//                        pushNewFragment(mNewsFragment);
//                        break;
//                    case R.id.buttom_nav_item_class:
//                        Log.d(TAG, "Open Class Fragment");
////                        Fragment mCalendarFragment = new CalendarFragment();
////                        pushNewFragment(mCalendarFragment);
//                        break;
//
//                    case R.id.buttom_nav_item_calendar:
//                        Log.d(TAG, "Open Calendar Fragment");
//                        Fragment mCalendarFragment = new CalendarFragment();
//                        pushNewFragment(mCalendarFragment);
//                        break;
//
//                    case R.id.buttom_nav_item_fav:
//                        Log.d(TAG, "Open Fav Fragment");
//                        Fragment mFavFragment = new FavFragment();
//                        pushNewFragment(mFavFragment);
//                        break;
//
//                    case R.id.buttom_nav_item_plus:
//                        Log.d(TAG, "Open Plus Fragment");
////                        Fragment mCalendarFragment = new CalendarFragment();
////                        pushNewFragment(mCalendarFragment);
//                        break;
//                }
//            }
//        });
//    }

    private void setupBottomNav() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.buttom_nav_item_home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.buttom_nav_item_calendar:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.buttom_nav_item_fav:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });
        initViewPager();
    }

    private void initViewPager() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerHomeAdapter adapter = new ViewPagerHomeAdapter(getSupportFragmentManager());
        newsFragment = new NewsFragment();
        calendarFragment = new CalendarFragment();
        favFragment = new FavFragment();
        adapter.addFragment(newsFragment);
        adapter.addFragment(calendarFragment);
        adapter.addFragment(favFragment);
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
