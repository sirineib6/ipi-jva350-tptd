package com.ipi.jva350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalarieAideADomicileTest {

    @Test
    public void testSalarieDroitCongesPayes() {
        // Given : Mise en place de l'environnement du test et de ses données (hypothèses)
        Salarie salarieAvecDroit = new Salarie();
        salarieAvecDroit.setJoursTravaillesAnneeNMoins1(15);

        Salarie salarieSansDroit = new Salarie();
        salarieSansDroit.setJoursTravaillesAnneeNMoins1(8);

        // When : Comportement à tester
        boolean aDroitAvecDroit = salarieAvecDroit.aLegalementDroitADesCongesPayes();
        boolean aDroitSansDroit = salarieSansDroit.aLegalementDroitADesCongesPayes();

        // Then : Vérification du résultat
        Assertions.assertTrue(aDroitAvecDroit);
        Assertions.assertFalse(aDroitSansDroit);
    }
}




