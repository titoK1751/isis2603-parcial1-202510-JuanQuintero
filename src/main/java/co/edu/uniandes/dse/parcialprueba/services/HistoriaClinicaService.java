package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
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
public class HistoriaClinicaService {

    @Autowired 
    PacienteRepository pacienteRepository;

    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    /**
     * 
     * Guarda un nuevo paciente
     * 
     * @param historiaClinicaEntity la entidad del paciente que se busca persistir
     * @return La entidad luego de perisistirla
     * @throws EntityNotFoundException
     * @throws IllegalOperationException 
     */
    @Transactional
    public HistoriaClinicaEntity createHistoriaClinica(HistoriaClinicaEntity historiaClinicaEntity, Long pacienteId) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de creacion de una historia clinica");

        if (pacienteRepository.findById(pacienteId).isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.PACIENTE_NO_EXISTENTE);
        }

        historiaClinicaEntity.setPaciente(pacienteRepository.findById(pacienteId).get());
        
        log.info("Termina proceso de creacion de una historia clinica");
        return historiaClinicaRepository.save(historiaClinicaEntity);
    }

    @Transactional 
    public HistoriaClinicaEntity getHistoriaClinica(Long historiaClinicaId) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de busqueda de una historia clinica");

        if (historiaClinicaRepository.findById(historiaClinicaId).isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.PACIENTE_NO_EXISTENTE);
        }
        
        log.info("Termina proceso de busqueda de una historia clinica");
        return historiaClinicaRepository.findById(historiaClinicaId).get();
    }

    @Transactional 
    public void updateHistoriaClinica(Long historiaClinicaId, HistoriaClinicaEntity HistoriaClinicaEntity) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de actualizacion de una historia clinica");

        if (historiaClinicaRepository.findById(historiaClinicaId).isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.PACIENTE_NO_EXISTENTE);
        }   
        
        log.info("Termina proceso de actualizacion de una historia clinica");
        HistoriaClinicaEntity.setId(historiaClinicaId);
        historiaClinicaRepository.save(HistoriaClinicaEntity);
    }

    @Transactional 
    public void deleteHistoriaClinica(Long pacienteId, HistoriaClinicaEntity historiaClinicaEntity) throws EntityNotFoundException, IllegalOperationException{
        log.info("Inicia proceso de eliminacion de una historia clinica");

        if (pacienteRepository.findById(pacienteId).isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.PACIENTE_NO_EXISTENTE);
        }

        log.info("Termina proceso de eliminacion de una historia clinica");
        historiaClinicaRepository.deleteById(historiaClinicaEntity.getId());
    }
    
    
}
