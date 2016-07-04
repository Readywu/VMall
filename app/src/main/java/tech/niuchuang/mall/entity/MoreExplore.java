package tech.niuchuang.mall.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyunan on 16/6/30.
 */
public class MoreExplore {

    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("images_list")
    @Expose
    private List<String> imagesList = new ArrayList<String>();
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The imagesList
     */
    public List<String> getImagesList() {
        return imagesList;
    }

    /**
     * @param imagesList The images_list
     */
    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
