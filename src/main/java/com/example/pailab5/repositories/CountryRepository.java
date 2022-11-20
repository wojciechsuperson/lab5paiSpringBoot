package com.example.pailab5.repositories;

import com.example.pailab5.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByContinent(String continent);
    List<Country> findByPopulationBetween(BigDecimal min, BigDecimal max);
    List<Country> findByAreaBetween(BigDecimal min, BigDecimal max);

}
