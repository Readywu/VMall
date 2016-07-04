package tech.niuchuang.mall.entity;

/**
 * Created by wuyunan on 16/6/29.
 */
public class ItemArticle {

    private String imageUrl;
    private String title;
    private String publishDate;
    private String source;
    private String readTimes;
    private String preview;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReadTimes() {
        return readTimes;
    }

    public void setReadTime(String readTimes) {
        this.readTimes = readTimes;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
