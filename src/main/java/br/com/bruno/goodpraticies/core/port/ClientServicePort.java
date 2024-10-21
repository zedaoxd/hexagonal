package br.com.bruno.goodpraticies.core.port;

import br.com.bruno.goodpraticies.core.domain.Client;

import java.util.List;
import java.util.UUID;

public interface ClientServicePort {

    Client create(Client client);
    Client update(Client client, UUID id);
    List<Client> findAll();
    Client findById(UUID id);
    void delete(UUID id);
}
