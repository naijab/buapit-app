package th.ac.buapit.buaproid;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class NewsDetailActivity extends AppCompatActivity {

    AppBarLayout mAppBarLayout;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    Toolbar mToolbar;
    TextView mTitle, mContent;
    ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        initDetail();
        initToolbar();
    }

    private void initDetail(){
        Bundle mGetIntent = getIntent().getExtras();
        String Title = mGetIntent.getString("title");
        String Content = mGetIntent.getString("content");
        String Img = mGetIntent.getString("img");

        mTitle = (TextView) findViewById(R.id.con_title);
        mContent = (TextView) findViewById(R.id.con_content);
        mImg = (ImageView) findViewById(R.id.img);
        mTitle.setText(Title);
        mContent.setText(Content);
        Glide.with(this)
                .load(Img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mImg);
    }
    private void initToolbar() {

        Bundle i = getIntent().getExtras();
        final String Title = i.getString("title");

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.AppBarLayout);

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
                } else if(isShow) {
                    mCollapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });
    }

}
