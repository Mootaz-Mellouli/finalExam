package com.example.finalexam.services;

import com.example.finalexam.entities.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IExamService {

   CentreCommercial ajouterCentreCommercial(CentreCommercial centreCommercial);

   void ajouterEtAffecterListeBoutique(List<Boutique> lb, Long idCentre);
   void ajouterEtAffecterClientBoutique(Client client, Long idBoutique);

}
