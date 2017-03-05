package th.ac.buapit.buaproid;

import android.app.Application;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class BuapitAppService extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //Setup Fabric.io
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/code2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }
}
