package th.ac.buapit.buaproid.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;

import android.content.Context;
import android.widget.Toast;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;
import th.ac.buapit.buaproid.Activities.NewsDetailActivity;
import th.ac.buapit.buaproid.Adapter.Realm.NewsRealmRecyclerViewAdapter;
import th.ac.buapit.buaproid.Model.RealmObject.NewsRealmModel;
import th.ac.buapit.buaproid.R;

public class FavFragment extends Fragment {

    final String TAG = getClass().getName();
    private View rootView;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    NewsRealmRecyclerViewAdapter mAdapter;
    private Realm mRealm;
    Context context;

    public FavFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public void onStop() {
        super.onStop();
        mRealm.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fav, container, false);
        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView() {

        mRealm = Realm.getDefaultInstance();

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycelrview_fav);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        RealmResults<NewsRealmModel> mResults = mRealm.where(NewsRealmModel.class)
                .findAll();

        mAdapter = new NewsRealmRecyclerViewAdapter(getActivity(), mRealm, mResults);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new NewsRealmRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                RealmResults<NewsRealmModel> mResults = mRealm.where(NewsRealmModel.class)
                        .findAll();

                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("id", mResults.get(position).getRealmNewsID());
                intent.putExtra("title", mResults.get(position).getRealmNewsTitle());
                intent.putExtra("content", mResults.get(position).getRealmNewsContent());
                intent.putExtra("img", mResults.get(position).getRealmNewsImage());
                startActivity(intent);

            }
        });
    }


}
