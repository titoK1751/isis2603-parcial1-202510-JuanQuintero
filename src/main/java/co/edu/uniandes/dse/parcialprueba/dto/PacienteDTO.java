package co.edu.uniandes.dse.parcialprueba.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PacienteDTO {
    @NotNull
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String correo;
    @NotNull
    private Integer telefono;

    private PacienteDetailDTO acudiente;

}
