package se.openhack.jobsweeper.recommendation.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.openhack.jobsweeper.recommendation.entities.JobRecommendation;
import se.openhack.jobsweeper.recommendation.entities.JobRecommendationResponse;
import se.openhack.jobsweeper.recommendation.entities.Tag;

@RestController
public class MainController {

    @RequestMapping(path = "/get_job_recs",
            method = RequestMethod.GET)
    public @ResponseBody JobRecommendationResponse getJobRecs(@RequestParam(value="userId") int id) {
        Tag java = new Tag("Java");
        Tag oop = new Tag("OOP");
        Tag cSharp = new Tag("C#");
        Tag programming = new Tag("Programming");

        Tag[] firstTags = new Tag[2];
        firstTags[0] = java;
        firstTags[1] = oop;
        JobRecommendation first = new JobRecommendation(1, firstTags);


        Tag[] secTags = new Tag[2];
        secTags[0] = cSharp;
        secTags[1] = programming;
        JobRecommendation second = new JobRecommendation(2, secTags);

        JobRecommendation[] recs = new JobRecommendation[2];
        recs[0] = first;
        recs[1] = second;
        JobRecommendationResponse response = new JobRecommendationResponse(recs);
        return response;
    }

//    @RequestMapping(path = {"/user/update"},
//            method = RequestMethod.POST)
//    public Object updateUser() {
//        return "redirect:/metrics";
//
//    }
}
