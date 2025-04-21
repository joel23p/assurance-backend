-- Table: categorie_vehicule
CREATE SEQUENCE categorie_vehicule_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE categorie_vehicule (
    id int8 NOT NULL PRIMARY KEY,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    code int NOT NULL,
    libelle VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

ALTER TABLE categorie_vehicule ALTER COLUMN id SET DEFAULT nextval('categorie_vehicule_id_seq');
