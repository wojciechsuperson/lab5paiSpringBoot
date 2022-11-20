package com.example.pailab5.repositories;

import com.example.pailab5.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    /*zwraca rekordy z wykonanymi lub nie wykonanymi już zadaniami*/
    List<Exercise>  findByWykonane(Boolean wykonane);
    /*zwraca rekordy zadań, których koszt    jest mniejszy niż zadany*/
    List<Exercise>  findByKosztLessThan(Double kosztMniejszyNiz);
    /*zwraca rekordy zadań,    których koszt należy do wskazanego przedziału wartości*/
    List<Exercise> findByKosztBetween(Double kosztOd, Double kosztDo);

}
