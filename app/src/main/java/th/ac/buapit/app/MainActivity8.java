package th.ac.buapit.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BasicStatusLine;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity8 extends AppCompatActivity {
    private static final String BASE_URL = "http://app.buapit.ac.th/sada/app/add_permit.php";
    private OkHttpClient client = new OkHttpClient();
    EditText formTV1,formTV2,formTV3,formTV4,formTV5,formTV6,formTV7,formTV8,formTV9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
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

        formTV1 = (EditText) findViewById(R.id.FormTV1);
        //formTV2 = (EditText) findViewById(R.id.FormTV2);
        formTV3 = (EditText) findViewById(R.id.FormTV3);
        formTV4 = (EditText) findViewById(R.id.FormTV4);
        formTV5 = (EditText) findViewById(R.id.FormTV5);
        formTV6 = (EditText) findViewById(R.id.FormTV6);
        formTV7 = (EditText) findViewById(R.id.FormTV7);
        formTV8 = (EditText) findViewById(R.id.FormTV8);
        formTV9 = (EditText) findViewById(R.id.FormTV9);

        Button login = (Button) findViewById(R.id.buttonSend);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle login
                String id = "null";
                String p1 = formTV1.getText().toString();
                String p2 = formTV3.getText().toString();
                String p3 = formTV4.getText().toString();
                String p4 = formTV5.getText().toString();
                String p5 = formTV6.getText().toString();
                String p6 = formTV7.getText().toString();
                String p7 = formTV8.getText().toString();
                String p8 = formTV9.getText().toString();

               try{
                   ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                   nameValuePairs.add(new BasicNameValuePair("permit_id", id));
                   nameValuePairs.add(new BasicNameValuePair("permit_id_code", p1));
                   nameValuePairs.add(new BasicNameValuePair("permit_name", p2));
                   nameValuePairs.add(new BasicNameValuePair("permit_class", p3));
                   nameValuePairs.add(new BasicNameValuePair("permit_tel", p4));
                   nameValuePairs.add(new BasicNameValuePair("permit_casue", p5));
                   nameValuePairs.add(new BasicNameValuePair("permit_add", p6));
                   nameValuePairs.add(new BasicNameValuePair("permit_start", p7));
                   nameValuePairs.add(new BasicNameValuePair("permit_end", p8));

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://app.buapit.ac.th/sada/app/add_permit.php");
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
                httpClient.execute(httpPost);

               } catch (Exception e) {

               }

            }
        });
    }


}
