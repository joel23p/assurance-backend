package com.example.assurance.Dto;


import com.example.assurance.Domain.ProduitAssurance;

public class ProduitAssuranceDto {
    private Long id;
    private String nomProduit;
    private String garantiesIncluses;

    public ProduitAssuranceDto() {}

    public ProduitAssuranceDto(ProduitAssurance produitAssurance) {
        this.nomProduit = produitAssurance.getNomProduit();
        this.garantiesIncluses = produitAssurance.getGarantiesIncluses();
    }

    public ProduitAssuranceDto(Long id, String nomProduit, String garantiesIncluses) {
        this.id = id;
        this.nomProduit = nomProduit;
        this.garantiesIncluses = garantiesIncluses;
    }

    public Long getId(){return  id;}
    public String getNomProduit() { return nomProduit; }
    public String getGarantiesIncluses() { return garantiesIncluses; }
}