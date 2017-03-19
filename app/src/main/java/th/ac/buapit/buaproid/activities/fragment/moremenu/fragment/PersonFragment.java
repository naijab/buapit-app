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
import th.ac.buapit.buaproid.activities.fragment.moremenu.adapter.recyclerview.PersonRecyclerViewAdapter;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.PersonModel;
import th.ac.buapit.buaproid.network.RetrofitConnect;
import th.ac.buapit.buaproid.network.RetrofitRequestInterface;

public class PersonFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    View view;
    private RecyclerView mRecyclerView;
    private PersonRecyclerViewAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_person, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragement_people_recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_person_fragment);
        initRecyclerView();
        initSwipeRefreshLayout();
        return view;
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);

        getPersonLoad();
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
        getPersonLoad();
        Log.i("Person", "On Swipe Refresh Complete");
    }

    private void getPersonLoad() {

        final Map<String, String> mKey = new HashMap<>();
        mKey.put("id", String.valueOf(getString(R.string.api_key_id)));
        mKey.put("key", getString(R.string.api_key));

        RetrofitRequestInterface mInterface = RetrofitConnect.getClient().create(RetrofitRequestInterface.class);

        Call<List<PersonModel>> mCallCalendar = mInterface.getPeopleFull(mKey);
        mCallCalendar.enqueue(new Callback<List<PersonModel>>() {
            @Override
            public void onResponse(Call<List<PersonModel>> call, Response<List<PersonModel>> response) {
                int statusCode = response.code();

                mSwipeRefreshLayout.setRefreshing(true);

                if (response.isSuccessful()) {

                    final List<PersonModel> mPersonModel = response.body();

                    mAdapter = (new PersonRecyclerViewAdapter(getActivity(), mPersonModel));
                    mRecyclerView.setAdapter(mAdapter);
                    mSwipeRefreshLayout.setRefreshing(false);

                    mAdapter.SetOnItemClickListener(new PersonRecyclerViewAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            String namePersons = mPersonModel.get(position).getNamePerson();
                            String positionPerson = mPersonModel.get(position).getPositionPerson();
                            final String telPerson = mPersonModel.get(position).getTelPerson();
                            String factionPerson = mPersonModel.get(position).getFactionPerson();
                            AlertDialog.Builder builder =
                                    new AlertDialog.Builder(getActivity());
                            builder.setTitle(namePersons);
                            builder.setMessage(
                                    "ตำแหน่ง: "+ positionPerson +"\n\n\n"
                                    +"ฝ่าย: " + factionPerson);
                            builder.setPositiveButton("โทรออก", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telPerson, null));
                                    startActivity(intent);

                                }
                            });
                            builder.setNegativeButton("ปิด", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            builder.show();

                        }
                    });

                    Log.d("Person", "on Response OK: " + statusCode);
                } else {
                    Log.e("Person", "on Response Error: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<PersonModel>> call, Throwable t) {
                Log.e("Person", "on Enqueue Error: " + t.getMessage());
            }
        });

    }

}
