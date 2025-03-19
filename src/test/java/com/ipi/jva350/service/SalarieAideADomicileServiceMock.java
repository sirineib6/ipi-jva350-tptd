package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class SalarieAideADomicileServiceMock {

    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @InjectMocks
    private SalarieAideADomicileService salarieService;

    /**
     * Test unitaire de la méthode ajouteConge() (mocké).
     * Ce test vérifie que les congés payés sont correctement ajoutés et que le repository est appelé pour la sauvegarde.
     */
    @Test
    public void testAjouteConge() throws SalarieException {
        // Given : création d'un salarié avec des informations spécifiques
        SalarieAideADomicile monSalarie = new SalarieAideADomicile("Paul",
                LocalDate.of(2022, 6, 28), LocalDate.of(2023, 11, 1),
                9, 2.5,
                80, 20, 8);

        // When : appel de la méthode pour ajouter un congé
        salarieService.ajouteConge(monSalarie, LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 18));

        // Then : vérifier que la méthode save() a bien été appelée sur le repository
        ArgumentCaptor<SalarieAideADomicile> salarieCaptor = ArgumentCaptor.forClass(SalarieAideADomicile.class);
        Mockito.verify(salarieAideADomicileRepository, Mockito.times(1)).save(salarieCaptor.capture());

        // Vérifier que le nombre de congés pris en année N-1 a bien été mis à jour après l'ajout du congé
        Assertions.assertEquals(1L, salarieCaptor.getValue().getCongesPayesPrisAnneeNMoins1());
    }
}
