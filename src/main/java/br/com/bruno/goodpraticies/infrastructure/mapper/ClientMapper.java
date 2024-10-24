package br.com.bruno.goodpraticies.infrastructure.mapper;

import br.com.bruno.goodpraticies.infrastructure.entity.ClientEntity;
import br.com.bruno.goodpraticies.core.domain.Client;
import br.com.bruno.goodpraticies.infrastructure.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    Client toDomain(ClientCreateRequest request);

    @Mapping(target = "id", ignore = true)
    Client toDomain(ClientUpdateRequest request);

    Client toDomain(ClientEntity entity);

    List<Client> toDomain(List<ClientEntity> entities);

    ClientCreateResponse toResponse(Client client);

    ClientUpdateResponse toResponseUpdate(Client client);

    List<ClientFindAllResponse> toResponse(List<Client> clients);

    ClientFindByIdResponse toResponseFindById(Client client);

    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    ClientEntity toEntity(Client client);}
