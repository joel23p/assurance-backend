package com.example.assurance.Controleur;


import com.example.assurance.Dto.SouscriptionDto;
import com.example.assurance.Service.SouscriptionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class SouscriptionControleur {

    private final SouscriptionService souscriptionService;

    public SouscriptionControleur(SouscriptionService souscriptionService) {
        this.souscriptionService = souscriptionService;
    }

    @GetMapping("/trouver/{id}")
    public SouscriptionDto trouver(@PathVariable Long id) {
        return souscriptionService.trouverSouscription(id);
    }

    @PostMapping("/subscriptions")
    public SouscriptionDto enregistrer(@RequestBody SouscriptionDto souscriptionDto) {
        System.out.println("enter hier");
        return souscriptionService.enregistrerSouscription(souscriptionDto);
    }
}