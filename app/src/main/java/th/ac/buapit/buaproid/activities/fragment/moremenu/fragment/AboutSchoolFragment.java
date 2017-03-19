package th.ac.buapit.buaproid.activities.fragment.moremenu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.ac.buapit.buaproid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutSchoolFragment extends Fragment {


    public AboutSchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_school, container, false);
    }

}
