-- Table: souscription
CREATE SEQUENCE souscription_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE souscription (
                              id int8 NOT NULL PRIMARY KEY,
                              created_at TIMESTAMP WITHOUT TIME ZONE,
                              updated_at TIMESTAMP WITHOUT TIME ZONE,
                              date_souscription TIMESTAMP WITHOUT TIME ZONE,
                              client_id int8,
                              vehicule_id int8,
                              CONSTRAINT client_fk FOREIGN KEY (client_id) REFERENCES client(id),
                              CONSTRAINT vehicule_fk FOREIGN KEY (vehicule_id) REFERENCES vehicule(id)
);

ALTER TABLE souscription ALTER COLUMN id SET DEFAULT nextval('souscription_id_seq');