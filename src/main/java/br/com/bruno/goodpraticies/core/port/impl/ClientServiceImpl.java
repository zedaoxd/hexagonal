package br.com.bruno.goodpraticies.core.port.impl;

import br.com.bruno.goodpraticies.core.domain.Client;
import br.com.bruno.goodpraticies.core.port.ClientServicePort;
import br.com.bruno.goodpraticies.core.port.ClientRepositoryPort;

import java.util.List;
import java.util.UUID;

public class ClientServiceImpl implements ClientServicePort {

    private final ClientRepositoryPort clientRepository;

    public ClientServiceImpl(ClientRepositoryPort clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, UUID id) {
        var entity = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        mapProperties(client, entity);

        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAllNotDeleted();
    }

    @Override
    public Client findById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public void delete(UUID id) {
        clientRepository.delete(id);
    }

    private void mapProperties(Client source, Client target) {
        if (source.getName() != null) {
            target.setName(source.getName());
        }

        if (source.getEmail() != null) {
            target.setEmail(source.getEmail());
        }
    }
}
