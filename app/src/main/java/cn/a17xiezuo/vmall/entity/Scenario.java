package cn.a17xiezuo.vmall.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wuyunan on 16/6/30.
 */
public class Scenario {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("oid")
    @Expose
    private String oid;
    @SerializedName("total_follows")
    @Expose
    private String totalFollows;
    @SerializedName("binded_tag_oid")
    @Expose
    private String bindedTagOid;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("desc")
    @Expose
    private String desc;

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
     * @return The bindedTagOid
     */
    public String getBindedTagOid() {
        return bindedTagOid;
    }

    /**
     * @param bindedTagOid The binded_tag_oid
     */
    public void setBindedTagOid(String bindedTagOid) {
        this.bindedTagOid = bindedTagOid;
    }

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
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
