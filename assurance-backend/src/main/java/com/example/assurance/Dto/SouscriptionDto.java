package com.example.assurance.Dto;


import com.example.assurance.Domain.Client;
import com.example.assurance.Domain.Souscription;
import com.example.assurance.Domain.Vehicule;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SouscriptionDto {
    private String numeroImmatriculation;
    private String couleur;
    private Integer nbPortes;
    private Integer nbSieges;
    private Long categorieId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate datePremiereCirculation;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private String ville;
    private String numeroIdentite;

    public SouscriptionDto() {}

    public SouscriptionDto(Souscription souscription) {
        Client client = souscription.getClient();
        Vehicule vehicule = souscription.getVehicule();
        this.nom = client.getNom();
        this.prenom = client.getPrenoms();
        this.telephone = client.getTelephone();
        this.email = client.getEmail();
        this.adresse = client.getAdresse();
        this.ville = client.getVille();
        this.numeroIdentite = client.getNumeroCarteIdentite();
        this.numeroImmatriculation = vehicule.getNumeroImmatriculation();
        this.couleur = vehicule.getCouleur();
        this.nbPortes = vehicule.getNombrePortes();
        this.nbSieges = vehicule.getNombreSieges();
        this.categorieId = vehicule.getCategorieVehicule().getId();
        this.datePremiereCirculation = vehicule.getDatePremiereMiseCirculation();
    }

    public String getNumeroImmatriculation() { return numeroImmatriculation; }

    public String getCouleur() { return couleur; }

    public Integer getNbPortes() { return nbPortes; }

    public Integer getNbSieges() { return nbSieges; }

    public Long getCategorieId() { return categorieId; }

    public LocalDate getDatePremiereCirculation() { return datePremiereCirculation; }

    public String getNom() { return nom; }

    public String getPrenom() { return prenom; }

    public String getTelephone() { return telephone; }

    public String getEmail() { return email; }

    public String getAdresse() { return adresse; }

    public String getVille() { return ville; }

    public String getNumeroIdentite() { return numeroIdentite; }
}
