package com.example.assurance.Service;


import com.example.assurance.Dto.CategorieVehiculeDto;
import com.example.assurance.Repository.CategorieVehiculeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CategorieVehiculeService {

    private final CategorieVehiculeRepository categorieVehiculeRepository;

    public CategorieVehiculeService(CategorieVehiculeRepository categorieVehiculeRepository) {
        this.categorieVehiculeRepository = categorieVehiculeRepository;
    }

    @Transactional(readOnly = true)
    public List<CategorieVehiculeDto> listerCategorieVehicule() {
        return categorieVehiculeRepository.findAll()
                .stream()
                .map(categorie -> new CategorieVehiculeDto(
                        categorie.getId(),
                        categorie.getLibelle(),
                        categorie.getDescription()
                ))
                .collect(toList());
    }


}
