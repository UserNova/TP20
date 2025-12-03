package com.example.voiture.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;    // Marque de la voiture
    private String model;    // Modèle de la voiture
    private String matricule; // Plaque d'immatriculation
    private Long client_id;  // ID du client propriétaire
}