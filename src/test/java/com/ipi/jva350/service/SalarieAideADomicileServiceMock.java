package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SalarieAideADomicileServiceIntegrationTest {

    @Autowired
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @InjectMocks
    private SalarieAideADomicileService salarieService;

    private SalarieAideADomicile monSalarie;

    @BeforeEach
    void setUp() {
        monSalarie = new SalarieAideADomicile("Paul",
                LocalDate.of(2022, 6, 28), LocalDate.of(2023, 11, 1),
                9, 2.5,
                80, 20, 8);
        salarieAideADomicileRepository.save(monSalarie);
    }

    @Test
    void testAjouteCongeSuccess() throws SalarieException {
        // Given
        // Mon salarié est déjà créé et sauvegardé

        // When
        salarieService.ajouteConge(monSalarie, LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 18));

        // Then
        SalarieAideADomicile salarieTrouve = salarieAideADomicileRepository.findByNom("Paul");
        Assertions.assertNotNull(salarieTrouve);
        Assertions.assertEquals(1L, salarieTrouve.getCongesPayesPrisAnneeNMoins1());
    }

    @Test
    void testAjouteCongeSalarieSansDroit() {
        // Given
        monSalarie.setJoursTravaillesAnneeNMoins1(0);
        salarieAideADomicileRepository.save(monSalarie);

        // When
        SalarieException exception = Assertions.assertThrows(SalarieException.class, () ->
                salarieService.ajouteConge(monSalarie, LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 18))
        );

        // Then
        Assertions.assertEquals("N'a pas légalement droit à des congés payés !", exception.getMessage());
    }
}
