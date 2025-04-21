package com.example.assurance.Repository;

import com.example.assurance.Domain.Souscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SouscriptionRepository extends JpaRepository<Souscription, Long> {
}
