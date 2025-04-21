package com.example.assurance.Controleur;

import com.example.assurance.Dto.ProduitAssuranceDto;
import com.example.assurance.Service.ProduitAssuranceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProduitAssuranceControleur {
    private final ProduitAssuranceService produitAssuranceService;

    public ProduitAssuranceControleur(ProduitAssuranceService produitAssuranceService) {
        this.produitAssuranceService = produitAssuranceService;
    }

    @GetMapping("/recuperer")
    public List<ProduitAssuranceDto> lister() {
        return produitAssuranceService.listerProduitAssurance();
    }
}
