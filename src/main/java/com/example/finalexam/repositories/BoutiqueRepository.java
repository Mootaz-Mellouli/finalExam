package com.example.finalexam.repositories;

import com.example.finalexam.entities.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {
    @Query("select b from Boutique b where b.nom = ?1 and b.centreCommercial.adresse = ?2")
    List<Boutique> findByNomAndCentreCommercialAdresse(String nom, String adresse);
}