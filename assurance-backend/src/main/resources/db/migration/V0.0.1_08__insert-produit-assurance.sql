INSERT INTO produit_assurance (created_at, updated_at, nom_produit, garanties_incluses, categories_eligibles) VALUES
                                                                                                                  (now(), now(), 'Papillon', 'RC,DOMMAGE,VOL', '201'),
                                                                                                                  (now(), now(), 'Douby', 'RC,DOMMAGE,TIERCECOLLISION', '202'),
                                                                                                                  (now(), now(), 'Douyou', 'RC,DOMMAGE,COLLISION,INCENDIE', '201,202'),
                                                                                                                  (now(), now(), 'Toutourisquou', 'RC,DOMMAGE,VOL,INCENDIE,TIERCECOLLISION,TIERCEPLAFONNEE', '201');
