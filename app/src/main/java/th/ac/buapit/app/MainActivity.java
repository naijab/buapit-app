package th.ac.buapit.app;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import th.ac.buapit.app.Adapter.CustomAndroidGridViewAdapterMenuHome;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    public static String[] menuHome = {
            "ข้อมูลโรงเรียน",
            "ข่าวสาร",
            "บุคลากร",
            "ใบขออนุญาต",
            "ปฏิทินกิจกรรม",
            "ดาวน์โหลด",
            "ขออนุญาต"

    } ;
    public static int[] menuHomeimageId = {
            R.drawable.ic_menu_1,
            R.drawable.ic_menu_2,
            R.drawable.ic_menu_3,
            R.drawable.ic_menu_4,
            R.drawable.ic_menu_5,
            R.drawable.ic_menu_6,
            R.drawable.ic_add_box_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect firebase notification
        FirebaseMessaging.getInstance().subscribeToTopic("buapit");
        FirebaseInstanceId.getInstance().getToken();
        //End firebase notification

       // toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);

        //เมนูหน้าแรก
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapterMenuHome(this, menuHome, menuHomeimageId));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent6);
                        break;

                }
            }
        });

    }

    //Calligraphy แนบฟอนต์
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

}
