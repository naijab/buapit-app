package th.ac.buapit.buaproid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle i = getIntent().getExtras();
        String name = i.getString("title");
        String content = i.getString("content");
        String img = i.getString("img");


        TextView textView = (TextView) findViewById(R.id.con_title);
        TextView textView2 = (TextView) findViewById(R.id.con_content);
        ImageView imgView = (ImageView) findViewById(R.id.img);
        textView.setText(name);
        textView2.setText(content);
        Glide.with(this)
                .load(img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgView);
    }
}
