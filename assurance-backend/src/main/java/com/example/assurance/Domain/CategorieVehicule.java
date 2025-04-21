package com.example.assurance.Domain;

import jakarta.persistence.*;


import static com.example.assurance.Socle.JpaConstants.ID;
import static com.example.assurance.Socle.JpaConstants.SEQ;

@Entity
@Table(name = CategorieVehicule.TABLE_NAME)
@Access(AccessType.FIELD)
public class CategorieVehicule {
    public static final String TABLE_NAME = "categorie_vehicule";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;


    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "code")
    private Integer code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    public CategorieVehicule() {}

    public CategorieVehicule(Integer code, String libelle, String description) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Integer getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
