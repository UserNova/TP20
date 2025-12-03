package com.example.Client.controllers;

import com.example.Client.entities.Client;
import com.example.Client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")  // Préfixe de tous les endpoints de ce contrôleur
public class ClientController {

    @Autowired
    private ClientService service;

    /**
     * Récupère tous les clients
     * GET /api/client
     */
    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    /**
     * Récupère un client par son ID
     * GET /api/client/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Client client = service.findById(id);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erreur: " + e.getMessage());
        }
    }

    /**
     * Ajoute un nouveau client
     * POST /api/client
     */
    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client savedClient = service.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    /**
     * DELETE : supprimer un client
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteClient(id);
            return ResponseEntity.ok("Client supprimé avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erreur : " + e.getMessage());
        }
    }

    /**
     * PUT : mettre à jour un client
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody Client updatedClient) {

        try {
            Client client = service.updateClient(id, updatedClient);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erreur : " + e.getMessage());
        }
    }

    /**
     * GET : rechercher par nom
     * Exemple : /api/client/search?nom=ali
     */
    @GetMapping("/search")
    public List<Client> searchByName(@RequestParam String nom) {
        return service.findByNom(nom);
    }
}
