package com.example.demo;

import com.example.demo.entities.Etudiant;
import com.example.demo.repositories.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {
    @Autowired
    private EtudiantRepo etdRepo;
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("******************** Insertion **********************");
        etdRepo.save(new Etudiant(null,"A1","Alya Diman",new Date(2000,5,4),true,new Date()));
        etdRepo.save(new Etudiant(null,"A2","Rayan Berrada",new Date(1997,10,12),true,new Date()));
        etdRepo.save(new Etudiant(null,"A3","Lilya Bennis",new Date(2001,2,5),false,new Date()));
        etdRepo.save(new Etudiant(null,"A4","Lina Azel",new Date(1997,3,11),true,new Date()));
        etdRepo.save(new Etudiant(null,"A5","Anwar Idrissi",new Date(1995,6,2),false,new Date()));
        System.out.println("********************** Inserted rows ************************");
        System.out.println("Count:"+etdRepo.count()); // count pour calculer le nombre d'enregistrement dans la BD
        System.out.println("\n********************** Display Rows ************************");
        List<Etudiant> etudiantList=etdRepo.findAll(); // récupérer tous les lignes
        etudiantList.forEach(etudiant->{System.out.println(etudiant.toString());});
        System.out.println("\n********************* Get Element By Id *********************");
        Etudiant etd= etdRepo.findById(2).orElse(null); // chercher l'étudiant à partir de son Id
        System.out.println(etd.toString());
        System.out.println("\n********************* Update Element *********************");
        etd.setRegistration_num("S2");
        etdRepo.save(etd); // sauvegarder la ligne modifiée
        System.out.println(etd.toString());
        System.out.println("\n********************* Delete Element *********************");
        etdRepo.delete(etd);
        System.out.println("Count:"+etdRepo.count());
        etdRepo.deleteById(3);
        System.out.println("Count:"+etdRepo.count());
        System.out.println("\n********************* Select active students *********************");
        List<Etudiant> activeEtds=etdRepo.findByStillActive(true);
        activeEtds.forEach(aEtd->{System.out.println(aEtd.toString());});
    }
}
