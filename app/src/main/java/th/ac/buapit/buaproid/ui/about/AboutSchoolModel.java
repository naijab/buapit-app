package th.ac.buapit.buaproid.ui.about;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutSchoolModel {

    @SerializedName("school_name")
    @Expose
    private String nameSchool;

    @SerializedName("school_address")
    @Expose
    private String addressSchool;

    @SerializedName("school_tel")
    @Expose
    private String telSchool;

    @SerializedName("school_history")
    @Expose
    private String historySchool;

    @SerializedName("school_tel2")
    @Expose
    private String tel2School;

    @SerializedName("school_under")
    @Expose
    private String underSchool;

    @SerializedName("school_website")
    @Expose
    private String websiteSchool;

    @SerializedName("school_direct")
    @Expose
    private String directSchool;

    @SerializedName("school_subject")
    @Expose
    private String subjectSchool;

    @SerializedName("school_total")
    @Expose
    private String totalSchool;

    @SerializedName("school_total1")
    @Expose
    private String total1School;

    @SerializedName("school_logo")
    @Expose
    private String logoSchool;

    @SerializedName("school_gps")
    @Expose
    private String gpsSchool;

    public AboutSchoolModel(String nameSchool, String addressSchool, String telSchool, String historySchool, String tel2School, String underSchool, String websiteSchool, String directSchool, String subjectSchool, String totalSchool, String total1School, String logoSchool, String gpsSchool) {
        this.nameSchool = nameSchool;
        this.addressSchool = addressSchool;
        this.telSchool = telSchool;
        this.historySchool = historySchool;
        this.tel2School = tel2School;
        this.underSchool = underSchool;
        this.websiteSchool = websiteSchool;
        this.directSchool = directSchool;
        this.subjectSchool = subjectSchool;
        this.totalSchool = totalSchool;
        this.total1School = total1School;
        this.logoSchool = logoSchool;
        this.gpsSchool = gpsSchool;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public String getAddressSchool() {
        return addressSchool;
    }

    public void setAddressSchool(String addressSchool) {
        this.addressSchool = addressSchool;
    }

    public String getTelSchool() {
        return telSchool;
    }

    public void setTelSchool(String telSchool) {
        this.telSchool = telSchool;
    }

    public String getHistorySchool() {
        return historySchool;
    }

    public void setHistorySchool(String historySchool) {
        this.historySchool = historySchool;
    }

    public String getTel2School() {
        return tel2School;
    }

    public void setTel2School(String tel2School) {
        this.tel2School = tel2School;
    }

    public String getUnderSchool() {
        return underSchool;
    }

    public void setUnderSchool(String underSchool) {
        this.underSchool = underSchool;
    }

    public String getWebsiteSchool() {
        return websiteSchool;
    }

    public void setWebsiteSchool(String websiteSchool) {
        this.websiteSchool = websiteSchool;
    }

    public String getDirectSchool() {
        return directSchool;
    }

    public void setDirectSchool(String directSchool) {
        this.directSchool = directSchool;
    }

    public String getSubjectSchool() {
        return subjectSchool;
    }

    public void setSubjectSchool(String subjectSchool) {
        this.subjectSchool = subjectSchool;
    }

    public String getTotalSchool() {
        return totalSchool;
    }

    public void setTotalSchool(String totalSchool) {
        this.totalSchool = totalSchool;
    }

    public String getTotal1School() {
        return total1School;
    }

    public void setTotal1School(String total1School) {
        this.total1School = total1School;
    }

    public String getLogoSchool() {
        return logoSchool;
    }

    public void setLogoSchool(String logoSchool) {
        this.logoSchool = logoSchool;
    }

    public String getGpsSchool() {
        return gpsSchool;
    }

    public void setGpsSchool(String gpsSchool) {
        this.gpsSchool = gpsSchool;
    }
}
