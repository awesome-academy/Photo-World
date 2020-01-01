package vn.tien.photo_world.data.model;

public class Photo {
    private String mId;
    private Author mAuthor;
    private String mCreatDay;
    private String mDescription;
    private PhotoUrl mUrls;
    private PhotoLink mLinks;

    public Photo(String id, Author author, String creatDay, String description, PhotoUrl urls, PhotoLink links) {
        mId = id;
        mAuthor = author;
        mCreatDay = creatDay;
        mDescription = description;
        mUrls = urls;
        mLinks = links;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Author getAuthor() {
        return mAuthor;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }

    public String getCreatDay() {
        return mCreatDay;
    }

    public void setCreatDay(String creatDay) {
        mCreatDay = creatDay;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public PhotoUrl getUrls() {
        return mUrls;
    }

    public void setUrls(PhotoUrl urls) {
        mUrls = urls;
    }

    public PhotoLink getLinks() {
        return mLinks;
    }

    public void setLinks(PhotoLink links) {
        mLinks = links;
    }
}
