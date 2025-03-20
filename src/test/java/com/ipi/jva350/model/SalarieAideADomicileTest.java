package com.ipi.jva350.model;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.Salarie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;

class SalarieAideADomicileTest {

    @Test
    void testALegalementDroitADesCongesPayesParDefaut() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertEquals(false, res); // TODO vérifie que Sonar demande amélioration
    }

    /**
     * Test représentatif du cas "n'a légalement pas droit des congés"
     */
    @Test
    void testALegalementDroitADesCongesPayesFalseTypique() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(1);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        // avec 1j de travaillé, il est très peu probable d'avoir un jour de congés !
        Assertions.assertFalse(res);
    }

    /**
     * Test représentatif du cas "a légalement pas droit des congés"
     */
    @Test
    void testALegalementDroitADesCongesPayesTrueTypique() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(100);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        // avec 100j de travaillé, il est très probable d'avoir un jour de congés !
        Assertions.assertTrue(res);
    }

    /* tests nominaux / typiques n'apportant rien de plus :
    @Test
    void testALegalementDroitADesCongesPayes100() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(100);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // TODO vérifie que Sonar demande amélioration
    }
    @Test
    void testALegalementDroitADesCongesPayes101() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(101);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // TODO vérifie que Sonar demande amélioration
    }
    */

    @Test
    void testALegalementDroitADesCongesPayesFalseAuxLimites() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(9);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertFalse(res);
    }

    @Test
    void testALegalementDroitADesCongesPayesTrueAuxLimites() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(10);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res);
    }

    @Test
    void testUnitaireCalculeJoursDeCongeDecomptesPourPlage() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        LinkedHashSet<LocalDate>  res = s.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse("2022-11-01"), LocalDate.parse("2022-11-01"));
        // Then
        Assertions.assertNotNull(res);
        //Assertions.assertTrue(res.isEmpty());
        Assertions.assertEquals(0, res.size());
    }

    @ParameterizedTest(name = "pour plage {0}-{1}, décompté : {2}")
    @CsvSource({
            "'2024-10-30', '2024-10-30', 1",
            "'2024-10-30', '2024-10-31', 2"
    })
    void testParametreCalculeJoursDeCongeDecomptesPourPlage(String dateDebutString, String dateFinString, int count) {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        LinkedHashSet<LocalDate> nbJoursDansPlage = s.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse(dateDebutString), LocalDate.parse(dateFinString));
        // Then
        Assertions.assertNotNull(nbJoursDansPlage);
        //Assertions.assertTrue(res.isEmpty());
        Assertions.assertEquals(count, nbJoursDansPlage.size());
    }


    @Test
    void testALegalementDroitADesCongesPayesFalse() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(0); // Cas avec 0 jour travaillé
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertFalse(res); // Ne doit pas avoir droit aux congés payés avec 0 jour travaillé
    }

    @Test
    void testALegalementDroitADesCongesPayesTrue() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(15); // Cas avec 15 jours travaillés
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // Doit avoir droit aux congés payés avec 15 jours travaillés
    }

    @Test
    void testALegalementDroitADesCongesPayesAuxLimites() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(10); // Cas limite de 10 jours travaillés
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // Devrait avoir droit aux congés payés avec 10 jours travaillés
    }

    @Test
    void testCalculeJoursDeCongeDecomptesPourPlage() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.parse("2023-10-01");
        LocalDate dateFin = LocalDate.parse("2023-10-05");
        // When
        LinkedHashSet<LocalDate> joursDeConge = s.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        // Then
        Assertions.assertNotNull(joursDeConge);
        Assertions.assertEquals(3, joursDeConge.size()); // Vérifie que les jours sont bien comptabilisés
    }

    @Test
    void testCalculeJoursDeCongeDecomptesPourPlagePasDeJour() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.parse("2023-10-01");
        LocalDate dateFin = LocalDate.parse("2023-10-01");
        // When
        LinkedHashSet<LocalDate> joursDeConge = s.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        // Then
        Assertions.assertNotNull(joursDeConge);
        Assertions.assertEquals(0, joursDeConge.size()); // Vérifie qu'il n'y a pas de jours de congé dans la plage donnée
    }


}