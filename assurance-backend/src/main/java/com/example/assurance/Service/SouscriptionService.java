package com.example.assurance.Service;


import com.example.assurance.Domain.CategorieVehicule;
import com.example.assurance.Domain.Client;
import com.example.assurance.Domain.Souscription;
import com.example.assurance.Domain.Vehicule;
import com.example.assurance.Dto.SouscriptionDto;
import com.example.assurance.Repository.CategorieVehiculeRepository;
import com.example.assurance.Repository.ClientRepository;
import com.example.assurance.Repository.SouscriptionRepository;
import com.example.assurance.Repository.VehiculeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SouscriptionService {
    private final SouscriptionRepository souscriptionRepository;
    private final ClientRepository clientRepository;
    private final VehiculeRepository vehiculeRepository;
    private final CategorieVehiculeRepository categorieVehiculeRepository;

    public SouscriptionService(SouscriptionRepository souscriptionRepository, ClientRepository clientRepository, VehiculeRepository vehiculeRepository, CategorieVehiculeRepository categorieVehiculeRepository) {
        this.souscriptionRepository = souscriptionRepository;
        this.clientRepository = clientRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.categorieVehiculeRepository = categorieVehiculeRepository;
    }

    @Transactional
    public SouscriptionDto enregistrerSouscription(SouscriptionDto souscriptionDto) {
        Client client = new Client(
                souscriptionDto.getNom(),
                souscriptionDto.getPrenom(),
                souscriptionDto.getTelephone(),
                souscriptionDto.getEmail(),
                souscriptionDto.getAdresse(),
                souscriptionDto.getVille(),
                souscriptionDto.getNumeroIdentite()
        );
        clientRepository.save(client);

        CategorieVehicule categorie = categorieVehiculeRepository.findById(souscriptionDto.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));

        Vehicule vehicule = new Vehicule(
                souscriptionDto.getDatePremiereCirculation(),
                souscriptionDto.getNumeroImmatriculation(),
                souscriptionDto.getCouleur(),
                souscriptionDto.getNbSieges(),
                souscriptionDto.getNbPortes(),
                categorie
        );
        vehiculeRepository.save(vehicule);

        Souscription souscription = new Souscription(LocalDateTime.now(), client, vehicule);
        souscriptionRepository.save(souscription);
        return new SouscriptionDto(souscription);
    }

    @Transactional
    public SouscriptionDto trouverSouscription(Long id) {
        Souscription souscription = souscriptionRepository.findById(id).orElseThrow();
        return new SouscriptionDto(souscription);
    }
}
