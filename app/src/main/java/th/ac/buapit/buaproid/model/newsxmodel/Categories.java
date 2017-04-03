package th.ac.buapit.buaproid.model.newsxmodel;


public class Categories {

    private String id;
    private String title;
    private String description;
    private String post_count;
    private String parent;

    private String slug;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPost_count() {
        return post_count;
    }

    public void setPost_count(String post_count) {
        this.post_count = post_count;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", title = " + title + ", description = " + description + ", post_count = " + post_count + ", parent = " + parent + ", slug = " + slug + "]";
    }
}

