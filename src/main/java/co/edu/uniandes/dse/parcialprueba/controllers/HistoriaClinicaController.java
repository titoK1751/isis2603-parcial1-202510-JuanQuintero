package co.edu.uniandes.dse.parcialprueba.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.parcialprueba.services.HistoriaClinicaService;

@RestController
@RequestMapping("/historiasClinicas")
public class HistoriaClinicaController {
    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private ModelMapper modelMapper;
}
