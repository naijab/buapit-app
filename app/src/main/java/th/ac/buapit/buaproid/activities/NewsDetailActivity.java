package th.ac.buapit.buaproid.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import io.realm.Realm;
import io.realm.RealmResults;
import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.model.realmobject.NewsRealmModel;

public class NewsDetailActivity extends AppCompatActivity {

    AppBarLayout mAppBarLayout;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    CoordinatorLayout mCoordinatorLayoout;
    Toolbar mToolbar;
    TextView mTitle, mContent;
    ImageView mImg;
    FloatingActionButton mFab;
    Realm mRealm;
    private String TAG = "NewsDetail Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        mRealm = Realm.getDefaultInstance();

        initDetail();
        initFab();
        initToolbar();
        initCollapsingToolbarLayout();
        initNestScroll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }


    private void initDetail() {
        Bundle mGetIntent = getIntent().getExtras();
        String Title = mGetIntent.getString("title");
        String Content = mGetIntent.getString("content");
        String Img = mGetIntent.getString("img");

        mTitle = (TextView) findViewById(R.id.tv_news_detail_title);
        mContent = (TextView) findViewById(R.id.tv_news_detail_content);
        mImg = (ImageView) findViewById(R.id.img_news_detail);

        mTitle.setText(Title);
        mContent.setText(Content);
        Glide.with(this)
                .load(Img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mImg);

    }

    boolean isClickFAB = false;

    private void initFab() {

        Bundle mGetIntent = getIntent().getExtras();
        final int Id = mGetIntent.getInt("id");
        final String Title = mGetIntent.getString("title");
        final String Content = mGetIntent.getString("content");
        final String Img = mGetIntent.getString("img");

        mFab = (FloatingActionButton) findViewById(R.id.fab_save_news_detail);
        mCoordinatorLayoout = (CoordinatorLayout) findViewById(R.id.coordinator_news_detail);

        mFab.setClickable(true);

        final RealmResults<NewsRealmModel> resultRealm = mRealm.where(NewsRealmModel.class)
                .equalTo("RealmNewsID", Id)
                .findAll();

        if (resultRealm.size() == 0) {
            Log.d(TAG, "No Have In Realm");
            Drawable mDelete = getResources().getDrawable(R.drawable.ic_star);
            mFab.setBackgroundTintList(getResources().getColorStateList(R.color.colorYellow));
            mFab.setImageDrawable(mDelete);
            isClickFAB = true;
        } else {
            Log.d(TAG, "Yes Have In Realm");
            Drawable mDelete = getResources().getDrawable(R.drawable.ic_delete);
            mFab.setBackgroundTintList(getResources().getColorStateList(R.color.colorRed));
            mFab.setImageDrawable(mDelete);
            isClickFAB = false;
        }

        if (mFab != null) {
            mFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (isClickFAB) {
                        mRealm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                NewsRealmModel mNewsRealm = mRealm.createObject(NewsRealmModel.class, Id);
                                mNewsRealm.setRealmNewsTitle(Title);
                                mNewsRealm.setRealmNewsContent(Content);
                                mNewsRealm.setRealmNewsImage(Img);
                                isClickFAB = false;
                                Drawable mDelete = getResources().getDrawable(R.drawable.ic_delete);
                                mFab.setBackgroundTintList(getResources().getColorStateList(R.color.colorRed));
                                mFab.setImageDrawable(mDelete);

                                Log.i(TAG, "Success to save to Realm");

                                Snackbar snackbar = Snackbar
                                        .make(mCoordinatorLayoout, getString(R.string.news_saved), Snackbar.LENGTH_SHORT);
                                snackbar.show();
                            }
                        });
                    } else {

                        mRealm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                resultRealm.deleteAllFromRealm();
                                isClickFAB = true;
                                Drawable mDelete = getResources().getDrawable(R.drawable.ic_star);
                                mFab.setBackgroundTintList(getResources().getColorStateList(R.color.colorYellow));
                                mFab.setImageDrawable(mDelete);
                                Log.i(TAG, "Success to delete to Realm");

                                Snackbar snackbar = Snackbar
                                        .make(mCoordinatorLayoout, getString(R.string.news_deleted), Snackbar.LENGTH_SHORT);
                                snackbar.show();
                            }
                        });
                    }
                }
            });
        }
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_news_detail);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initCollapsingToolbarLayout() {
        Bundle i = getIntent().getExtras();
        final String Title = i.getString("title");

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout_news_detail);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout_news_detail);
        mCollapsingToolbarLayout.setTitle("");
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    mCollapsingToolbarLayout.setTitle(Title);
                    isShow = true;
                } else if (isShow) {
                    mCollapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });
    }

    private void initNestScroll() {

        NestedScrollView nsv = (NestedScrollView) findViewById(R.id.nest_scrollview_news_detail);
        nsv.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    mFab.hide();
                } else {
                    mFab.show();
                }
            }
        });

    }


}
