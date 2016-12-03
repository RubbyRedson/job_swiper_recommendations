package se.openhack.jobsweeper.recommendation.requests;

import se.openhack.jobsweeper.recommendation.entities.TagDelta;

import java.util.List;

/**
 * Created by Nick on 12/2/2016.
 */
public class UserPreferencesUpdateBody {
    private int userId;
    private List<TagDelta> tagDelta;

    public UserPreferencesUpdateBody(int userId, List<TagDelta>  tagDelta) {
        this.userId = userId;
        this.tagDelta = tagDelta;
    }

    public UserPreferencesUpdateBody() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<TagDelta> getTagDeltas() {
        return tagDelta;
    }

    public void setTagDelta(List<TagDelta> tagDelta) {
        this.tagDelta = tagDelta;
    }
}
