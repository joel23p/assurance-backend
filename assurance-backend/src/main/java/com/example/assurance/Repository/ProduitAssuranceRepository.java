package com.example.assurance.Repository;

import com.example.assurance.Domain.ProduitAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitAssuranceRepository  extends JpaRepository<ProduitAssurance, Long> {
}
