package se.openhack.jobsweeper.recommendation.responses;

import se.openhack.jobsweeper.recommendation.entities.JobRecommendation;

import java.util.List;

/**
 * Created by Nick on 12/2/2016.
 */
public class JobRecommendationResponse {
    private List<JobRecommendation> recommendations;

    public JobRecommendationResponse(List<JobRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public JobRecommendationResponse() {
    }

    public List<JobRecommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<JobRecommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
