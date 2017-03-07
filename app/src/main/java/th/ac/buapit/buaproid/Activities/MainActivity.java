package th.ac.buapit.buaproid.Activities;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import th.ac.buapit.buaproid.Fragment.CalendarFragment;
import th.ac.buapit.buaproid.Fragment.FavFragment;
import th.ac.buapit.buaproid.Fragment.NewsFragment;
import th.ac.buapit.buaproid.Model.RealmObject.NewsRealmModel;
import th.ac.buapit.buaproid.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    final String TAG = getClass().getName();
    Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRealm = Realm.getDefaultInstance();

        initFragment();
        initBottomBar();
    }

    private void initFragment(){
        NewsFragment mFragmentNews = new NewsFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_fragment_container, mFragmentNews);
        transaction.commit();
    }

    public void pushNewFragment(Fragment newFrag, String tagg) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment_container, newFrag, tagg);
        transaction.commit();
    }

    private void initBottomBar(){

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
//                switch (tabId){
//                    case R.id.buttom_nav_item_home :
//
//                }
                if (tabId == R.id.buttom_nav_item_home) {
                    Log.d(TAG, "Open News Fragment");
                    Fragment mNewsFragment = new NewsFragment();
                    pushNewFragment(mNewsFragment, "News");
                }
                else if (tabId == R.id.buttom_nav_item_calendar) {
                    Log.d(TAG, "Open Calendar Fragment");
                    Fragment mCalendarFragment = new CalendarFragment();
                    pushNewFragment(mCalendarFragment, "Calendar");
                }
                else if (tabId == R.id.buttom_nav_item_fav) {


//                    Toast toastF = Toast.makeText (MainActivity.this, "Favarite", Toast.LENGTH_SHORT );
//                    toastF.show ();
//                    Log.d(TAG, "Open Fav Fragment");
                    Fragment mFavFragment = new FavFragment();
                    pushNewFragment(mFavFragment, "Fav");


//                    RealmResults<NewsRealmModel> resultRealm = mRealm.where(NewsRealmModel.class)
//                            .findAll();
//
//                    for(NewsRealmModel newsRealm : resultRealm)
//                    {
//                        Log.d(TAG, "Realm DB \n"
//                                + newsRealm.getRealmNewsID() +"\n"
//                                + newsRealm.getRealmNewsTitle() +"\n"
//                                + newsRealm.getRealmNewsContent() +"\n"
//                                + newsRealm.getRealmNewsImage());
//
////                        Toast toastF = Toast.makeText (MainActivity.this,
////                                "Realm \n"
////                                 + newsRealm.getRealmNewsID() +"\n\n\n\n\n\n\n\n\n\n"
////                                 + newsRealm.getRealmNewsTitle() +"\n\n\n\n\n\n\n\n\n\n"
////                                 + newsRealm.getRealmNewsContent() +"\n\n\n\n\n\n\n\n\n\n"
////                                 + newsRealm.getRealmNewsImage()
////                                ,Toast.LENGTH_LONG );
////                        toastF.show ();
//                    }





                }
                else if (tabId == R.id.buttom_nav_item_class) {
//                    Toast toastF = Toast.makeText (MainActivity.this, "Favarite", Toast.LENGTH_SHORT );
//                    toastF.show ();
                    Log.d(TAG, "Open Class Fragment");
                    Fragment mCalendarFragment = new CalendarFragment();
                    pushNewFragment(mCalendarFragment, "Calendar");

                }
                else if (tabId == R.id.buttom_nav_item_plus) {
//                    Toast toastF = Toast.makeText (MainActivity.this, "Favarite", Toast.LENGTH_SHORT );
//                    toastF.show ();
                    Log.d(TAG, "Open Plus Fragment");
                    Fragment mCalendarFragment = new CalendarFragment();
                    pushNewFragment(mCalendarFragment, "Calendar");
                }

            }
        });

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