package com.ingse.appligestdesclients.service;

import com.ingse.appligestdesclients.modele.Client;
import com.ingse.appligestdesclients.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    @Override
    public Client create(Client client) {

        return clientRepository.save(client);
    }
    @Override
    public List<Client> read() {

        return clientRepository.findAll();
    }

    @Override
    public Optional <Client> readbyId(Long id) {

        return clientRepository.findById(id);
    }

    @Override
    public List<Client> readbyentreprise(String entreprise) {

        return clientRepository.findClientByEntreprise(entreprise);
    }

    @Override
    public Client update(Long idClient, Client client) {
        return clientRepository.findById(idClient)
                .map(cl -> {
                    cl.setAdresse(client.getAdresse());
                    cl.setSiret(client.getSiret());
                    cl.setEmail(client.getEmail());
                    cl.setEntreprise(client.getEntreprise());
                    cl.setNumeroTVA(client.getNumeroTVA());
                    cl.setTelephone(client.getTelephone());
                    cl.setDateDePaiements(client.getDateDePaiements());
                    cl.setNombreDePaiements(client.getNombreDePaiements());
                    return clientRepository.save(cl);
                }).orElseThrow(()-> new RuntimeException("Client non trouvé !"));
    }

    @Override
    public String delete(Long idClient) {
        clientRepository.deleteById(idClient);
        return "Client supprimé ";
    }
}
