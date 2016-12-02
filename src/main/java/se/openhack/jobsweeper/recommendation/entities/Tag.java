package se.openhack.jobsweeper.recommendation.entities;

/**
 * Created by Nick on 12/2/2016.
 */
public class Tag {
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
