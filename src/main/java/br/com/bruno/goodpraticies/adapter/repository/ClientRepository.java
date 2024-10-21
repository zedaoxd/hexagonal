package br.com.bruno.goodpraticies.adapter.repository;

import br.com.bruno.goodpraticies.adapter.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {

    List<ClientEntity> findAllByDeletedIsFalse();

    Optional<ClientEntity> findByIdAndDeletedIsFalse(UUID id);
}
