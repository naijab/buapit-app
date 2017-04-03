package th.ac.buapit.buaproid.activities.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import th.ac.buapit.buaproid.R;

public class NewsXFragment extends Fragment {

    View view;
    WebView mWebView;

    public NewsXFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_x, container, false);

        getWeb();
        return view;
    }

    public void getWeb() {

        mWebView = (WebView) view.findViewById(R.id.webview_newsx_fragment);

    }
}
