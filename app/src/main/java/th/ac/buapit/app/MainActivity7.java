package th.ac.buapit.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        try {
            final ListView listViewMovies = (ListView)findViewById(R.id.recycler_view_dowload);
            String url = "http://app.buapit.ac.th/sada/json/json_download.php?id=1039760327&key=avgfefAgfsdRdCidlVREWSfelfLKAqwporzcgo";
            JSONArray data1 = new JSONArray(getJSONB(url,params));

            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for(int i = 0; i < data1.length(); i++){
                JSONObject c = data1.getJSONObject(i);

                map = new HashMap<String, String>();
                map.put("download_title", c.getString("download_title"));
                map.put("download_desc", c.getString("download_desc"));
                map.put("download_url", c.getString("download_url"));
                MyArrList.add(map);

            }


            SimpleAdapter simpleAdapterDataY;
            simpleAdapterDataY = new SimpleAdapter(MainActivity7.this, MyArrList, R.layout.card_row_download,
                    new String[] {"download_title", "download_desc", "download_url"}, new int[] {R.id.tv_download_name, R.id.tv_download_desc});
            listViewMovies.setAdapter(simpleAdapterDataY);

            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);
            // OnClick Item
            listViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> myAdapter, View myView,
                                        int position, long mylng) {

                    String sTitle = MyArrList.get(position).get("download_title")
                            .toString();
                    String sDes = MyArrList.get(position).get("download_desc")
                            .toString();
                    final String sDow = MyArrList.get(position).get("download_url")
                            .toString();

                    //String sMemberID = ((TextView) myView.findViewById(R.id.ColMemberID)).getText().toString();
                    // String sName = ((TextView) myView.findViewById(R.id.ColName)).getText().toString();
                    // String sTel = ((TextView) myView.findViewById(R.id.ColTel)).getText().toString();

                    viewDetail.setTitle("รายระเอียด" + sTitle);
                    viewDetail.setMessage("รายระเอียด : " + sDes);
                    viewDetail.setPositiveButton("ดาวน์โหลด",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(sDow));
                                    startActivity(i);
                                    dialog.dismiss();
                                }
                            });
                    viewDetail.setNegativeButton("ยกเลิก",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    dialog.dismiss();
                                }
                            });
                    viewDetail.show();

                }
            });
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getJSONB(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse responseY = client.execute(httpPost);
            StatusLine statusLine = responseY.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = responseY.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader_buffer = new BufferedReader
                        (new InputStreamReader(content));

                String line;
                while ((line = reader_buffer.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download file..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
