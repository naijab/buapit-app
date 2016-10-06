package th.ac.buapit.app;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity5 extends AppCompatActivity {

    private static final String BASE_URL = "http://10.0.2.2/tcdc/check2.php";
    private OkHttpClient client = new OkHttpClient();
    EditText permit_id_codeTextEdit, permit_nameTextEdit, permit_classTextEdit, permit_telTextEdit, permit_casueTextEdit, permit_addTextEdit,
            permit_startTextEdit, permit_endTextEdit,permit_byTextEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        permit_id_codeTextEdit = (EditText) findViewById(R.id.permit_id_codeTX);
        permit_nameTextEdit = (EditText) findViewById(R.id.permit_id_codeTX);*/
      /*  Button login = (Button) findViewById(R.id.permit_id_codeTX);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle login
                String username = permit_id_codeTextEdit.getText().toString();
                String password = permit_nameTextEdit.getText().toString();

            }
        });*/
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        try {
            final ListView listViewMovies = (ListView)findViewById(R.id.recycler_view_permit);
            String url = "http://app.buapit.ac.th/sada/json/json_permit.php?id=1039760327&key=avgfefAgfsdRdCidlVREWSfelfLKAqwporzcgo";
            JSONArray data = new JSONArray(getJSONs(url,params));

            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for(int i = 0; i < data.length(); i++){
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<String, String>();
                map.put("permit_name", c.getString("permit_name"));
                map.put("permit_id_code", c.getString("permit_id_code"));
                map.put("permit_class", c.getString("permit_class"));
                map.put("permit_status", c.getString("permit_status"));
                MyArrList.add(map);

            }


            SimpleAdapter simpleAdapterDatas;
            simpleAdapterDatas = new SimpleAdapter(MainActivity5.this, MyArrList, R.layout.card_row_permit,
                    new String[] {"permit_name", "permit_id_code", "permit_class","permit_status"}, new int[] {R.id.tv_permit_name, R.id.tv_permit_code, R.id.tv_permit_class, R.id.tv_permit_status});
            listViewMovies.setAdapter(simpleAdapterDatas);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getJSONs(String url,List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse responses = client.execute(httpPost);
            StatusLine statusLine = responses.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = responses.getEntity();
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
