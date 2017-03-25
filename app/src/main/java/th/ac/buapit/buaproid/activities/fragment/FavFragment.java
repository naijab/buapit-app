package th.ac.buapit.buaproid.activities.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;
import io.realm.RealmResults;
import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.activities.NewsDetailActivity;
import th.ac.buapit.buaproid.adapter.realm.NewsRealmRecyclerViewAdapter;
import th.ac.buapit.buaproid.model.realmobject.NewsRealmModel;

public class FavFragment extends Fragment {

    RecyclerView mRecyclerView;
    NewsRealmRecyclerViewAdapter mAdapter;
    Context context;
    private View rootView;
    private Realm mRealm;
    private String TAG = "FavFragment";

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

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_fav_fragment);
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
