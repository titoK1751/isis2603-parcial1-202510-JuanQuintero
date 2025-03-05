package co.edu.uniandes.dse.parcialprueba.entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class PacienteEntity extends BaseEntity{

    // El id es heredado de BaseEntity y se trata de un Long
    private Long id;
	private String name;
	private String correo;
	private Integer telefono;

    @OneToOne
    private PacienteEntity acudiente;

    @OneToMany(mappedBy = "paciente")
    private List<HistoriaClinicaEntity> historiasClinicas;

}
