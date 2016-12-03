package se.openhack.jobsweeper.recommendation.controllers;

import org.springframework.web.bind.annotation.*;
import se.openhack.jobsweeper.recommendation.database.DatabaseClient;
import se.openhack.jobsweeper.recommendation.entities.*;
import se.openhack.jobsweeper.recommendation.requests.UserPreferencesUpdateBody;
import se.openhack.jobsweeper.recommendation.responses.JobRecommendationResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    static DatabaseClient db = new DatabaseClient();

    @RequestMapping(path = "/get_job_recs",
            method = RequestMethod.GET)
    public @ResponseBody
    JobRecommendationResponse getJobRecs(@RequestParam(value="userId") int id,
                                         @RequestParam(value="recNumber") int recNumber) {
        Tag java = new Tag("Java");
        Tag oop = new Tag("OOP");
        Tag cSharp = new Tag("C#");
        Tag programming = new Tag("Programming");
        Tag network = new Tag("Network");
        Tag recruitment = new Tag("Recruitment");
        Tag hR = new Tag("Human Resource");
        Tag agile = new Tag("Agile");
        Tag docker = new Tag("Docker");
        Tag security = new Tag("Security");

        List<Tag> firstTags = new ArrayList<>();
        int firstId = 6965402;
        firstTags.add(network);
        firstTags.add(hR);
        firstTags.add(recruitment);
        JobRecommendation first = new JobRecommendation(firstId, firstTags);


        List<Tag> secTags = new ArrayList<>();
        secTags.add(java);
        secTags.add(agile);
        secTags.add(docker);
        secTags.add(security);
        int secondId = 20662027;
        JobRecommendation second = new JobRecommendation(secondId, secTags);

        List<JobRecommendation> recs =  new ArrayList<>();
        recs.add(first);
        recs.add(second);
        JobRecommendationResponse response = new JobRecommendationResponse(recs);
        return response;
    }

    @RequestMapping(path = {"/update_user_recommendations"},
            method = RequestMethod.POST)
    public Object updateUser(@RequestBody UserPreferencesUpdateBody input) {
        int userId = input.getUserId();
        for (TagDelta tagDelta : input.getTagDelta()) {
            //update tag for user with delta
            System.out.println(userId + " tag " + tagDelta.getName() + " delta " + tagDelta.getDelta());
        }
        return "OK";
    }

    @RequestMapping(path = {"/create_user"},
            method = RequestMethod.GET)
    public Object createUser(@RequestParam(value="userId") int id) {
        //create user
        return "OK";
    }
}
