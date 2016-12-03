package se.openhack.jobsweeper.recommendation.requests;

import se.openhack.jobsweeper.recommendation.entities.TagDelta;

/**
 * Created by Nick on 12/2/2016.
 */
public class UserPreferencesUpdateBody {
    private int userId;
    private TagDelta tagDelta[];

    public UserPreferencesUpdateBody(int userId, TagDelta[] tagDelta) {
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

    public TagDelta[] getTagDelta() {
        return tagDelta;
    }

    public void setTagDelta(TagDelta[] tagDelta) {
        this.tagDelta = tagDelta;
    }
}
