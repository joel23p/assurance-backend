-- Table: produit_assurance
CREATE SEQUENCE produit_assurance_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE produit_assurance (
                                   id int8 NOT NULL PRIMARY KEY,
                                   created_at TIMESTAMP WITHOUT TIME ZONE,
                                   updated_at TIMESTAMP WITHOUT TIME ZONE,
                                   nom_produit VARCHAR(255) NOT NULL,
                                   garanties_incluses VARCHAR(255) NOT NULL,
                                   categories_eligibles VARCHAR(255) NOT NULL
);

ALTER TABLE produit_assurance ALTER COLUMN id SET DEFAULT nextval('produit_assurance_id_seq');