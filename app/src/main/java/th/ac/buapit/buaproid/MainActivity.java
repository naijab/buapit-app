package th.ac.buapit.buaproid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import th.ac.buapit.buaproid.Adapter.NewsRecyclerViewAdapter;
import th.ac.buapit.buaproid.Model.NewsModel;
import th.ac.buapit.buaproid.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    ProgressDialog dialog;
    ActivityMainBinding binding;
    SwipeRefreshLayout swipeRefreshLayout;
    private AsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ButterKnife Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);
//        LoadJson();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        binding.RecyclerVHome.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//        binding.RecyclerVHome.setLayoutManager(linearLayoutManager);
//        binding.RecyclerVHome.setHasFixedSize(true);

//        binding.swipeRefreshLayoutHome.post(new Runnable() {
//            @Override
//            public void run() {
//                binding.swipeRefreshLayoutHome.setRefreshing(true);
//            }
//        });
        new LoadJson().execute();
//        binding.swipeRefreshLayoutHome.setEnabled(true);
        binding.swipeRefreshLayoutHome.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               // LoadJson();
                binding.swipeRefreshLayoutHome.setEnabled(true);
                new LoadJson().execute();
            }
        });

        binding.swipeRefreshLayoutHome.post(new Runnable() {
            @Override
            public void run() {
                binding.swipeRefreshLayoutHome.setRefreshing(true);
            }
        });


    }

    private class LoadJson extends AsyncTask<Void, Void, String> {

            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                dialog = new ProgressDialog(MainActivity.this);
                dialog.setTitle("Loading...");
                dialog.show();

//                if(!binding.swipeRefreshLayoutHome.isRefreshing()){
//                    binding.swipeRefreshLayoutHome.setEnabled(true);
//                }

            }

            @Nullable
            @Override
            protected String doInBackground(Void... params) {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://app.buapit.ac.th/sada/json/json_news.php?id=1039760327&key=avgfefAgfsdRdCidlVREWSfelfLKAqwporzcgo").build();

                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        return response.body().string();
                    } else {
                        return "Not Success - code : " + response.code();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Error - " + e.getMessage();
                }

            }

            @Override
            protected void onPostExecute(String string) {
                super.onPostExecute(string);

                binding.swipeRefreshLayoutHome.setEnabled(false);

                dialog.dismiss();
//                binding.swipeRefreshLayoutHome.setEnabled(false);
                Log.d("Json==> ", " " + string);
                setView(string);
            }
//        .execute();
    }


    public void setView(String string) {
        GsonBuilder builder = new GsonBuilder();
        Gson mGson = builder.create();
        List<NewsModel> posts = new ArrayList<NewsModel>();
        posts = Arrays.asList(mGson.fromJson(string, NewsModel[].class));

//      adapter = new RecyclerViewAdapter(MainActivity.this, posts);
//      binding.recyclerV.setAdapter(adapter);

        NewsRecyclerViewAdapter adapter = new NewsRecyclerViewAdapter(MainActivity.this, posts);
        binding.RecyclerVHome.setAdapter(adapter);



        final List<NewsModel> finalPosts = posts;
        adapter.SetOnItemClickListener(new NewsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("title", finalPosts.get(position).getNewsTitle());
                intent.putExtra("content", finalPosts.get(position).getNewsContent());
                intent.putExtra("img", finalPosts.get(position).getNewsImg());
                startActivity(intent);
            }
        });
    }

}
