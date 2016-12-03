package se.openhack.jobsweeper.recommendation.responses;

import java.util.List;

public class JobApplicants {
    private int jobId;
    private List<Integer> userIds;

    public JobApplicants() {
    }

    public JobApplicants(int jobId, List<Integer> userIds) {
        this.jobId = jobId;
        this.userIds = userIds;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }
}
