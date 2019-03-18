package com.akadamie.cosmitapp.controlers;


import com.akadamie.cosmitapp.services.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private PlanetService planetService;

    public HomeController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planets")
    public String homePage(Model model) {
        model.addAttribute("planets", planetService.getPlanetsDto());
        return "planets";
    }
}
