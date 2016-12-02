package se.openhack.jobsweeper.recommendation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping(path = "/get_job_recs",
            method = RequestMethod.GET)
    public @ResponseBody String getJobRecs(@RequestParam(value="userId") int id) {

        return "user/profile";
    }

    @RequestMapping(path = {"/user/update"},
            method = RequestMethod.POST)
    public Object updateUser(Model model) {
        return "redirect:/metrics";

    }
}
