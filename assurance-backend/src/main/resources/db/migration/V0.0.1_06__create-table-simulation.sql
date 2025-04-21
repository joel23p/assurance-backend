CREATE SEQUENCE simulation_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE simulation (
                            id int8 NOT NULL PRIMARY KEY,
                            created_at TIMESTAMP WITHOUT TIME ZONE,
                            updated_at TIMESTAMP WITHOUT TIME ZONE,
                            quotereference VARCHAR(255),
                            produit_assurance_id int8,
                            prix_initial_vehicule BIGINT,
                            valeur_actuelle_vehicule BIGINT,
                            puissance_fiscale BIGINT,
                            prix_total BIGINT,
                            date_fin_validite TIMESTAMP WITHOUT TIME ZONE,
                            CONSTRAINT simulation_uk UNIQUE (quotereference),
                            CONSTRAINT produit_assurance_fk FOREIGN KEY (produit_assurance_id) REFERENCES produit_assurance(id)
);

ALTER TABLE simulation ALTER COLUMN id SET DEFAULT nextval('simulation_id_seq');
