-- Création de la séquence
CREATE SEQUENCE client_id_seq START WITH 1 INCREMENT BY 50;

-- Création de la table client avec timestamps simplifiés
CREATE TABLE IF NOT EXISTS client (
   id int8 NOT NULL PRIMARY KEY,
   created_at TIMESTAMP WITHOUT TIME ZONE,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
    nom varchar(255) NOT NULL,
    prenoms varchar(255) NOT NULL,
    telephone varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    adresse VARCHAR(255),
    ville VARCHAR(255),
    numero_carte_identite VARCHAR(255)
    );

-- Définition de la valeur par défaut de l'identifiant
ALTER TABLE client ALTER COLUMN id SET DEFAULT nextval('client_id_seq');
