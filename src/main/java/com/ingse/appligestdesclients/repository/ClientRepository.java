package com.ingse.appligestdesclients.repository;

import com.ingse.appligestdesclients.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    //List<Personne> findByNomOrderByPrenomAsc(String nom)
    List<Client> findClientByEntreprise(String entreprise);
}
