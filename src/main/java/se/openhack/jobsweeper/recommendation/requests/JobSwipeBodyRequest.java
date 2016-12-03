package se.openhack.jobsweeper.recommendation.requests;

public class JobSwipeBodyRequest {
    private int userId;
    private int jobId;
    private boolean like;

    public JobSwipeBodyRequest() {
    }

    public JobSwipeBodyRequest(int userId, int jobId, boolean like) {
        this.userId = userId;
        this.jobId = jobId;
        this.like = like;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
