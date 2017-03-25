package th.ac.buapit.buaproid.activities.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.activities.MainActivity;
import th.ac.buapit.buaproid.activities.fragment.moremenu.fragment.AboutSchoolFragment;
import th.ac.buapit.buaproid.activities.fragment.moremenu.fragment.ContactSchoolFragment;
import th.ac.buapit.buaproid.activities.fragment.moremenu.fragment.PersonFragment;
import th.ac.buapit.buaproid.adapter.viewpager.ViewPagerAll;

public class MoreFragment extends Fragment {

    View view;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    private String TAG = "MoreFragment";

    public MoreFragment() {
        // Required empty public constructor
    }

    private int[] mTabTitle = {
            R.string.history,
            R.string.person,
            R.string.contact_us,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_more_viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) view.findViewById(R.id.fragment_more_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        setupTablayout();
        return view;
    }

    private void setupTablayout() {

        try {
            TextView mTitleHistory = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_text_on_tablayout, null);
            mTitleHistory.setText(getString(mTabTitle[0]));
            mTitleHistory.setTextColor(getResources().getColor(R.color.grey_700));
            mTabLayout.getTabAt(0).setCustomView(mTitleHistory);

            TextView mTitlePerson = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_text_on_tablayout, null);
            mTitlePerson.setText(getString(mTabTitle[1]));
            mTitlePerson.setTextColor(getResources().getColor(R.color.grey_700));
            mTabLayout.getTabAt(1).setCustomView(mTitlePerson);

            TextView mTitleContact = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_text_on_tablayout, null);
            mTitleContact.setText(getString(mTabTitle[2]));
            mTitleContact.setTextColor(getResources().getColor(R.color.grey_700));
            mTabLayout.getTabAt(2).setCustomView(mTitleContact);

        }catch(NullPointerException e){
            Log.e(TAG,"NullPointerException in setup Tablayout: "+ e);
        }

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAll adapter = new ViewPagerAll(getChildFragmentManager());
        adapter.addFragment(new AboutSchoolFragment(), getString(mTabTitle[0]));
        adapter.addFragment(new PersonFragment(), getString(mTabTitle[1]));
        adapter.addFragment(new ContactSchoolFragment(), getString(mTabTitle[2]));
        viewPager.setAdapter(adapter);
    }




}
