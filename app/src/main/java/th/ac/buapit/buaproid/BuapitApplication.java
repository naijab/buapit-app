package th.ac.buapit.buaproid;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.messaging.FirebaseMessaging;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class BuapitApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        initFirebaseMessage();
        initRealm();
        initFabric();
        initCalligraphy();

    }

    private void initFirebaseMessage() {
        FirebaseMessaging.getInstance().subscribeToTopic("News");
    }

    private void initCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/code2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    private void initFabric() {
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);
    }

    private void initRealm() {
        //Setup Realm Database
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
