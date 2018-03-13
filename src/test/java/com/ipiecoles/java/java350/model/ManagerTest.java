package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

public class ManagerTest {

    @Test
    public void testSetSalaire(){
        //Given Manager et son équipe
        Manager manager = new Manager();

        //When
        manager.setSalaire(1000d);

        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(1300d);

    }

}
