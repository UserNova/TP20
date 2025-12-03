package com.example.voiture.repositories;

import com.example.voiture.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // Méthodes CRUD de base fournies par JpaRepository

    // Vous pouvez ajouter des méthodes personnalisées ici, par exemple:
}