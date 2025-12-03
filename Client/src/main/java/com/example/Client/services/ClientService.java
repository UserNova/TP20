package com.example.Client.services;


import com.example.Client.entities.Client;
import com.example.Client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marque cette classe comme un composant Service
public class ClientService {

    @Autowired  // Injection de dépendance
    private ClientRepository clientRepository;

    /**
     * Récupère tous les clients de la base de données
     * @return Liste de tous les clients
     */
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    /**
     * Récupère un client par son identifiant
     * @param id Identifiant du client
     * @return Le client correspondant
     * @throws Exception Si aucun client n'est trouvé avec cet ID
     */
    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client non trouvé avec l'ID: " + id));
    }

    /**
     * Ajoute un nouveau client ou met à jour un client existant
     * @param client Le client à sauvegarder
     * @return Le client sauvegardé avec son ID généré
     */
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Supprime un client par son identifiant
     * @param id identifiant du client
     * @throws Exception si le client n'existe pas
     */
    public void deleteClient(Long id) throws Exception {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client introuvable avec l'ID: " + id));
        clientRepository.delete(client);
    }

    /**
     * Met à jour un client existant
     * @param id identifiant du client
     * @param updatedClient données mises à jour
     * @return client mis à jour
     * @throws Exception si le client n'existe pas
     */
    public Client updateClient(Long id, Client updatedClient) throws Exception {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client introuvable avec l'ID: " + id));

        client.setNom(updatedClient.getNom());
        client.setAge(updatedClient.getAge());

        return clientRepository.save(client);
    }

    /**
     * Recherche un client par son nom (insensible à la casse)
     * @param nom nom à chercher
     * @return liste des clients qui correspondent
     */
    public List<Client> findByNom(String nom) {
        return clientRepository.findByNomContainingIgnoreCase(nom);
    }
}
