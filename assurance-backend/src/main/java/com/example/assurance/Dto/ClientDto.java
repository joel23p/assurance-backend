package com.example.assurance.Dto;


import com.example.assurance.Domain.Client;

public class ClientDto {
    private String nom;
    private String prenoms;
    private String telephone;
    private String email;
    private String adresse;
    private String ville;
    private String numeroCarteIdentite;

    public ClientDto() {}

    public ClientDto(Client client) {
        this.nom = client.getNom();
        this.prenoms = client.getPrenoms();
        this.telephone = client.getTelephone();
        this.email = client.getEmail();
        this.adresse = client.getAdresse();
        this.ville = client.getVille();
        this.numeroCarteIdentite = client.getNumeroCarteIdentite();
    }



    public String getNom() { return nom; }
    public String getPrenoms() { return prenoms; }
    public String getTelephone() { return telephone; }
    public String getEmail() { return email; }
    public String getAdresse() { return adresse; }
    public String getVille() { return ville; }
    public String getNumeroCarteIdentite() { return numeroCarteIdentite; }
}