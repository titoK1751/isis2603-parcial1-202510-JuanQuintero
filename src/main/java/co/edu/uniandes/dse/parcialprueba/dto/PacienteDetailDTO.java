package co.edu.uniandes.dse.parcialprueba.dto;

import java.util.List;

import lombok.Data;

@Data
public class PacienteDetailDTO extends PacienteDTO {
    private List<HistoriaClinicaDTO> historiasClinicas;
}
