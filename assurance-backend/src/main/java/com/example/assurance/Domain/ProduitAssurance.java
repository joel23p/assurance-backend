package com.example.assurance.Domain;

import jakarta.persistence.*;

import static com.example.assurance.Socle.JpaConstants.ID;
import static com.example.assurance.Socle.JpaConstants.SEQ;

@Entity
@Table(name = ProduitAssurance.TABLE_NAME)
@Access(AccessType.FIELD)
public class ProduitAssurance  {
    public static final String TABLE_NAME = "produit_assurance";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;
    @Column(name = "nom_produit")
    private String nomProduit;

    @Column(name = "garanties_incluses")
    private String garantiesIncluses;

    @Column(name = "categories_eligibles")
    private String categoriesEligibles;

    public ProduitAssurance() {}

    public ProduitAssurance(String nomProduit, String garantiesIncluses, String categoriesEligibles) {
        this.nomProduit = nomProduit;
        this.garantiesIncluses = garantiesIncluses;
        this.categoriesEligibles = categoriesEligibles;
    }

    public Long getId() {
        return id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getGarantiesIncluses() {
        return garantiesIncluses;
    }

    public String getCategoriesEligibles() {
        return categoriesEligibles;
    }
}