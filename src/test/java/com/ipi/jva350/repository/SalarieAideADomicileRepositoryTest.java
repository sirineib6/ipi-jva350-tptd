package com.ipi.jva350.repository;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@DataJpaTest // Configuration Spring pour tester le repository avec une base de données en mémoire
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @BeforeEach
    void setUp() {
        // Suppression des données existantes (facultatif en fonction de la configuration de la base de données)
        salarieAideADomicileRepository.deleteAll();
    }

    @Test
    void testFindByNomNotFoundNominal() {
        // Given
        String testNom = "Pierre";
        // When
        SalarieAideADomicile salarieTrouve = salarieAideADomicileRepository.findByNom(testNom);
        // Then
        Assertions.assertNull(salarieTrouve, "Le salarié ne devrait pas être trouvé.");
    }

    @Test
    void testFindByNomFoundNominal() {
        // Given
        String testNom = "Pierre";
        SalarieAideADomicile newSalarie = new SalarieAideADomicile(
                testNom, LocalDate.of(2023, 5, 1), LocalDate.of(2025, 02, 01),
                18.0, 21.0, 200.0, 25.0, 1.0);
        salarieAideADomicileRepository.save(newSalarie); // Sauvegarder le salarié en base
        // When
        SalarieAideADomicile salarieTrouve = salarieAideADomicileRepository.findByNom(testNom);
        // Then
        Assertions.assertNotNull(salarieTrouve, "Le salarié devrait être trouvé.");
        Assertions.assertEquals(testNom, salarieTrouve.getNom(), "Le nom du salarié ne correspond pas.");
    }
}
