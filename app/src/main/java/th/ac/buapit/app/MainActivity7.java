package th.ac.buapit.app;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity7 extends AppCompatActivity {

    Spinner mattayom, classroom;
    private ArrayList<String> dataMattayom = new ArrayList<String>();
    private ArrayList<String> dataClassroom = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        //Setup Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setup Spinner
        mattayom = (Spinner) findViewById(R.id.spin_add_permit_level);
        classroom = (Spinner) findViewById(R.id.spin_add_permit_class);

        //Create Spinner Data
        createMattayom();
        createClassroom();

        // Adapter Mattayom
        ArrayAdapter<String> adapterMattayom = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, dataMattayom);
        mattayom.setAdapter(adapterMattayom);

        // Adapter Classroom
        ArrayAdapter<String> adapterClassroom = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, dataClassroom);
        classroom.setAdapter(adapterClassroom);
    }

    private void createMattayom(){
        int i;
        for (i=1; i<7; i++){
            dataMattayom.add("ม."+i);
        }
    }

    private void createClassroom(){
        int i;
        for (i=1; i<16; i++){
            dataClassroom.add(""+i);
        }
    }

    //Calligraphy แนบฟอนต์
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

}
