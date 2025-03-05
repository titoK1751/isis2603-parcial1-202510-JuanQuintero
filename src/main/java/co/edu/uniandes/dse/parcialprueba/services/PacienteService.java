package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.ErrorMessage;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {

    @Autowired 
    PacienteRepository pacienteRepository;

    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    /**
     * 
     * Guarda un nuevo paciente
     * 
     * @param pacienteEntity la entidad del paciente que se busca persistir
     * @return La entidad luego de perisistirla
     * @throws EntityNotFoundException
     * @throws IllegalOperationException 
     */
    @Transactional
    public PacienteEntity createPaciente(PacienteEntity pacienteEntity) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de creacion del paciente");


        if (pacienteEntity.getTelefono().toString().length() != 11 && pacienteEntity.getTelefono().toString().startsWith("311") == false && pacienteEntity.getTelefono().toString().startsWith("601") == false) {
            throw new IllegalOperationException(ErrorMessage.NUMERO_INVALIDO);
        }
        
        log.info("Termina proceso de creacion del paciente");
        return pacienteRepository.save(pacienteEntity);
    }

    @Transactional 
    public PacienteEntity getPaciente(Long pacienteId) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de busqueda de un paciente");

        if (pacienteRepository.findById(pacienteId).isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.PACIENTE_NO_EXISTENTE);
        }        

        log.info("Termina proceso de busqueda de un paciente");     
        return pacienteRepository.findById(pacienteId).get();
    }

    @Transactional 
    public void updatePaciente(Long pacienteId, PacienteEntity pacienteEntity) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de actualizacion de un paciente");

        if (pacienteRepository.findById(pacienteId).isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.PACIENTE_NO_EXISTENTE);
        }        

        log.info("Termina proceso de actualizacion de un paciente");     
        pacienteEntity.setId(pacienteId);
        pacienteRepository.save(pacienteEntity);
    }

    @Transactional 
    public void deletePaciente(Long pacienteId, PacienteEntity pacienteEntity) throws EntityNotFoundException, IllegalOperationException{
        log.info("Inicia proceso de eliminacion de un paciente");

        if (pacienteRepository.findById(pacienteId).isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.PACIENTE_NO_EXISTENTE);
        }

        log.info("Termina proceso de eliminacion de un paciente");     
        pacienteEntity.setId(pacienteId);
      
        pacienteRepository.deleteById(pacienteId);
        
    }
    
}
