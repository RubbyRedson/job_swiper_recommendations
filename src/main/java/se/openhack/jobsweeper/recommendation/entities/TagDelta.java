package se.openhack.jobsweeper.recommendation.entities;

/**
 * Created by Nick on 12/2/2016.
 */
public class TagDelta {
    private String name;
    private int delta;

    public TagDelta(String name, int delta) {
        this.name = name;
        this.delta = delta;
    }

    public TagDelta() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
}
