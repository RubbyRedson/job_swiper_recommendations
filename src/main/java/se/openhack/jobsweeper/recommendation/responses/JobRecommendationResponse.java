package se.openhack.jobsweeper.recommendation.responses;

import se.openhack.jobsweeper.recommendation.entities.JobRecommendation;

/**
 * Created by Nick on 12/2/2016.
 */
public class JobRecommendationResponse {
    private JobRecommendation[] recommendations;

    public JobRecommendationResponse(JobRecommendation[] recommendations) {
        this.recommendations = recommendations;
    }

    public JobRecommendationResponse() {
    }

    public JobRecommendation[] getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(JobRecommendation[] recommendations) {
        this.recommendations = recommendations;
    }
}
