package se.openhack.jobsweeper.recommendation.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.openhack.jobsweeper.recommendation.entities.*;

@RestController
public class MainController {

    @RequestMapping(path = "/get_job_recs",
            method = RequestMethod.GET)
    public @ResponseBody JobRecommendationResponse getJobRecs(@RequestParam(value="userId") int id,
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

        Tag[] firstTags = new Tag[3];
        int firstId = 6965402;
        firstTags[0] = hR;
        firstTags[1] = network;
        firstTags[2] = recruitment;
        JobRecommendation first = new JobRecommendation(firstId, firstTags);


        Tag[] secTags = new Tag[4];
        secTags[0] = java;
        secTags[1] = agile;
        secTags[2] = docker;
        secTags[3] = security;
        int secondId = 20662027;
        JobRecommendation second = new JobRecommendation(secondId, secTags);

        JobRecommendation[] recs = new JobRecommendation[2];
        recs[0] = first;
        recs[1] = second;
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
}
