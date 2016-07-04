package tech.niuchuang.mall.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wuyunan on 16/6/30.
 */
public class Destination {

    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("oid")
    @Expose
    private String oid;
    @SerializedName("total_follows")
    @Expose
    private String totalFollows;
    @SerializedName("name")
    @Expose
    private String name;

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
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return The oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid The oid
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return The totalFollows
     */
    public String getTotalFollows() {
        return totalFollows;
    }

    /**
     * @param totalFollows The total_follows
     */
    public void setTotalFollows(String totalFollows) {
        this.totalFollows = totalFollows;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
