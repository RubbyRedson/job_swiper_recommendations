package se.openhack.jobsweeper.recommendation.entities;

public class TagWithCounter {
    private String name;
    private int counter;

    public TagWithCounter(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public TagWithCounter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
