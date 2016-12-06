package th.ac.buapit.app.App;

import android.app.Application;

import th.ac.buapit.app.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // initalize Calligraphy
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/base1.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
