package se.openhack.jobsweeper.recommendation.responses;

public class JobStats {
    private int jobId;
    private int likes;
    private int dislikes;

    public JobStats(int employerId, int likes, int dislikes) {
        this.jobId = employerId;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public JobStats() {
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
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
