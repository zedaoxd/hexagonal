package br.com.bruno.goodpraticies.adapter.repository;

import br.com.bruno.goodpraticies.adapter.mapper.ClientMapper;
import br.com.bruno.goodpraticies.core.domain.Client;
import br.com.bruno.goodpraticies.core.port.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepositoryPort {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Optional<Client> findById(UUID id) {
        return clientRepository.findByIdAndDeletedIsFalse(id).map(clientMapper::toDomain);
    }

    @Override
    public List<Client> findAllNotDeleted() {
        return clientMapper.toDomain(clientRepository.findAllByDeletedIsFalse());
    }

    @Override
    public Client save(Client client) {
        var entity = clientMapper.toEntity(client);
        return clientMapper.toDomain(clientRepository.save(entity));
    }

    @Override
    public void delete(UUID id) {
        var entity = clientRepository.findById(id).orElseThrow();
        entity.setDeleted(true);
        clientRepository.save(entity);
    }
}
