package com.example.pailab5.entities;

import javax.persistence.*;

@Entity
public class Exercise {
    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String nazwa;

    @Column
    @Lob
    private String opis;
    @Column
    private Double koszt;
    @Column
    private Boolean wykonane=false;

    public Exercise() {
        this.koszt = 2000.0;
        this.nazwa="Zadanie";
        this.opis="Zadanie do wykonania";
    }
    //nadpisana metoda toString
    @Override
    public String toString() {
        return "Encja Zadanie{ id=" + id + ", " + nazwa + ", " +
                opis + ", koszt=" + koszt + ", wykonane=" + wykonane +
                "}";
    }
    //dodaj metody get i set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getKoszt() {
        return koszt;
    }

    public void setKoszt(Double koszt) {
        this.koszt = koszt;
    }

    public Boolean getWykonane() {
        return wykonane;
    }

    public void setWykonane(Boolean wykonane) {
        this.wykonane = wykonane;
    }
}
