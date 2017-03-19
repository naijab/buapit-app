package th.ac.buapit.buaproid.model.realmobject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NewsRealmModel extends RealmObject {


    @PrimaryKey
    private int RealmNewsID;

    private String RealmNewsTitle;
    private String RealmNewsContent;
    private String RealmNewsImage;

    public int getRealmNewsID() {
        return RealmNewsID;
    }

    public void setRealmNewsID(int realmNewsID) {
        this.RealmNewsID = realmNewsID;
    }

    public String getRealmNewsTitle() {
        return RealmNewsTitle;
    }

    public void setRealmNewsTitle(String realmNewsTitle) {
        this.RealmNewsTitle = realmNewsTitle;
    }

    public String getRealmNewsContent() {
        return RealmNewsContent;
    }

    public void setRealmNewsContent(String realmNewsContent) {
        this.RealmNewsContent = realmNewsContent;
    }

    public String getRealmNewsImage() {
        return RealmNewsImage;
    }

    public void setRealmNewsImage(String realmNewsImage) {
        this.RealmNewsImage = realmNewsImage;
    }
}
