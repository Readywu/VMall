package cn.a17xiezuo.vmall.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;


public class Datum {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("events")
    @Expose
    private List<Event> events = new ArrayList<Event>();
    @SerializedName("more_explores")
    @Expose
    private List<MoreExplore> moreExplores = new ArrayList<MoreExplore>();
    @SerializedName("topic")
    @Expose
    private List<Topic> topic = new ArrayList<Topic>();
    @SerializedName("show_more")
    @Expose
    private Boolean showMore;
    @SerializedName("scenario")
    @Expose
    private List<Scenario> scenario = new ArrayList<Scenario>();
    @SerializedName("destination")
    @Expose
    private List<Destination> destination = new ArrayList<Destination>();
    @SerializedName("recommends")
    @Expose
    private List<Object> recommends = new ArrayList<Object>();
    @SerializedName("boards")
    @Expose
    private List<Object> boards = new ArrayList<Object>();
    @SerializedName("brands")
    @Expose
    private List<Object> brands = new ArrayList<Object>();

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
     * @return The events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * @param events The events
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * @return The moreExplores
     */
    public List<MoreExplore> getMoreExplores() {
        return moreExplores;
    }

    /**
     * @param moreExplores The more_explores
     */
    public void setMoreExplores(List<MoreExplore> moreExplores) {
        this.moreExplores = moreExplores;
    }

    /**
     * @return The topic
     */
    public List<Topic> getTopic() {
        return topic;
    }

    /**
     * @param topic The topic
     */
    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }

    /**
     * @return The showMore
     */
    public Boolean getShowMore() {
        return showMore;
    }

    /**
     * @param showMore The show_more
     */
    public void setShowMore(Boolean showMore) {
        this.showMore = showMore;
    }

    /**
     * @return The scenario
     */
    public List<Scenario> getScenario() {
        return scenario;
    }

    /**
     * @param scenario The scenario
     */
    public void setScenario(List<Scenario> scenario) {
        this.scenario = scenario;
    }

    /**
     * @return The destination
     */
    public List<Destination> getDestination() {
        return destination;
    }

    /**
     * @param destination The destination
     */
    public void setDestination(List<Destination> destination) {
        this.destination = destination;
    }

    /**
     * @return The recommends
     */
    public List<Object> getRecommends() {
        return recommends;
    }

    /**
     * @param recommends The recommends
     */
    public void setRecommends(List<Object> recommends) {
        this.recommends = recommends;
    }

    /**
     * @return The boards
     */
    public List<Object> getBoards() {
        return boards;
    }

    /**
     * @param boards The boards
     */
    public void setBoards(List<Object> boards) {
        this.boards = boards;
    }

    /**
     * @return The brands
     */
    public List<Object> getBrands() {
        return brands;
    }

    /**
     * @param brands The brands
     */
    public void setBrands(List<Object> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * @return
     */
    public int getListSize() {
        return 1 + this.destination.size() + this.topic.size();
    }
}
