package th.ac.buapit.buaproid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import th.ac.buapit.buaproid.Adapter.RecyclerViewAdapter;
import th.ac.buapit.buaproid.Adapter.Test_RecyclerAdapter;
import th.ac.buapit.buaproid.Model.TestModel;


public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ButterKnife Binding
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//
//        layoutManager = new LinearLayoutManager(MainActivity.this);
//        binding.recyclerV.setLayoutManager(layoutManager);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.dummyfrag_scrollableview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
//        JsonCall();
        CheckConnect();
    }

    public void CheckConnect() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
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
                Log.d("Report", "" + string);
//                Toast.makeText(MainActivity.this, ""+ string, Toast.LENGTH_SHORT).show();

                setView(string);
            }
        }.execute();
    }

    public void setView(String string) {
        GsonBuilder builder = new GsonBuilder();
        Gson mGson = builder.create();
        List<TestModel> posts = new ArrayList<TestModel>();
        posts = Arrays.asList(mGson.fromJson(string, TestModel[].class));

//                adapter = new RecyclerViewAdapter(MainActivity.this, posts);
//                binding.recyclerV.setAdapter(adapter);

        Test_RecyclerAdapter adapter2 = new Test_RecyclerAdapter(MainActivity.this, posts);
        recyclerView.setAdapter(adapter2);
        final List<TestModel> finalPosts = posts;
        adapter2.SetOnItemClickListener(new Test_RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //มันจะเริ่มนับจาก 0
//                Toast.makeText(MainActivity.this, "กดอันที่ "+ position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("getNewsByUser", finalPosts.get(position).getNewsTitle());
                startActivity(intent);
            }
        });
    }

//    private void JsonCall() {
//        RequestQueue queue = Volley.newRequestQueue(this);
////        String url = "http://toscanyacademy.com/blog/mp.php";
//        String url ="http://app.buapit.ac.th/sada/json/json_news.php?id=1039760327&key=avgfefAgfsdRdCidlVREWSfelfLKAqwporzcgo";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e(TAG, "Response Json" + response);
//
//                Gson gson = new Gson();
//                Type collectionType = new TypeToken<Collection<TestModel>>() {}.getType();
//                Collection<TestModel> enums = gson.fromJson(response, collectionType);
//                TestModel[] u = enums.toArray(new TestModel[enums.size()]);
//
//                Log.d(TAG, u[0].getNewsByUser());
//
//    /*            GsonBuilder builder = new GsonBuilder();
//                Gson mGson = builder.create();
//                List<TestModel> posts = new ArrayList<TestModel>();
//                posts = Arrays.asList(mGson.fromJson(response, TestModel[].class));
//
//
//
//                adapter = new RecyclerViewAdapter(MainActivity.this, posts);
//                binding.recyclerV.setAdapter(adapter);*/
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d(TAG, "Error " + error.getMessage());
//            }
//        });
//        queue.add(stringRequest);
//    }

}
