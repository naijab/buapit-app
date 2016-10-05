package th.ac.buapit.app;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class CustomFont extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/superbold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}

