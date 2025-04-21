package com.example.assurance.Domain;


import jakarta.persistence.*;
import static com.example.assurance.Socle.JpaConstants.ID;
import static com.example.assurance.Socle.JpaConstants.SEQ;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = Vehicule.TABLE_NAME)
@Access(AccessType.FIELD)
public class Vehicule {
    public static final String TABLE_NAME = "vehicule";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "date_premiere_mise_circulation")
    private LocalDate datePremiereMiseCirculation;

    @Column(name = "numero_immatriculation")
    private String numeroImmatriculation;

    @Column(name = "couleur")
    private String couleur;

    @Column(name = "nombre_sieges")
    private Integer nombreSieges;

    @Column(name = "nombre_portes")
    private Integer nombrePortes;

    @ManyToOne
    @JoinColumn(name = CategorieVehicule.TABLE_ID)
    private CategorieVehicule categorieVehicule;

    public Vehicule() {}

    public Vehicule(LocalDate datePremiereMiseCirculation, String numeroImmatriculation, String couleur, Integer nombreSieges, Integer nombrePortes, CategorieVehicule categorieVehicule) {
        this.datePremiereMiseCirculation = datePremiereMiseCirculation;
        this.numeroImmatriculation = numeroImmatriculation;
        this.couleur = couleur;
        this.nombreSieges = nombreSieges;
        this.nombrePortes = nombrePortes;
        this.categorieVehicule = categorieVehicule;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDatePremiereMiseCirculation() {
        return datePremiereMiseCirculation;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public String getCouleur() {
        return couleur;
    }

    public Integer getNombreSieges() {
        return nombreSieges;
    }

    public Integer getNombrePortes() {
        return nombrePortes;
    }

    public CategorieVehicule getCategorieVehicule() {
        return categorieVehicule;
    }
}
