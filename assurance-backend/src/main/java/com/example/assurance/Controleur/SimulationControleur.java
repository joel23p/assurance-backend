package com.example.assurance.Controleur;
import com.example.assurance.Dto.SimulationDto;
import com.example.assurance.Service.SimulationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SimulationControleur {

    private final SimulationService simulationService;

    public SimulationControleur(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping("/simulations")
    public Map<String , Object> CreerSimulation(@RequestBody SimulationDto simulationDto) {
       return  simulationService.Simulation(simulationDto);
    }


}
