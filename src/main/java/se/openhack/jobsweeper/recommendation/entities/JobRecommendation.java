package se.openhack.jobsweeper.recommendation.entities;

/**
 * Created by Nick on 12/2/2016.
 */
public class JobRecommendation {
    private int id;
    private Tag[] tags;

    public JobRecommendation(int id, Tag[] tags) {
        this.id = id;
        this.tags = tags;
    }

    public JobRecommendation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
}
