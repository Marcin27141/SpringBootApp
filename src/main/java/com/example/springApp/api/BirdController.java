package com.example.springApp.api;

import com.example.springApp.model.Bird;
import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;
import com.example.springApp.propertyEditors.ConservationPropertyEditor;
import com.example.springApp.propertyEditors.ContinentPropertyEditor;
import com.example.springApp.propertyEditors.DietPropertyEditor;
import com.example.springApp.service.BirdService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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
        //session.setAttribute("username", getLoggedInUsername());
        model.put("username", getLoggedInUsername());
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

    @GetMapping("{id}")
    public String getBirdById(@PathVariable("id") UUID id, ModelMap model) {
        var bird = birdService.getBirdById(id);
        if (bird.isEmpty())
            return "redirect:/notfound";
        model.addAttribute("bird", bird.get());
        return "show_bird";
    }

    @GetMapping("create")
    public String showCreateBird(ModelMap model) {
        model.put("bird", new Bird());
        return "create_bird";
    }

    @PostMapping("create")
    public String createBird(@Valid Bird bird, BindingResult result) {
        if (result.hasErrors()) {
            return "create_bird";
        }
        birdService.addBird(bird);
        return "redirect:all";
    }

//    @PostMapping( path = "/test")
//    public String test() {
//        birdService.addBird(new Bird());
//        return "redirect:all";
//    }

    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
