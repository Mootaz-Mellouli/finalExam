package com.example.finalexam.repositories;

import com.example.finalexam.entities.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {
}