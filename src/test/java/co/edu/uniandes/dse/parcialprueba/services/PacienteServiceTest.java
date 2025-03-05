package co.edu.uniandes.dse.parcialprueba.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@DataJpaTest
@Transactional
@Import(PacienteService.class)
public class PacienteServiceTest {

    @Autowired
	private PacienteService pacienteService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private PacienteEntity pacienteEntity;
	private HistoriaClinicaEntity historiaClinicaEntity;

	/**
     * Configuracion inicial de la prueba
     */
    @BeforeEach
    void setup(){
        clearData();
        insertData();
    }

    private void clearData() {
        entityManager.getEntityManager().createQuery("DELETE FROM PacienteEntity");
        entityManager.getEntityManager().createQuery("DELETE FROM HistoriaClinicaEntity");
    }
    
	private void insertData() {
        pacienteEntity = factory.manufacturePojo(PacienteEntity.class);
        entityManager.persist(pacienteEntity);

    }

	@Test
	public void createPacienteTest() throws EntityNotFoundException, IllegalOperationException {
		PacienteEntity pacienteEntity = factory.manufacturePojo(PacienteEntity.class);
		pacienteEntity = pacienteService.createPaciente(pacienteEntity);
	}
}
