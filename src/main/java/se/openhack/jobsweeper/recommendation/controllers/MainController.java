package se.openhack.jobsweeper.recommendation.controllers;

import org.springframework.web.bind.annotation.*;
import se.openhack.jobsweeper.recommendation.database.DatabaseClient;
import se.openhack.jobsweeper.recommendation.requests.UserPreferencesUpdateBody;
import se.openhack.jobsweeper.recommendation.responses.JobRecommendationResponse;

import javax.annotation.PreDestroy;

@RestController
public class MainController {

    private DatabaseClient db = new DatabaseClient();

    @RequestMapping(path = "/get_job_recs",
            method = RequestMethod.GET)
    public @ResponseBody
    JobRecommendationResponse getJobRecs(@RequestParam(value="userId") int id,
                                         @RequestParam(value="recNumber") int recNumber) {
        return db.recommendJobs(id, recNumber);
    }

    @RequestMapping(path = {"/update_user_recommendations"},
            method = RequestMethod.POST)
    public Object updateUser(@RequestBody UserPreferencesUpdateBody input) {
        int userId = input.getUserId();
        db.updateTags(userId, input.getTagDeltas());
        return "OK";
    }

    @RequestMapping(path = {"/create_user"},
            method = RequestMethod.GET)
    public Object createUser(@RequestParam(value="userId") int id) {
        //create user
        return "OK";
    }

    @PreDestroy
    public void cleanup() {
        db.close();
    }
}
