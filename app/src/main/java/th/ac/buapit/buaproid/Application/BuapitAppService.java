package th.ac.buapit.buaproid.Application;

import android.app.Application;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

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

    }
}
