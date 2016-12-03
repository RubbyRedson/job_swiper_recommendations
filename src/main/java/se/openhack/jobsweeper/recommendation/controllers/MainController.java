package se.openhack.jobsweeper.recommendation.controllers;

import org.springframework.web.bind.annotation.*;
import se.openhack.jobsweeper.recommendation.database.DatabaseClient;
import se.openhack.jobsweeper.recommendation.entities.Job;
import se.openhack.jobsweeper.recommendation.entities.TagDelta;
import se.openhack.jobsweeper.recommendation.entities.TagWithCounter;
import se.openhack.jobsweeper.recommendation.requests.UserPreferencesUpdateBody;
import se.openhack.jobsweeper.recommendation.responses.JobRecommendationResponse;

import javax.annotation.PreDestroy;
import java.util.List;

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
    public Object createUser(@RequestParam(value="userId") int id, @RequestParam(value="name") String name) {
        db.createUser(id, name);
        return "OK";
    }

    @RequestMapping(path = {"/insert_new_jobs"},
            method = RequestMethod.POST)
    public Object insertNewJobs(@RequestBody List<Job> input) {
        db.insertNewJobs(input);
        return "OK";
    }

    @RequestMapping(path = "/get_tags_for_user",
            method = RequestMethod.GET)
    public @ResponseBody
    List<TagWithCounter> getTagsForUser(@RequestParam(value="userId") int id) {
        return db.getTagsForUser(id);
    }

    @PreDestroy
    public void cleanup() {
        db.close();
    }
}
