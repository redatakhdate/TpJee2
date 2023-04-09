package com.example.demo.repositories;

import com.example.demo.entities.Etudiant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface EtudiantRepo extends JpaRepository<Etudiant,Integer> {
    /** Requêtes personnalisées**/
    List<Etudiant> findByStillActive(Boolean stillActive);
    List<Etudiant> deleteByFullName(String fullName);
}
