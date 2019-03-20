package com.akadamie.cosmitapp.mappers;



import com.akadamie.cosmitapp.Models.Planet;
import com.akadamie.cosmitapp.Models.Tag;
import com.akadamie.cosmitapp.Models.dtos.PlanetDto;
import com.akadamie.cosmitapp.commons.swagger.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDto> {
    @Override
    public PlanetDto map(Planet f) {

        List<String> tags = f.getTags()
                .stream()
                .map(TagsToStringsList.INSTANCE)
                .collect(Collectors.toList());


        return PlanetDto.builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .lengthOfYear(f.getLengthOfYear())
                .planetImage(f.getPlanetImage())
                .planetInfo(f.getPlanetInfo())
                .planetType(f.getPlanetType())
                .tags(tags)
                .build();
    }

    @Override
    public Planet reverse(PlanetDto to) {
        return Planet.builder()
                .planetName(to.getPlanetName())
                .distanceFromSun(to.getDistanceFromSun())
                .oneWayLightTimeToTheSun(to.getOneWayLightTimeToTheSun())
                .lengthOfYear(to.getLengthOfYear())
                .planetImage(to.getPlanetImage())
                .planetInfo(to.getPlanetInfo())
                .planetType(to.getPlanetType())
                .build();
    }

    private enum TagsToStringsList implements Function<Tag, String> {
        INSTANCE;

        @Override
        public String apply(Tag tag) {
            return tag.getTitle();
        }
    }
}
