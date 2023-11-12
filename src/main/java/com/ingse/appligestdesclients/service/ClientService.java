package com.ingse.appligestdesclients.service;

import com.ingse.appligestdesclients.modele.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    //cette methode pour créer un client
    Client create(Client client);

    //cette methode pour retouner la liste des clients
    List<Client> read();

    Optional <Client> readbyId(Long idClient);


    List<Client> readbyentreprise(String entreprise);

    //cette methpde pour la mise à jour d'un client
    Client update(Long id, Client client);

    //cette methode pour supprimer un client
    String delete(Long idClient);



}
