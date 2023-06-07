package com.example.finalexam.services;

import com.example.finalexam.entities.*;
import com.example.finalexam.repositories.BoutiqueRepository;
import com.example.finalexam.repositories.CentreCommercialRepository;
import com.example.finalexam.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamsServiceImpl implements IExamService {
    private final CentreCommercialRepository centreCommercialRepository;
    private final BoutiqueRepository boutiqueRepository;

    private final ClientRepository clientRepository;
   /* @Override
    public Test addTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur) ;
    }

    @Override
    public Classe ajouterClass(Classe c) {
        return classeRepository.save(c);
    }

    @Transactional
    @Override
    public CoursClassroom ajouterCoursClassrom(CoursClassroom cc, Integer codeClass) {
        coursClassromRepository.saveAndFlush(cc);
       Classe classe = classeRepository.findById(codeClass).orElse(null);
        Assert.notNull(classe,"classe not found");
        cc.setClasse(classe);

        return cc;
    }

    @Transactional
    @Override
    public void affecterUtilisateurClasse(Integer idUtilisater, Integer codeClasse) {
       Utilisateur utilisateur = utilisateurRepository.findById(idUtilisater).orElse(null);
        Assert.notNull(utilisateur,"user not found");
        Classe classe = classeRepository.findById(codeClasse).orElse(null);
        Assert.notNull(classe,"user not found");
        utilisateur.setClasse(classe);

    }

    @Override
    public Integer nbUtilisateurParNiveau(Niveau nv) {
        return utilisateurRepository.findByClasseNiveau(nv) ;
    }

    @Scheduled(fixedRate = 60000)
    @Override
    @Transactional
    public void archiverCoursClassrooms() {
        log.info("scheduler declencher");
        coursClassromRepository.findAll().forEach(coursClassroom -> {
            coursClassroom.setArchive(true);
        });
    }

    @Override
    @Transactional
    public void desaffecterCoursClassroomClasse(int id) {
      CoursClassroom coursClassroom = coursClassromRepository.findCoursClassroomByIdCoursAndClasseTitre(id,"4ag1");
        Assert.notNull(coursClassroom,"I can only delete class with name 4ag1 ;)");
      coursClassroom.setClasse(null);
    }*/

    @Override
    public CentreCommercial ajouterCentreCommercial(CentreCommercial centreCommercial) {
        return centreCommercialRepository.save(centreCommercial);
    }

    @Override
    @Transactional
    public void ajouterEtAffecterListeBoutique(List<Boutique> lb, Long idCentre) {
        lb.forEach(boutique -> {
           Boutique newBoutique = boutiqueRepository.saveAndFlush(boutique);
           CentreCommercial centreCommercial = centreCommercialRepository.findById(idCentre).orElse(null);
            newBoutique.setCentreCommercial(centreCommercial);
        });
    }

    @Override
    @Transactional
    public void ajouterEtAffecterClientBoutique(Client client, Long idBoutique) {
        Client newClient = clientRepository.saveAndFlush(client);
        Boutique boutique = boutiqueRepository.findById(idBoutique).orElse(null);
        List<Boutique> newList = new ArrayList<>();
        newList.add(boutique);
        newClient.setBoutiqueList(newList);
    }

    @Override
    public List<Client> listeClientsParCategorie(Categorie categorie) {
        return clientRepository.findByBoutiqueListCategorie(categorie);
    }

    @Override
    public List<Boutique> listeBoutiques(String nomCentre, String adresseCentre) {
        return boutiqueRepository.findByCentreCommercialNomAndCentreCommercialAdresse(nomCentre, adresseCentre);
    }
}
