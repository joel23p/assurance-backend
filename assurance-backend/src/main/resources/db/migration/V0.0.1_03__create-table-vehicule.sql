-- Table: vehicule
CREATE SEQUENCE vehicule_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE vehicule (
                          id int8 NOT NULL PRIMARY KEY,
                          created_at TIMESTAMP WITHOUT TIME ZONE,
                          updated_at TIMESTAMP WITHOUT TIME ZONE,
                          date_premiere_mise_circulation TIMESTAMP WITHOUT TIME ZONE,
                          numero_immatriculation VARCHAR(255) NOT NULL,
                          couleur VARCHAR(255),
                          nombre_sieges int NOT NULL,
                          nombre_portes int NOT NULL,
                          categorie_vehicule_id int8,
                          CONSTRAINT categorie_vehicule_fk FOREIGN KEY(categorie_vehicule_id) REFERENCES categorie_vehicule(id)
);

ALTER TABLE vehicule ALTER COLUMN id SET DEFAULT nextval('vehicule_id_seq');