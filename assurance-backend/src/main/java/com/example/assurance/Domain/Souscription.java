package com.example.assurance.Domain;



import jakarta.persistence.*;
import static com.example.assurance.Socle.JpaConstants.ID;
import static com.example.assurance.Socle.JpaConstants.SEQ;
import java.time.LocalDateTime;

@Entity
@Table(name = Souscription.TABLE_NAME)
@Access(AccessType.FIELD)
public class Souscription {
    public static final String TABLE_NAME = "souscription";
    public static final String TABLE_ID = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "date_souscription")
    private LocalDateTime dateSouscription;

    @ManyToOne
    @JoinColumn(name = Client.TABLE_ID)
    private Client client;

    @ManyToOne
    @JoinColumn(name = Vehicule.TABLE_ID)
    private Vehicule vehicule;

    public Souscription() {}

    public Souscription(LocalDateTime dateSouscription, Client client, Vehicule vehicule) {
        this.dateSouscription = dateSouscription;
        this.client = client;
        this.vehicule = vehicule;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateSouscription() {
        return dateSouscription;
    }

    public Client getClient() {
        return client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }
}
