package se.openhack.jobsweeper.recommendation.responses;

public class OverallEmployerStats {
    private int employerId;
    private int likes;
    private int dislikes;

    public OverallEmployerStats(int employerId, int likes, int dislikes) {
        this.employerId = employerId;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public OverallEmployerStats() {
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
