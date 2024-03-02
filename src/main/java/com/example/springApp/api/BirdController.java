package com.example.springApp.api;

import com.example.springApp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Calendar;

@Controller
@SessionAttributes("username")
public class BirdController {
    private final BirdService birdService;

    @Autowired
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }
    @RequestMapping("/")
    public String index(ModelMap model) {
        var birds = birdService.getAllBirds();
        if (!birds.isEmpty()) {
            var day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            var randomIndex = day % birds.size();
            model.addAttribute("birdOfTheDay", birds.get(randomIndex));
        }

        return "index";
    }

    @RequestMapping("all")
    public String allBirds(ModelMap model) {
        var birds = birdService.getAllBirds();
        model.addAttribute("birds", birds);
        return "all_birds";
    }
}
