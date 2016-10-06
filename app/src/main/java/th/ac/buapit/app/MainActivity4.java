package th.ac.buapit.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import th.ac.buapit.app.Adapter.PersonAdapter;
import th.ac.buapit.app.Model.PersonItem;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.R.id.list;


public class MainActivity4 extends AppCompatActivity {

    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private RecyclerView mRecyclerView;
    private PersonAdapter mAdapter;
    private SwipeRefreshLayout swipeContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        try {
            final ListView listViewMovies = (ListView)findViewById(R.id.recycler_view_person);
            String url = "http://app.buapit.ac.th/sada/json/json_person.php?id=1039760327&key=avgfefAgfsdRdCidlVREWSfelfLKAqwporzcgo";
            JSONArray data1 = new JSONArray(getJSONW(url,params));

            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for(int i = 0; i < data1.length(); i++){
                JSONObject c = data1.getJSONObject(i);

                map = new HashMap<String, String>();
                map.put("person_name", c.getString("person_name"));
                map.put("person_position", c.getString("person_position"));
                map.put("person_faction", c.getString("person_faction"));
                map.put("person_tel", c.getString("person_tel"));
                MyArrList.add(map);

            }


            SimpleAdapter simpleAdapterDataW;
            simpleAdapterDataW = new SimpleAdapter(MainActivity4.this, MyArrList, R.layout.card_row_person,
                    new String[] {"person_name", "person_position", "person_faction","person_tel"}, new int[] {R.id.tv_person_name, R.id.tv_person_posi, R.id.tv_person_fac});
            listViewMovies.setAdapter(simpleAdapterDataW);

            final AlertDialog.Builder viewDetails = new AlertDialog.Builder(this);
            // OnClick Item
            listViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> myAdapter, View myView,
                                        int position, long mylng) {

                    String sTitle = MyArrList.get(position).get("person_name")
                            .toString();
                    String sDes = MyArrList.get(position).get("person_position")
                            .toString();
                    String sDess = MyArrList.get(position).get("person_faction")
                            .toString();
                    final String sDow = MyArrList.get(position).get("person_tel")
                            .toString();

                    //String sMemberID = ((TextView) myView.findViewById(R.id.ColMemberID)).getText().toString();
                    // String sName = ((TextView) myView.findViewById(R.id.ColName)).getText().toString();
                    // String sTel = ((TextView) myView.findViewById(R.id.ColTel)).getText().toString();

                    viewDetails.setTitle("รายระเอียด" + sTitle);
                    viewDetails.setMessage("ตำแหน่ง : " + sDes + "\n"
                    +"ฝ่าย : " + sDess);
                    viewDetails.setPositiveButton("โทรศัพท์",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + sDow));
                                    startActivity(intent);
                                    dialog.dismiss();
                                }
                            });
                    viewDetails.setNegativeButton("ยกเลิก",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    dialog.dismiss();
                                }
                            });
                    viewDetails.show();

                }
            });
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getJSONW(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse responseW = client.execute(httpPost);
            StatusLine statusLine = responseW.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = responseW.getEntity();
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
