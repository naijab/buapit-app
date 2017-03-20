package th.ac.buapit.buaproid.activities.fragment.moremenu.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.AboutSchoolModel;

public class ContactSchoolFragment extends Fragment {

    View view;
    TextView mAppVersion;
    AboutSchoolModel mData;

    public ContactSchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_school, container, false);

        mAppVersion = (TextView) view.findViewById(R.id.tv_contact_app_version);

        GetAppVersion();
        return view;
    }

    private void GetAppVersion() {
        PackageManager manager = getActivity().getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(getActivity().getPackageName(), 0);

            String versionName = info.versionName;
            mAppVersion.setText("V."+ versionName);

        } catch (PackageManager.NameNotFoundException e) {
            Log.i("Contact: ", "NameNotFoundException: " + e);
        }

    }



}
