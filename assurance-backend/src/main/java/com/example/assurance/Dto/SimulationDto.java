package com.example.assurance.Dto;


import com.example.assurance.Domain.Simulation;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class SimulationDto {
    private String quoteReference;
    private Long produitAssuranceId;
    private Long prixInitialVehicule;
    private Long valeurActuelleVehicule;
    private Long puissanceFiscale;
    private Long prixTotal;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateFinValidite;

    public SimulationDto() {}

    public SimulationDto(Simulation simulation) {
        this.quoteReference = simulation.getQuoteReference();
        this.produitAssuranceId = simulation.getProduitAssurance() != null ? simulation.getProduitAssurance().getId() : null;
        this.prixInitialVehicule = simulation.getPrixInitialVehicule();
        this.valeurActuelleVehicule = simulation.getValeurActuelleVehicule();
        this.puissanceFiscale = simulation.getPuissanceFiscale();
        this.prixTotal = simulation.getPrixTotal();
        this.dateFinValidite = simulation.getDateFinValidite();
    }


    public String getQuoteReference() { return quoteReference; }
    public Long getProduitAssuranceId() { return produitAssuranceId; }
    public Long getPrixInitialVehicule() { return prixInitialVehicule; }
    public Long getValeurActuelleVehicule() { return valeurActuelleVehicule; }
    public Long getPuissanceFiscale() { return puissanceFiscale; }
    public Long getPrixTotal() { return prixTotal; }
    public LocalDateTime getDateFinValidite() { return dateFinValidite; }
}
