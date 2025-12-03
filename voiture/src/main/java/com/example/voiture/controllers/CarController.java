package com.example.voiture.controllers;

import com.example.voiture.entities.Car;
import com.example.voiture.models.CarResponse;
import com.example.voiture.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * Récupère toutes les voitures avec les détails des clients
     * GET /api/car
     */
    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

    /**
     * Récupère une voiture par son ID avec les détails du client
     * GET /api/car/{id}
     */
    @PostMapping
    public ResponseEntity<CarResponse> createCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);  // on crée une méthode dans CarService
        return ResponseEntity.status(HttpStatus.CREATED).body(
                carService.mapToCarResponse(savedCar) // retourne la voiture avec le client
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            CarResponse car = carService.findById(id);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erreur: " + e.getMessage());
        }
    }
}