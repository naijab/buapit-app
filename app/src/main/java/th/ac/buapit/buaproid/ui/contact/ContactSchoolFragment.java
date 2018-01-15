package th.ac.buapit.buaproid.ui.contact;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import th.ac.buapit.buaproid.R;

public class ContactSchoolFragment extends Fragment {

    View view;
    TextView mAppVersion;
    Button mButtonFacebook;
    Button mButtonWebsite;
    Button mButtonCall;
    Button mButtonGPS;
    private String TAG = "ContactSchoolFragment";

    public ContactSchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_school, container, false);

        mAppVersion = (TextView) view.findViewById(R.id.tv_contact_app_version);

        GetAppVersion();
        GetVisit();
        return view;
    }

    private void GetAppVersion() {
        PackageManager manager = getActivity().getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(getActivity().getPackageName(), 0);

            String versionName = info.versionName;
            mAppVersion.setText("v."+ versionName);

        } catch (PackageManager.NameNotFoundException e) {
            Log.i(TAG, "NameNotFoundException: " + e);
        }

    }

    private void GetVisit() {
        mButtonFacebook = (Button) view.findViewById(R.id.btn_contact_facebook);
        mButtonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.facebook_uri)));
                startActivity(intent);
            }
        });

        mButtonWebsite = (Button) view.findViewById(R.id.btn_contact_website);
        mButtonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.website_uri)));
                startActivity(intent);
            }
        });

        mButtonGPS = (Button) view.findViewById(R.id.btn_contact_gps);
        mButtonGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc:" + getString(R.string.school_gps_uri_lat) + "," + getString(R.string.school_gps_uri_long) + " (" + getString(R.string.school_name) + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        mButtonCall = (Button) view.findViewById(R.id.btn_contact_call);
        mButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","042312547-8", null));
                startActivity(intent);
            }
        });
    }



}
