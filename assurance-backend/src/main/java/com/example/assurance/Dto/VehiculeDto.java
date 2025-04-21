package com.example.assurance.Dto;

import com.example.assurance.Domain.Vehicule;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VehiculeDto {
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate datePremiereMiseCirculation;
    private String numeroImmatriculation;
    private String couleur;
    private Integer nombreSieges;
    private Integer nombrePortes;
    private Long categorieVehiculeId;

    public VehiculeDto() {}

    public VehiculeDto(Vehicule vehicule) {
        this.datePremiereMiseCirculation = vehicule.getDatePremiereMiseCirculation();
        this.numeroImmatriculation = vehicule.getNumeroImmatriculation();
        this.couleur = vehicule.getCouleur();
        this.nombreSieges = vehicule.getNombreSieges();
        this.nombrePortes = vehicule.getNombrePortes();
        this.categorieVehiculeId = vehicule.getCategorieVehicule() != null ? vehicule.getCategorieVehicule().getId() : null;
    }



    public LocalDate getDatePremiereMiseCirculation() { return datePremiereMiseCirculation; }
    public String getNumeroImmatriculation() { return numeroImmatriculation; }
    public String getCouleur() { return couleur; }
    public Integer getNombreSieges() { return nombreSieges; }
    public Integer getNombrePortes() { return nombrePortes; }
    public Long getCategorieVehiculeId() { return categorieVehiculeId; }
}