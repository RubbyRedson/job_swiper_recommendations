package se.openhack.jobsweeper.recommendation.entities;

import java.util.List;


public class Job {
    private int id;
    private String title;
    private List<Tag> tags;

    public Job(int id, String title, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.tags = tags;
    }

    public Job() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
