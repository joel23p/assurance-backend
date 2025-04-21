package com.example.assurance.Domain;

import jakarta.persistence.*;

import static com.example.assurance.Socle.JpaConstants.ID;
import static com.example.assurance.Socle.JpaConstants.SEQ;


@Entity
@Table(name = Client.TABLE_NAME)
@Access(AccessType.FIELD)
public class Client {
    public static final String TABLE_NAME = "client";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;


    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenoms")
    private String prenoms;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "ville")
    private String ville;

    @Column(name = "numero_carte_identite")
    private String numeroCarteIdentite;

    public Client() {}

    public Client(String nom, String prenoms, String telephone, String email, String adresse, String ville, String numeroCarteIdentite) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        this.numeroCarteIdentite = numeroCarteIdentite;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getNumeroCarteIdentite() {
        return numeroCarteIdentite;
    }

    public void setId(Long id) {
        this.id = id;
    }

}