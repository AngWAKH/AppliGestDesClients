package com.ingse.appligestdesclients.controller;

import com.ingse.appligestdesclients.modele.Client;
import com.ingse.appligestdesclients.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Api("/clients")
@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    @ApiOperation(value = "Créer ou Ajouter un client", notes = "Cette méthode permet d'enregistrer ou " +
            "d'ajouter un client", response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client crée / ajouté"),
            @ApiResponse(code = 404, message = "Aucun Ajout n'a été effectuée dans la BBD"),
            @ApiResponse(code = 400, message = "L'objet client n'est oas valide !")
    })
    public Client create(@RequestBody Client client){
        return clientService.create(client);
    }
    /* ************************************************************************** */
    @GetMapping("/read")
    @ApiOperation(value = "Renvoi la liste des clients", notes = "Cette méthode permet de chercher et renvoyer " +
            "la liste des clients qui existent dans la BBD", responseContainer = "List<Client>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La listes des clients / une liste vide ")
    })
    @Transactional(readOnly = true)
    public List<Client> read(){
        return clientService.read();
    }
    /* ************************************************************************** */
    @GetMapping("/readbyId/{id}")
    @ApiOperation(value = "Rechercher un client par son IDClient", notes = "Cette méthode permet de chercher " +
            "un client par son idClient", responseContainer = "Optional <Client>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client à été trouvé dans BDD"),
            @ApiResponse(code = 404, message = "Aucun client n'existe dans la BDD avec l'idClient fourni")
    })
    public Optional<Client> readbyId(@PathVariable Long id, Client client){
        return clientService.readbyId(id);
    }
    /* ************************************************************************** */
    @GetMapping("/readbyentreprise/{entreprise}")
    @ApiOperation(value = "Rechercher un client par son entreprise", notes = "Cette méthode permet de chercher " +
            "un client par son entreprise")
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Le client à été trouvé dans BBD(ActiviteesDataBases)", responseContainer = "List<Client>"),
                    @ApiResponse(code =404, message = "Aucun client n'existe dans la BBD avec le nom de l'entreprise fourni")
    })
    public List<Client> readbyentreprise(@PathVariable String entreprise, Client client){
        return clientService.readbyentreprise(entreprise);
    }
    /* ************************************************************************** */
    @PutMapping("/update/{idClient}")
    @ApiOperation(value = "Modifier un client par son idClient", notes = "Cette méthode permet de modifier " +
            "une activité par son idActivite")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client à été modifié dans BBD"),
            @ApiResponse(code =404, message = "Aucune modification n'a été effectuée dans la BBD")
    })
    public Client update(@PathVariable Long idClient, Client client){
        return clientService.update(idClient, client);
    }
   /* ************************************************************************** */
    @DeleteMapping("/delete/{idClient}")
    @ApiOperation(value = "Supprimer un client par son idClient ",notes = "Cette méthode permet de " +
            "supprimer une activité par son idActivite", response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client à été supprimé dans BBD"),
            @ApiResponse(code =404, message = "Aucune supprission n'a été effectuée dans la BBD")
    })
    public String delete(@PathVariable Long idClient){

        return clientService.delete(idClient);
    }

}
