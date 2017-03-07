package th.ac.buapit.buaproid;

import android.app.Application;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class BuapitAppService extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //Setup Realm Database
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        //Setup Fabric.io
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);

        //Setup Calligraphy Custom Font
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/code2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }
}
