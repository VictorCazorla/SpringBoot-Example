package com.victorcazorla.billing.service;

import com.victorcazorla.billing.model.Client;
import com.victorcazorla.billing.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

        private final ClientRepository clientRepository;

        public ClientService(ClientRepository clientRepository) {
                this.clientRepository = clientRepository;
        }

        public Client addClient(Client newClient){
                return clientRepository.save(newClient);
        }

        public List<Client> getAllClients() {
                return clientRepository.findAll();
        }

        public Optional<Client> getClientById(Long id) {
                return clientRepository.findById(id);
        }

        public Client updateClient(Long id, Client updatedClient) {
                return clientRepository.findById(id)
                        .map(client -> {
                                client.setName(updatedClient.getName());
                                client.setEmail(updatedClient.getEmail());
                                client.setTlf(updatedClient.getTlf());
                                client.setAddr(updatedClient.getAddr());
                                return clientRepository.save(client);
                        })
                        .orElseThrow(() -> new RuntimeException("Client not found"));
        }

        public void deleteClient(Long id) {
                clientRepository.deleteById(id);
        }
}
