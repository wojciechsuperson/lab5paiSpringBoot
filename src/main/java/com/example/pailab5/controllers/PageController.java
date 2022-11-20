package com.example.pailab5.controllers;

import com.example.pailab5.entities.Exercise;
import com.example.pailab5.repositories.ExerciseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    public final ExerciseRepository rep;

    public PageController(ExerciseRepository rep) {
        this.rep = rep;
    }

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }

    @RequestMapping("/listaZadan")
    @ResponseBody
    public String listaZadan() {
        StringBuilder odp = new StringBuilder();
        for(Exercise i: rep.findAll()) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/generujZadania")
    @ResponseBody
    public String createExercises() {
        Exercise z;
        double k=1000;
        boolean wyk=false;
        for (int i=1;i<=10;i++){
            z = new Exercise();
            z.setNazwa("zadanie "+i);
            z.setOpis("Opis czynnosci do wykonania w zadaniu "+i);
            z.setKoszt(k);
            z.setWykonane(wyk);
            wyk=!wyk;
            k+=200.50;
            rep.save(z);
        }
        return "Wygenerowano!";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteExercise(@PathVariable String id) {
        Exercise exercise = new Exercise();
        exercise.setId(Long.parseLong(id));
        rep.delete(exercise);
        return "Usunięto zadanie o id: "+ id;
    }

    @RequestMapping("/koszt/{min}/{max}")
    @ResponseBody
    public String deleteExercise(@PathVariable String min, @PathVariable String max) {
        StringBuilder odp = new StringBuilder();
        for(Exercise i: rep.findByKosztBetween(Double.parseDouble(min), Double.parseDouble(max))) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/kosztMniejszyOd/{max}")
    @ResponseBody
    public String kosztMniejszyOd( @PathVariable String max) {
        StringBuilder odp = new StringBuilder();
        for(Exercise i: rep.findByKosztLessThan(Double.parseDouble(max))) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/wykonanieZadania/{wykonane}")
    @ResponseBody
    public String zadaniaWykonane(@PathVariable Boolean wykonane) {
        StringBuilder odp = new StringBuilder();
        for(Exercise i: rep.findByWykonane(wykonane)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

}
