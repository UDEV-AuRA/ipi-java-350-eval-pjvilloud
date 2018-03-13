package com.ipiecoles.java.java350.repository;

import com.ipiecoles.java.java350.MySpringApplication;
import com.ipiecoles.java.java350.model.Commercial;
import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = MySpringApplication.class)
public class EmployeRepositoryTest {

    @Autowired
    private EmployeRepository employeRepository;

    Commercial pierreDurand, rachidDurand, manuelPierre;

    @Before
    public void setUp(){
        //Supprimer toutes les données de la table employé
        employeRepository.deleteAll();

        //Ajouter nos données de test
        //Given
        pierreDurand = new Commercial();
        pierreDurand.setPrenom("Pierre");
        pierreDurand.setNom("Durand");
        pierreDurand = employeRepository.save(pierreDurand);

        rachidDurand = new Commercial();
        rachidDurand.setPrenom("Rachid");
        rachidDurand.setNom("Durand");
        rachidDurand = employeRepository.save(rachidDurand);

        manuelPierre = new Commercial();
        manuelPierre.setPrenom("Manuel");
        manuelPierre.setNom("Pierre");
        manuelPierre = employeRepository.save(manuelPierre);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom(){
        //Given

        //When
        List<Employe> employeList = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");

        //Then
        Assertions.assertThat(employeList).isNotEmpty();
        Assertions.assertThat(employeList).hasSize(2);
        Assertions.assertThat(employeList).contains(pierreDurand, manuelPierre);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
        //Given

        //When
        List<Employe> employeList = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");

        //Then
        Assertions.assertThat(employeList).isNotEmpty();
        Assertions.assertThat(employeList).hasSize(2);
        Assertions.assertThat(employeList).contains(pierreDurand);
        Assertions.assertThat(employeList).contains(rachidDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCasePrenom(){
        //Given

        //When
        List<Employe> employeList = employeRepository.findByNomOrPrenomAllIgnoreCase("RACHID");

        //Then
        Assertions.assertThat(employeList).isNotEmpty();
        Assertions.assertThat(employeList).hasSize(1);
        Assertions.assertThat(employeList).contains(rachidDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNotFound(){
        //Given

        //When
        List<Employe> employeList = employeRepository.findByNomOrPrenomAllIgnoreCase("Valls");

        //Then
        Assertions.assertThat(employeList).isEmpty();
    }

}
