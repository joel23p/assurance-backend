package com.example.assurance.Domain;




import jakarta.persistence.*;
import static com.example.assurance.Socle.JpaConstants.ID;
import static com.example.assurance.Socle.JpaConstants.SEQ;
import java.time.LocalDateTime;

@Entity
@Table(name = Simulation.TABLE_NAME)
@Access(AccessType.FIELD)
public class Simulation {
    public static final String TABLE_NAME = "simulation";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "quotereference")
    private String quoteReference;

    @ManyToOne
    @JoinColumn(name = ProduitAssurance.TABLE_ID)
    private ProduitAssurance produitAssurance;

    @Column(name = "prix_initial_vehicule")
    private Long prixInitialVehicule;

    @Column(name = "valeur_actuelle_vehicule")
    private Long valeurActuelleVehicule;

    @Column(name = "puissance_fiscale")
    private Long puissanceFiscale;

    @Column(name = "prix_total")
    private Long prixTotal;

    @Column(name = "date_fin_validite")
    private LocalDateTime dateFinValidite;

    public Simulation() {}

    public Simulation(String quoteReference, ProduitAssurance produitAssurance, Long prixInitialVehicule, Long valeurActuelleVehicule, Long puissanceFiscale, Long prixTotal, LocalDateTime dateFinValidite) {
        this.quoteReference = quoteReference;
        this.produitAssurance = produitAssurance;
        this.prixInitialVehicule = prixInitialVehicule;
        this.valeurActuelleVehicule = valeurActuelleVehicule;
        this.puissanceFiscale = puissanceFiscale;
        this.prixTotal = prixTotal;
        this.dateFinValidite = dateFinValidite;
    }


    public Long getId() {
        return id;
    }

    public String getQuoteReference() {
        return quoteReference;
    }

    public ProduitAssurance getProduitAssurance() {
        return produitAssurance;
    }

    public Long getPrixInitialVehicule() {
        return prixInitialVehicule;
    }

    public Long getValeurActuelleVehicule() {
        return valeurActuelleVehicule;
    }

    public Long getPuissanceFiscale() {
        return puissanceFiscale;
    }

    public Long getPrixTotal() {
        return prixTotal;
    }

    public LocalDateTime getDateFinValidite() {
        return dateFinValidite;
    }
}