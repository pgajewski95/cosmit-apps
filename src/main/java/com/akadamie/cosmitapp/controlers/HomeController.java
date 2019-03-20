package com.akadamie.cosmitapp.controlers;


import com.akadamie.cosmitapp.Models.dtos.PlanetDto;
import com.akadamie.cosmitapp.services.PlanetService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private PlanetService planetService;

    public HomeController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "loged is as: " + context.getAuthentication()
                .getName());
        model.addAttribute("planets", planetService.getPlanetsDto());

        return "index";

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/planets")
    public String getPlanetPage(Model model) {
        model.addAttribute("planets", planetService.getPlanetsDto());
        return "planets";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    @GetMapping("/delete")
    public String deletePlanet(@RequestParam(value = "planet") String planetName) {
        planetService.deletePlanet(planetName);
        return "redirect:/planets";
    }

    @PostMapping("/add")
    public String addPlanet(@ModelAttribute PlanetDto planetDto){
        planetService.addPlanet(planetDto);
        return "redirect:/planets";
    }
}
