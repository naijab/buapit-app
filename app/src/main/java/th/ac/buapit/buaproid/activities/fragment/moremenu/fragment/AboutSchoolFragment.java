package th.ac.buapit.buaproid.activities.fragment.moremenu.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
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
import th.ac.buapit.buaproid.activities.fragment.moremenu.adapter.recyclerview.AboutSchoolRecyclerViewAdapter;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.AboutSchoolModel;
import th.ac.buapit.buaproid.network.RetrofitConnect;
import th.ac.buapit.buaproid.network.RetrofitRequestInterface;

public class AboutSchoolFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    View view;
    private RecyclerView mRecyclerView;
    private AboutSchoolRecyclerViewAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public AboutSchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about_school, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragement_about_school_recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_about_school_fragment);
        initRecyclerView();
        initSwipeRefreshLayout();
        return view;
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        getAboutSchool();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }


    private void AccessRestNewsFromRetrofit() {
        // check internet
    }

    @Override
    public void onRefresh() {
        mAdapter.clear();
        getAboutSchool();
        Log.i("Person", "On Swipe Refresh Complete");
    }

    private void getAboutSchool() {

        final Map<String, String> mKey = new HashMap<>();
        mKey.put("id", String.valueOf(getString(R.string.api_key_id)));
        mKey.put("key", getString(R.string.api_key));

        RetrofitRequestInterface mInterface = RetrofitConnect.getClient().create(RetrofitRequestInterface.class);

        Call<List<AboutSchoolModel>> mCallCalendar = mInterface.getAboutSchool(mKey);
        mCallCalendar.enqueue(new Callback<List<AboutSchoolModel>>() {
            @Override
            public void onResponse(Call<List<AboutSchoolModel>> call, Response<List<AboutSchoolModel>> response) {
                int statusCode = response.code();

                mSwipeRefreshLayout.setRefreshing(true);

                if (response.isSuccessful()) {

                    final List<AboutSchoolModel> mPersonModel = response.body();

                    mAdapter = (new AboutSchoolRecyclerViewAdapter(getActivity(), mPersonModel));
                    mRecyclerView.setAdapter(mAdapter);
                    mSwipeRefreshLayout.setRefreshing(false);

//                    mAdapter.SetOnItemClickListener(new AboutSchoolRecyclerViewAdapter.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(View view, int position) {
//
//
//
//                        }
//                    });

                    Log.d("Person", "on Response OK: " + statusCode);
                } else {
                    Log.e("Person", "on Response Error: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<AboutSchoolModel>> call, Throwable t) {
                Log.e("Person", "on Enqueue Error: " + t.getMessage());
            }
        });

    }

}
