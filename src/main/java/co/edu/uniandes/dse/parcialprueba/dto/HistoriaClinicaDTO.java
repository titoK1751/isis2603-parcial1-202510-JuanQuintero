package co.edu.uniandes.dse.parcialprueba.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HistoriaClinicaDTO {
    
    @NotNull
    private Long id;
    @NotNull
    private String diagnostico;
    @NotNull    
    private String tratamiento;
    @NotNull
    @DateTimeFormat
    private Date fechaDeCreacion;

    @NotNull
    private PacienteDTO paciente;
}
