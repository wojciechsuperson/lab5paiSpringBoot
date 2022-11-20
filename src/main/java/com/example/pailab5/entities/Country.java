package com.example.pailab5.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Country {
    @GeneratedValue
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String continent;

    private BigDecimal population;

    private BigDecimal area;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
