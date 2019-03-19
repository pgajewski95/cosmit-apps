package com.akadamie.cosmitapp.controlers;


import com.akadamie.cosmitapp.Models.Planet;
import com.akadamie.cosmitapp.Models.dtos.PlanetDto;
import com.akadamie.cosmitapp.services.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PlanetController {
    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    /*

    DAO

     */
    @GetMapping("/planets")
    public List<Planet> getPlanets() {
        planetService.getPlanets();
        return planetService.getPlanets();

    }

    /*

    DTO

     */
    /*
    Sposob 1
    @GetMapping("/dto/planets")
    public List<PlanetDto> getPlanetsDto() {
        planetService.getPlanets();
        return planetService.getPlanetsDto();

    }

    @GetMapping("/dto/planets/{distance}")
    public List<PlanetDto> getPlanetByDistance(@PathVariable Long distance){
        return planetService.getPlanetsByDistanceFromSun(distance);
    }*/
  // Sposob 2
    @GetMapping("/dto/plantes")
    public List<PlanetDto> getPlanetByDistance(@RequestParam(required = false) Long distance) {
        if (distance !=null && distance >0) {
            return planetService.getPlanetsByDistanceFromSun(distance);
        }
        return planetService.getPlanetsDto();
    }


    @PostMapping("/dto/planets")
    public Planet addPlanet(@RequestBody PlanetDto planetDto) {
        return planetService.addPlanet(planetDto);


    }
    @PutMapping("/dto/planets")
    public void updatePlanet(@RequestBody PlanetDto planetDto){
        planetService.updatePlanet(planetDto);
    }
    @DeleteMapping("/dto/planets/{name}")
    public void deletePlanet(@PathVariable String planetName){
        planetService.deletePlanet(planetName);
    }
}
