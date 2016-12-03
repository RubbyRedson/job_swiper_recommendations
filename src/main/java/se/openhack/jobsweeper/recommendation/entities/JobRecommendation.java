package se.openhack.jobsweeper.recommendation.entities;

import java.util.List;

/**
 * Created by Nick on 12/2/2016.
 */
public class JobRecommendation {
    private int id;
    private List<Tag> tags;

    public JobRecommendation(int id, List<Tag> tags) {
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags( List<Tag>tags) {
        this.tags = tags;
    }
}
