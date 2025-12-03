package com.example.voiture;

import com.example.voiture.entities.Car;
import com.example.voiture.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataLoader(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(carRepository.count() == 0) {
            carRepository.save(new Car(1L, "Ford", "2022", "12 A 2345", 1L));
            carRepository.save(new Car(2L, "Renaut", "2000", "14 R 5245", 2L));
            carRepository.save(new Car(3L, "Toyota", "1990", "34 T 6755", 3L));
            carRepository.save(new Car(4L, "Ford", "2021", "44 R 6756", 2L));
        }
    }
}