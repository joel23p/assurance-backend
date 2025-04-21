package com.example.assurance.Dto;

public class CategorieVehiculeDto {
    private Long id;
    private Long code;
    private String libelle;
    private String description;

    public CategorieVehiculeDto(Long id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }
    public Long getId() { return id; }
    public Long getCode() { return code; }
    public String getLibelle() { return libelle; }
    public String getDescription() { return description; }
}


