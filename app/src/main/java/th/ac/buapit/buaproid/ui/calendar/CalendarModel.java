package th.ac.buapit.buaproid.ui.calendar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalendarModel {

    @SerializedName("calendar_id")
    @Expose
    private Integer calendarId;

    @SerializedName("calendar_title")
    @Expose
    private String calendarTitle;

    @SerializedName("calendar_content")
    @Expose
    private String calendarContent;

    @SerializedName("calendar_date_start")
    @Expose
    private String calendarStart;

    @SerializedName("calendar_date_end")
    @Expose
    private String calendarEnd;

    @SerializedName("calendar_term")
    @Expose
    private String calendarTerm;

    @SerializedName("calendar_by")
    @Expose
    private Integer calendarBy;

    @SerializedName("calendar_by_user")
    @Expose
    private Integer calendarByUser;

    public CalendarModel(Integer calendarId, String calendarTitle, String calendarContent, String calendarStart, String calendarEnd, String calendarTerm, Integer calendarBy, Integer calendarByUser) {
        this.calendarId = calendarId;
        this.calendarTitle = calendarTitle;
        this.calendarContent = calendarContent;
        this.calendarStart = calendarStart;
        this.calendarEnd = calendarEnd;
        this.calendarTerm = calendarTerm;
        this.calendarBy = calendarBy;
        this.calendarByUser = calendarByUser;
    }

    public Integer getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Integer calendarId) {
        this.calendarId = calendarId;
    }

    public String getCalendarTitle() {
        return calendarTitle;
    }

    public void setCalendarTitle(String calendarTitle) {
        this.calendarTitle = calendarTitle;
    }

    public String getCalendarContent() {
        return calendarContent;
    }

    public void setCalendarContent(String calendarContent) {
        this.calendarContent = calendarContent;
    }

    public String getCalendarStart() {
        return calendarStart;
    }

    public void setCalendarStart(String calendarStart) {
        this.calendarStart = calendarStart;
    }

    public String getCalendarEnd() {
        return calendarEnd;
    }

    public void setCalendarEnd(String calendarEnd) {
        this.calendarEnd = calendarEnd;
    }

    public String getCalendarTerm() {
        return calendarTerm;
    }

    public void setCalendarTerm(String calendarTerm) {
        this.calendarTerm = calendarTerm;
    }

    public Integer getCalendarBy() {
        return calendarBy;
    }

    public void setCalendarBy(Integer calendarBy) {
        this.calendarBy = calendarBy;
    }

    public Integer getCalendarByUser() {
        return calendarByUser;
    }

    public void setCalendarByUser(Integer calendarByUser) {
        this.calendarByUser = calendarByUser;
    }
}
