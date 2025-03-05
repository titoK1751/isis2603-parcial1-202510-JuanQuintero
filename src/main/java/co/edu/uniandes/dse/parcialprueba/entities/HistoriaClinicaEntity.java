package co.edu.uniandes.dse.parcialprueba.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class HistoriaClinicaEntity extends BaseEntity{

    // El id es heredado de BaseEntity y se trata de un Long
    private String diagnostico;
    private String tratamiento;

    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;
    
    @ManyToOne
    private PacienteEntity paciente;
    
}
