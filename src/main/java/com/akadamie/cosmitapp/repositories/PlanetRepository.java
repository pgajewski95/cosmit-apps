package com.akadamie.cosmitapp.repositories;

import com.akadamie.cosmitapp.Models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

       @Query(value = "delete from planets where planet_name = ?1", nativeQuery = true) //SQL

        @Transactional
        @Modifying
        void deleteByPlanetName(String planetName);

        @Query(value = "select p from Planet p where p.planetName = ?1")
        Optional<Planet> findByPlanetName(String string);

        @Query(value = "select p from Planet p where p.distanceFromSun = ?1 order by p.distanceFromSun")
        List<Planet> findPlanetsByDistanceFromSun(Long distance);
}
