package th.ac.buapit.buaproid.ui.news;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.network.RetrofitConnect;
import th.ac.buapit.buaproid.network.RetrofitRequestInterface;

public class NewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private View rootView;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    NewsRecyclerViewAdapter mAdapter;
    private String TAG = "NewsFragment";

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_news, container, false);
        initRecyclerView();
        initSwipeRefreshLayout();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_news_fragment);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        GetRestNewsFromRetrofit();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout_news_fragment);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mAdapter.clear();
        GetRestNewsFromRetrofit();
        Log.i(TAG, "On Swipe Refresh Complete");
    }

    private void GetRestNewsFromRetrofit() {

        final Map<String, String> mKey = new HashMap<>();
        mKey.put("id", String.valueOf(getString(R.string.api_key_id)));
        mKey.put("key", getString(R.string.api_key));

        RetrofitRequestInterface mInterface = RetrofitConnect.getClient().create(RetrofitRequestInterface.class);

        Call<List<NewsModel>> mCallNews = mInterface.getNewsFull(mKey);
        mCallNews.enqueue(new Callback<List<NewsModel>>() {
            @Override
            public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                int statusCode = response.code();

                mSwipeRefreshLayout.setRefreshing(true);

                if (response.isSuccessful()) {

                    final List<NewsModel> mNewModel = response.body();

                    mAdapter = (new NewsRecyclerViewAdapter(getActivity(), mNewModel));
                    mRecyclerView.setAdapter(mAdapter);
                    mSwipeRefreshLayout.setRefreshing(false);

                    mAdapter.SetOnItemClickListener(new NewsRecyclerViewAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                            intent.putExtra("id", mNewModel.get(position).getNewsId());
                            intent.putExtra("title", mNewModel.get(position).getNewsTitle());
                            intent.putExtra("content", mNewModel.get(position).getNewsContent());
                            intent.putExtra("img", mNewModel.get(position).getNewsImg());
                            startActivity(intent);

                        }
                    });


                    Log.d(TAG, "on Response OK: " + statusCode);
                } else {
                    Log.e(TAG, "on Response Error: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {

                Log.e(TAG, "on Enqueue Error: " + t.getMessage());
            }
        });

    }


}
