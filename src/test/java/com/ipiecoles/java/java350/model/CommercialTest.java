package com.ipiecoles.java.java350.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CommercialTest {

    @Test
    @Parameters({
            //"null, 500d",
            "0d, 500d",
            "100000d, 5000d",
    })
    public void testPrimeAnnuelle(Double caAnnuel, Double expectedPrime){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(caAnnuel);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(expectedPrime);
    }

    @Test
    public void testPrimeAnnuelleWithCANull(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(null);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);
    }

    @Test
    public void testPrimeAnnuelleWithCA0(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(0d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);
    }

    @Test
    public void testPrimeAnnuelleWithCA100000(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(100000d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(5000d);
    }




}
