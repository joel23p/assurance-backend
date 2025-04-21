package com.example.assurance.Service;


import com.example.assurance.Domain.ProduitAssurance;
import com.example.assurance.Domain.Simulation;
import com.example.assurance.Dto.SimulationDto;
import com.example.assurance.Repository.ProduitAssuranceRepository;
import com.example.assurance.Repository.SimulationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SimulationService {

   private final SimulationRepository simulationRepository;
    private final ProduitAssuranceRepository produitAssuranceRepository;

    public SimulationService(SimulationRepository simulationRepository, ProduitAssuranceRepository produitAssuranceRepository) {
        this.simulationRepository = simulationRepository;
        this.produitAssuranceRepository = produitAssuranceRepository;
    }


     @Transactional
      public Map<String , Object > Simulation(SimulationDto simulationDto){

         ProduitAssurance produitAssurance = produitAssuranceRepository.findById(simulationDto.getProduitAssuranceId()).
                 orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
         List<String> garantiesIncluses = List.of(produitAssurance.getGarantiesIncluses().split(","));
         HashMap <String , Object>  Resultat = new HashMap<>();

         Long primeTotale = garantiesIncluses.stream().reduce(0L, (acc, garantie) -> {
             switch (garantie.trim()) {
                 case "RC":
                     return acc + calculerGarantieRC(simulationDto.getPuissanceFiscale());
                 case "DOMMAGE":
                     return acc + CalculerGarantieDommageOuTierceCollision(simulationDto.getPrixInitialVehicule(), garantie);
                 case "TIERCECOLLISION":
                     return acc + CalculerGarantieDommageOuTierceCollision(simulationDto.getPrixInitialVehicule(), garantie);
                 case "TIERCEPLAFONNEE":
                     return acc + CalculerGarantieTiercePlafonnee(simulationDto.getValeurActuelleVehicule());
                 case "VOL":
                     return acc + calculerGarantieVolOuIncendie(simulationDto.getValeurActuelleVehicule(), garantie);
                 case "INCENDIE":
                     return acc + calculerGarantieVolOuIncendie(simulationDto.getValeurActuelleVehicule(), garantie);
                 default:
                     return acc;
             }
         }, Long::sum);
         LocalDateTime endDate = LocalDate.now().plusDays(14).atStartOfDay();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         String quoteReference = "QT" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);

         Resultat.put("quoteReference", quoteReference);
         Resultat.put("endDate", endDate.format(formatter));
         Resultat.put("price",primeTotale);
         Resultat.put("puissanceFiscale", simulationDto.getPuissanceFiscale());
         Resultat.put("prixInitialVehicule", simulationDto.getPrixInitialVehicule());
         Resultat.put("valeurActuelleVehicule", simulationDto.getValeurActuelleVehicule());

         Simulation simulation = new Simulation(
                 quoteReference,
                 produitAssurance,
                 simulationDto.getPrixInitialVehicule(),
                 simulationDto.getValeurActuelleVehicule(),
                 simulationDto.getPuissanceFiscale(),
                 simulationDto.getPrixTotal(),
                 endDate
         );

         simulationRepository.save(simulation);

         return  Resultat;

     }



    /**
     * Calcule la prime de la garantie Responsabilité Civile (RC)
     * selon la puissance fiscale du véhicule, via if/else.
     *
     * @param puissanceFiscale la puissance fiscale du véhicule
     * @return le montant de la prime en F CFA
     * @throws IllegalArgumentException si la puissance est nulle ou invalide
     */
    public  Long calculerGarantieRC(Long puissanceFiscale) {
        if (puissanceFiscale == null || puissanceFiscale <= 0) {
            throw new IllegalArgumentException("La puissance fiscale doit être positive et non nulle.");
        }
        if (puissanceFiscale == 2) {
            System.out.println("enter puissance fiscale");
            return 37601L;
        } else if (puissanceFiscale >= 3 && puissanceFiscale <= 6) {
            return 45181L;
        } else if (puissanceFiscale >= 7 && puissanceFiscale <= 10) {
            return 51078L;
        } else if (puissanceFiscale >= 11 && puissanceFiscale <= 14) {
            return 65677L;
        } else if (puissanceFiscale >= 15 && puissanceFiscale <= 23) {
            return 86456L;
        } else {
            return 104143L;
        }
    }

    public Long CalculerGarantieDommageOuTierceCollision(Long prixInitial, String typeGarantie) {
        if (prixInitial == null || prixInitial <= 0) {
            throw new IllegalArgumentException("La valeur n'existe pas.");
        }
        double taux;
        switch (typeGarantie) {
            case "DOMMAGE":
                System.out.println("enter Dommage");
                taux= 2.6;

                break;
            case "TIERCECOLLISION":
                taux= 1.65;
                break;
            default:
                throw new IllegalArgumentException("Type de garantie inconnu : " + typeGarantie);
        }
        return (long) ((taux * prixInitial)/100);
    }

    public Long CalculerGarantieTiercePlafonnee(Long ValeurVenale) {
        if (ValeurVenale == null || ValeurVenale <= 0) {
            throw new IllegalArgumentException("La valeur n'existe pas.");
        }

        Long valeurAssuree = (long) (0.5 * ValeurVenale);

        Long prime = (long) (0.042 * valeurAssuree);

        if (prime < 100000) {
            prime = 100000L;
        }

        return prime;
    }

    public Long calculerGarantieVolOuIncendie(Long valeurVenale, String typeGarantie){
        if (valeurVenale == null || valeurVenale <= 0) {
            throw new IllegalArgumentException("La valeur vénale est invalide.");
        }

        double taux;

        switch (typeGarantie) {
            case "VOL":
                System.out.println("enter Vol");
                taux = 0.14;
                break;
            case "INCENDIE":
                taux = 0.15;
                break;
            default:
                throw new IllegalArgumentException("Type de garantie inconnu : " + typeGarantie);
        }

        return (long) ((taux * valeurVenale) / 100);
    }

}
