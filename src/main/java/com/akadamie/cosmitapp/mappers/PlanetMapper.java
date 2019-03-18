package com.akadamie.cosmitapp.mappers;



import com.akadamie.cosmitapp.Models.Planet;
import com.akadamie.cosmitapp.Models.dtos.PlanetDto;
import com.akadamie.cosmitapp.commons.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDto> {
    @Override
    public PlanetDto map(Planet f) {
        return PlanetDto.builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .lengthOfYear(f.getLengthOfYear())
                .planetImage(f.getPlanetImage())
                .planetInfo(f.getPlanetInfo())
                .planetType(f.getPlanetType())
                .build();
    }
}
