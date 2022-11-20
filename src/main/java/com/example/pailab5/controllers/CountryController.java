package com.example.pailab5.controllers;

import com.example.pailab5.entities.Country;
import com.example.pailab5.repositories.CountryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class CountryController {

    public final CountryRepository rep;

    public CountryController(CountryRepository rep) {
        this.rep = rep;
    }

    @RequestMapping("/listaKrajow")
    @ResponseBody
    public String listaZadan() {
        StringBuilder odp = new StringBuilder();
        for(Country i: rep.findAll()) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/generujKraje")
    @ResponseBody
    public String createExercises() {
        Country kraj;
        BigDecimal k= BigDecimal.valueOf(1000);
        boolean wyk=false;
        for (int i=1;i<=40;i++){
            kraj = new Country();
            kraj.setName("Kraj_"+i);
            if(i%3 == 0) {
                kraj.setContinent("Ameryka");
            } else if(i%3 == 1) {
                kraj.setContinent("Europa");
            } else if(i%3 == 2) {
                kraj.setContinent("Azja");
            }
            kraj.setArea(k);
            kraj.setPopulation(k.multiply(BigDecimal.valueOf(1000)));
            k = k.add(BigDecimal.valueOf(100));
            rep.save(kraj);
        }
        return "Wygenerowano!";
    }

    @RequestMapping("deleteCountry/{id}")
    @ResponseBody
    public String deleteExercise(@PathVariable String id) {
        Country country = new Country();
        country.setId(Long.parseLong(id));
        rep.delete(country);
        return "Usunięto kraj o id: "+ id;
    }

    @RequestMapping("/krajePowierzchniaPomiedzy/{min}/{max}")
    @ResponseBody
    public String krajePowierzchniaPomiedzy(@PathVariable String min, @PathVariable String max) {
        StringBuilder odp = new StringBuilder();
        for(Country i: rep.findByAreaBetween(BigDecimal.valueOf(Double.parseDouble(min)), BigDecimal.valueOf(Double.parseDouble(max)))) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/krajeLudnoscPomiedzy/{min}/{max}")
    @ResponseBody
    public String krajeLudnoscPomiedzy(@PathVariable String min, @PathVariable String max) {
        StringBuilder odp = new StringBuilder();
        for(Country i: rep.findByPopulationBetween(BigDecimal.valueOf(Double.parseDouble(min)), BigDecimal.valueOf(Double.parseDouble(max)))) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/krajeKontynent/{continent}")
    @ResponseBody
    public String zadaniaWykonane(@PathVariable String continent) {
        StringBuilder odp = new StringBuilder();
        for(Country i: rep.findByContinent(continent)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

}
