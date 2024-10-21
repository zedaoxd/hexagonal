package br.com.bruno.goodpraticies.core.port;

import br.com.bruno.goodpraticies.core.domain.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryPort {

    Optional<Client> findById(UUID id);
    List<Client> findAllNotDeleted();
    Client save(Client client);
    void delete(UUID id);
}
