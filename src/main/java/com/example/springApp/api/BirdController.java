package com.example.springApp.api;

import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;
import com.example.springApp.propertyEditors.ConservationPropertyEditor;
import com.example.springApp.propertyEditors.ContinentPropertyEditor;
import com.example.springApp.propertyEditors.DietPropertyEditor;
import com.example.springApp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
@SessionAttributes("username")
public class BirdController {
    private final BirdService birdService;


    private final DietPropertyEditor dietPropertyEditor = new DietPropertyEditor();
    private final ContinentPropertyEditor continentPropertyEditor = new ContinentPropertyEditor();
    private final ConservationPropertyEditor conservationPropertyEditor = new ConservationPropertyEditor();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Diet.class, dietPropertyEditor);
        binder.registerCustomEditor(Continent.class, continentPropertyEditor);
        binder.registerCustomEditor(ConservationStatus.class, conservationPropertyEditor);
    }

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

    @GetMapping("create")
    public String showCreateBird() {
        return "create_bird";
    }

    @PostMapping("create")
    public String createBird(
            @RequestParam String name,
            @RequestParam String latinName,
            @RequestParam int wingspanCm,
            @RequestParam Diet diet,
            @RequestParam List<Continent> continents,
            @RequestParam ConservationStatus conservationStatus
            ) {
        return "create_bird";
    }
}
