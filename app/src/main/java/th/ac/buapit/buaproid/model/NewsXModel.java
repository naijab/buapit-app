package th.ac.buapit.buaproid.model;

import th.ac.buapit.buaproid.model.newsxmodel.Posts;

public class NewsXModel {

    private String count;
    private String status;
    private String pages;
    private Posts[] posts;
    private String count_total;

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getPages ()
    {
        return pages;
    }

    public void setPages (String pages)
    {
        this.pages = pages;
    }

    public Posts[] getPosts ()
    {
        return posts;
    }

    public void setPosts (Posts[] posts)
    {
        this.posts = posts;
    }

    public String getCount_total ()
    {
        return count_total;
    }

    public void setCount_total (String count_total)
    {
        this.count_total = count_total;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [count = "+count+", status = "+status+", pages = "+pages+", posts = "+posts+", count_total = "+count_total+"]";
    }
}

