package com.example.finalexam.repositories;

import com.example.finalexam.entities.Categorie;
import com.example.finalexam.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c inner join c.boutiqueList boutiqueList where boutiqueList.categorie = ?1")
    List<Client> findByBoutiqueListCategorie(Categorie categorie);
}