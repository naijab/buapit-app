package th.ac.buapit.buaproid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsModel {

    @SerializedName("news_id")
    @Expose
    private Integer newsId;

    @SerializedName("news_title")
    @Expose
    private String newsTitle;

    @SerializedName("news_img")
    @Expose
    private String newsImg;

    @SerializedName("news_content")
    @Expose
    private String newsContent;

    @SerializedName("news_type")
    @Expose
    private String newsType;

    @SerializedName("news_active")
    @Expose
    private Integer newsActive;

    @SerializedName("news_create")
    @Expose
    private String newsCreate;

    @SerializedName("news_modified")
    @Expose
    private String newsModified;

    @SerializedName("news_by")
    @Expose
    private Integer newsBy;

    @SerializedName("news_by_user")
    @Expose
    private String newsByUser;

    public NewsModel(Integer newsId, String newsTitle, String newsImg, String newsContent, String newsType, Integer newsActive, String newsCreate, String newsModified, Integer newsBy, String newsByUser) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsImg = newsImg;
        this.newsContent = newsContent;
        this.newsType = newsType;
        this.newsActive = newsActive;
        this.newsCreate = newsCreate;
        this.newsModified = newsModified;
        this.newsBy = newsBy;
        this.newsByUser = newsByUser;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsActive() {
        return newsActive;
    }

    public void setNewsActive(Integer newsActive) {
        this.newsActive = newsActive;
    }

    public String getNewsCreate() {
        return newsCreate;
    }

    public void setNewsCreate(String newsCreate) {
        this.newsCreate = newsCreate;
    }

    public String getNewsModified() {
        return newsModified;
    }

    public void setNewsModified(String newsModified) {
        this.newsModified = newsModified;
    }

    public Integer getNewsBy() {
        return newsBy;
    }

    public void setNewsBy(Integer newsBy) {
        this.newsBy = newsBy;
    }

    public String getNewsByUser() {
        return newsByUser;
    }

    public void setNewsByUser(String newsByUser) {
        this.newsByUser = newsByUser;
    }
}