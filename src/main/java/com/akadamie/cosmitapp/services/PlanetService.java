package com.akadamie.cosmitapp.services;

import com.akadamie.cosmitapp.Models.Planet;
import com.akadamie.cosmitapp.Models.dtos.PlanetDto;
import com.akadamie.cosmitapp.commons.Mapper;
import com.akadamie.cosmitapp.mappers.PlanetMapper;
import com.akadamie.cosmitapp.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;
    private PlanetMapper planetMapper;

    public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper) {
        this.planetRepository = planetRepository;
        this.planetMapper = planetMapper;
    }
/*

DAO
 */
    public List<Planet> getPlanets(){
        return planetRepository.findAll();
    }

    /*
    DTO
     */

    public List<PlanetDto> getPlanetsDto(){
//      Sposob 1.
//

//        List<PlanetDto> planetDtos = new ArrayList<>();
//        planetRepository.findAll()
//                .stream()
//                .map(p -> planetDtos.add(planetMapper.map(p)))
//                .collect(Collectors.toList());
        //
        //
       // return planetDtos;

        return planetRepository.findAll()
                .stream()
                .map(planetMapper::map)
                .collect(Collectors.toList());
    }

    public Planet addPlanet(PlanetDto planetDto){
        return planetRepository.save(planetMapper.reverse(planetDto));
    }

    public void deletePlanet(String planetName){
        planetRepository.deleteByPlanetName(planetName);
    }

    public void updatePlanet(PlanetDto planetDto) {
        planetRepository
                .findByPlanetName(planetDto.getPlanetName()).ifPresent(p -> {

            p.setDistanceFromSun(planetDto.getDistanceFromSun());
            p.setOneWayLightTimeToTheSun(planetDto.getOneWayLightTimeToTheSun());
            p.setLengthOfYear(planetDto.getLengthOfYear());
            p.setPlanetType(planetDto.getPlanetType());
            p.setPlanetInfo(planetDto.getPlanetInfo());
            p.setPlanetImage(planetDto.getPlanetImage());

            planetRepository.save(p);
        });

    }
       public List<PlanetDto> getPlanetsByDistanceFromSun(Long distance){
          return planetRepository
                  .findPlanetsByDistanceFromSun(distance)
                  .stream()
                  .map(planetMapper::map)
                  .collect(Collectors.toList());

        }




}
