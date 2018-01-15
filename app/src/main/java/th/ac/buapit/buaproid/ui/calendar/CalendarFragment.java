package th.ac.buapit.buaproid.ui.calendar;


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

public class CalendarFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    CalendarRecyclerViewAdapter mAdapter;
    private View rootView;
    private String TAG = "CalendarFragment";

    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        initRecyclerView();
        initSwipeRefreshLayout();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_calendar_fragment);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        GetRestCalendarFromRetrofit();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout_calendar_fragment);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mAdapter.clear();
        GetRestCalendarFromRetrofit();
        Log.i(TAG, "On Swipe Refresh Complete");
    }

    private void GetRestCalendarFromRetrofit() {

        final Map<String, String> mKey = new HashMap<>();
        mKey.put("id", String.valueOf(getString(R.string.api_key_id)));
        mKey.put("key", getString(R.string.api_key));

        RetrofitRequestInterface mInterface = RetrofitConnect.getClient().create(RetrofitRequestInterface.class);

        Call<List<CalendarModel>> mCallCalendar = mInterface.getCalendarFull(mKey);
        mCallCalendar.enqueue(new Callback<List<CalendarModel>>() {
            @Override
            public void onResponse(Call<List<CalendarModel>> call, Response<List<CalendarModel>> response) {
                int statusCode = response.code();

                mSwipeRefreshLayout.setRefreshing(true);

                if (response.isSuccessful()) {

                    final List<CalendarModel> mCalendarModel = response.body();

                    mAdapter = (new CalendarRecyclerViewAdapter(getActivity(), mCalendarModel));
                    mRecyclerView.setAdapter(mAdapter);
                    mSwipeRefreshLayout.setRefreshing(false);

                    Log.d(TAG, "on Response OK: " + statusCode);
                } else {
                    Log.e(TAG, "on Response Error: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<CalendarModel>> call, Throwable t) {

                Log.e(TAG, "on Enqueue Error: " + t.getMessage());
            }
        });

    }

}
