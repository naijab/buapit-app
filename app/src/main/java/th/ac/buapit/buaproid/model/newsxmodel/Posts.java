package th.ac.buapit.buaproid.model.newsxmodel;

public class Posts {

    private String comment_count;
    private String[] tags;
    private String status;
    private String excerpt;
    private String comment_status;
    private String type;
    private String date;
    private String url;
    private String modified;
    private String id;
    private String content;
    private Author author;
    private String title;
    private String slug;
    private Categories[] categories;
    private String[] attachments;
    private String[] comments;
    private String title_plain;

    public String getComment_count ()
    {
        return comment_count;
    }

    public void setComment_count (String comment_count)
    {
        this.comment_count = comment_count;
    }

    public String[] getTags ()
    {
        return tags;
    }

    public void setTags (String[] tags)
    {
        this.tags = tags;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getExcerpt ()
    {
        return excerpt;
    }

    public void setExcerpt (String excerpt)
    {
        this.excerpt = excerpt;
    }

    public String getComment_status ()
    {
        return comment_status;
    }

    public void setComment_status (String comment_status)
    {
        this.comment_status = comment_status;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public Author getAuthor ()
    {
        return author;
    }

    public void setAuthor (Author author)
    {
        this.author = author;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

    public Categories[] getCategories ()
    {
        return categories;
    }

    public void setCategories (Categories[] categories)
    {
        this.categories = categories;
    }

    public String[] getAttachments ()
    {
        return attachments;
    }

    public void setAttachments (String[] attachments)
    {
        this.attachments = attachments;
    }

    public String[] getComments ()
    {
        return comments;
    }

    public void setComments (String[] comments)
    {
        this.comments = comments;
    }

    public String getTitle_plain ()
    {
        return title_plain;
    }

    public void setTitle_plain (String title_plain)
    {
        this.title_plain = title_plain;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ comment_count = "+comment_count+", tags = "+tags+", status = "+status+", excerpt = "+excerpt+", comment_status = "+comment_status+", type = "+type+", date = "+date+", url = "+url+", modified = "+modified+", id = "+id+", content = "+content+", author = "+author+", title = "+title+", slug = "+slug+", categories = "+categories+", attachments = "+attachments+", comments = "+comments+", title_plain = "+title_plain+"]";
    }

}
