package com.example.assurance.Service;


import com.example.assurance.Dto.ProduitAssuranceDto;
import com.example.assurance.Repository.ProduitAssuranceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProduitAssuranceService {
    private final ProduitAssuranceRepository produitAssuranceRepository;

    public ProduitAssuranceService(ProduitAssuranceRepository produitAssuranceRepository) {
        this.produitAssuranceRepository = produitAssuranceRepository;
    }

    @Transactional(readOnly = true)
    public List<ProduitAssuranceDto> listerProduitAssurance() {
        return produitAssuranceRepository.findAll()
                .stream()
                .map(produitAssurance -> new ProduitAssuranceDto(
                        produitAssurance.getId(),
                        produitAssurance.getNomProduit(),
                        produitAssurance.getGarantiesIncluses()
                ))
                .collect(toList());
    }

}
