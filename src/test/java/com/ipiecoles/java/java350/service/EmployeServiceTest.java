package com.ipiecoles.java.java350.service;

import com.ipiecoles.java.java350.model.Commercial;
import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

    @InjectMocks
    private EmployeService employeService;

    @Mock
    private EmployeRepository employeRepository;

    @Test
    public void testFindByMatriculeFound(){
        //Given
        Commercial commercial = new Commercial();
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(commercial);

        //When
        Employe employe = employeService.findByMatricule("C12345");

        //Then
        Assertions.assertThat(employe).isEqualTo(commercial);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindByMatriculeNotFound(){
        //Given
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);

        //When
        Employe employe = employeService.findByMatricule("C12345");

        //Then
    }

    @Test
    public void testFindByMatriculeNotFound2(){
        //Given
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);

        //When
        try {
            Employe employe = employeService.findByMatricule("C12345");
            Assertions.fail("Cela aurait dû planter !");
        }
        catch (Exception e){
            //Then
            Assertions.assertThat(e).isInstanceOf(EntityNotFoundException.class);
            Assertions.assertThat(e).hasMessage("Impossible de trouver l'employé de matricule C12345");
        }
    }
}
