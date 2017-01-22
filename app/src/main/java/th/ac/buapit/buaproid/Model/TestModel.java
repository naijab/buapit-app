package th.ac.buapit.buaproid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestModel {

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

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public TestModel withNewsId(Integer newsId) {
        this.newsId = newsId;
        return this;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public TestModel withNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
        return this;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public TestModel withNewsImg(String newsImg) {
        this.newsImg = newsImg;
        return this;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public TestModel withNewsContent(String newsContent) {
        this.newsContent = newsContent;
        return this;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public TestModel withNewsType(String newsType) {
        this.newsType = newsType;
        return this;
    }

    public Integer getNewsActive() {
        return newsActive;
    }

    public void setNewsActive(Integer newsActive) {
        this.newsActive = newsActive;
    }

    public TestModel withNewsActive(Integer newsActive) {
        this.newsActive = newsActive;
        return this;
    }

    public String getNewsCreate() {
        return newsCreate;
    }

    public void setNewsCreate(String newsCreate) {
        this.newsCreate = newsCreate;
    }

    public TestModel withNewsCreate(String newsCreate) {
        this.newsCreate = newsCreate;
        return this;
    }

    public String getNewsModified() {
        return newsModified;
    }

    public void setNewsModified(String newsModified) {
        this.newsModified = newsModified;
    }

    public TestModel withNewsModified(String newsModified) {
        this.newsModified = newsModified;
        return this;
    }

    public Integer getNewsBy() {
        return newsBy;
    }

    public void setNewsBy(Integer newsBy) {
        this.newsBy = newsBy;
    }

    public TestModel withNewsBy(Integer newsBy) {
        this.newsBy = newsBy;
        return this;
    }

    public String getNewsByUser() {
        return newsByUser;
    }

    public void setNewsByUser(String newsByUser) {
        this.newsByUser = newsByUser;
    }

    public TestModel withNewsByUser(String newsByUser) {
        this.newsByUser = newsByUser;
        return this;
    }

}