package th.ac.buapit.buaproid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle i = getIntent().getExtras();
        String name = i.getString("getNewsByUser");


        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(name);
    }
}
