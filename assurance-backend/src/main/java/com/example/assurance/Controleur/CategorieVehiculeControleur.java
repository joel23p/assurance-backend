package com.example.assurance.Controleur;
import com.example.assurance.Dto.CategorieVehiculeDto;
import com.example.assurance.Service.CategorieVehiculeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategorieVehiculeControleur {
    private final CategorieVehiculeService categorieVehiculeService;

    public CategorieVehiculeControleur(CategorieVehiculeService categorieVehiculeService) {
        this.categorieVehiculeService = categorieVehiculeService;
    }

    @GetMapping("/lister")
    public List<CategorieVehiculeDto> lister() {
        return categorieVehiculeService.listerCategorieVehicule();
    }
}
