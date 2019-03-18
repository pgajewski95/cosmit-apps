package com.akadamie.cosmitapp.controlers;


import com.akadamie.cosmitapp.Models.Planet;
import com.akadamie.cosmitapp.Models.dtos.PlanetDto;
import com.akadamie.cosmitapp.services.PlanetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PlanetController {
    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planets")
    public List<Planet> getPlanets() {
        planetService.getPlanets();
        return planetService.getPlanets();

    }
    @GetMapping("/dto/planets")
    public List<PlanetDto> getPlanetsDto() {
        planetService.getPlanets();
        return planetService.getPlanetsDto();

    }


}
