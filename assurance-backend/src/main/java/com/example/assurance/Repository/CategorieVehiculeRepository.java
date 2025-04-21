package com.example.assurance.Repository;

import com.example.assurance.Domain.CategorieVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieVehiculeRepository extends JpaRepository<CategorieVehicule, Long> {

}
