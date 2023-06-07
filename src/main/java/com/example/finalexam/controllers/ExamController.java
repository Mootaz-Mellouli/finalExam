package com.example.finalexam.controllers;

import com.example.finalexam.entities.*;
import com.example.finalexam.services.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExamController {

    private final IExamService examService;


    @PostMapping("/addCC")
    public CentreCommercial ajouterCentreCommercial(@RequestBody CentreCommercial centreCommercial){
        return examService.ajouterCentreCommercial(centreCommercial);
    }
    @PostMapping("/addBoutique/{idCentre}")
    public void ajouterEtAffecterListeBoutique(@RequestBody List<Boutique> lb, @PathVariable Long idCentre) {
         examService.ajouterEtAffecterListeBoutique(lb, idCentre);
    }

    @PostMapping("/addClient/{idBoutique}")
    public void ajouterEtAffecterClientBoutique(@RequestBody Client client,@PathVariable Long idBoutique) {
        examService.ajouterEtAffecterClientBoutique(client, idBoutique);
    }

    @GetMapping("getClient/{categorie}")
    public List<Client> listeClientsParCategorie(@PathVariable Categorie categorie) {
        return examService.listeClientsParCategorie(categorie);
    }

    @GetMapping("getBoutique/{nomCentre}/{adresseCentre}")
    public List<Boutique> listeBoutiques(@PathVariable String nomCentre, @PathVariable String adresseCentre) {
        return examService.listeBoutiques(nomCentre, adresseCentre);
    }
    /*@PostMapping("/addClasse")
    public Classe ajouterClass(@RequestBody Classe c) {
        return examService.ajouterClass(c);
    }

    @PostMapping("/addCoursClassrom/{codeClass}")
    public CoursClassroom ajouterCoursClassrom(@RequestBody CoursClassroom cc,@PathVariable Integer codeClass) {
        return examService.ajouterCoursClassrom(cc, codeClass);
    }

    @PutMapping("/affecterUserToClasse/{idUtilisater}/{codeClasse}")
    public void affecterUtilisateurClasse(@PathVariable Integer idUtilisater,@PathVariable Integer codeClasse) {
       examService.affecterUtilisateurClasse(idUtilisater, codeClasse);
    }

    @GetMapping("/getuserbyniveau/{nv}")
    public Integer nbUtilisateurParNiveau(@PathVariable Niveau nv) {
        return examService.nbUtilisateurParNiveau(nv) ;
    }

    @DeleteMapping("deleteCours/{id}")
    public void desaffecterCoursClassroomClasse(@PathVariable int id){
        examService.desaffecterCoursClassroomClasse(id);
    }*/
}
