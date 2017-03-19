package th.ac.buapit.buaproid.activities.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.activities.fragment.moremenu.fragment.AboutSchoolFragment;
import th.ac.buapit.buaproid.activities.fragment.moremenu.fragment.ContactSchoolFragment;
import th.ac.buapit.buaproid.activities.fragment.moremenu.fragment.PeopleFragment;
import th.ac.buapit.buaproid.adapter.viewpager.ViewPagerAll;

public class MoreFragment extends Fragment {

    View view;
    ViewPager mViewPager;
    TabLayout mTabLayout;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_more_viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) view.findViewById(R.id.fragment_more_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        return view;

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAll adapter = new ViewPagerAll(getChildFragmentManager());
        adapter.addFragment(new AboutSchoolFragment(), "ประวัติ");
        adapter.addFragment(new PeopleFragment(), "บุคลากร");
        adapter.addFragment(new ContactSchoolFragment(), "ติดต่อเรา");
        viewPager.setAdapter(adapter);
    }




}
