package br.com.bruno.goodpraticies.adapter.rest;

import br.com.bruno.goodpraticies.adapter.dto.*;
import br.com.bruno.goodpraticies.adapter.mapper.ClientMapper;
import br.com.bruno.goodpraticies.core.port.ClientServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ClientControllerAdapter implements ClientController {

    private final ClientServicePort clientServicePort;
    private final ClientMapper clientMapper;

    @Override
    public WrapperResponse<ClientCreateResponse> create(ClientCreateRequest request) {
        return WrapperResponse.<ClientCreateResponse>builder()
                .data(clientMapper.toResponse(clientServicePort.create(clientMapper.toDomain(request))))
                .status(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .build();
    }

    @Override
    public WrapperResponse<ClientUpdateResponse> update(UUID id, ClientUpdateRequest request) {
        return WrapperResponse.<ClientUpdateResponse>builder()
                .data(clientMapper.toResponseUpdate(clientServicePort.update(clientMapper.toDomain(request), id)))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    @Override
    public WrapperResponse<List<ClientFindAllResponse>> findAll() {
        return WrapperResponse.<List<ClientFindAllResponse>>builder()
                .data(clientMapper.toResponse(clientServicePort.findAll()))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    @Override
    public WrapperResponse<ClientFindByIdResponse> findById(UUID id) {
        return WrapperResponse.<ClientFindByIdResponse>builder()
                .data(clientMapper.toResponseFindById(clientServicePort.findById(id)))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    @Override
    public WrapperResponse<Void> delete(UUID id) {
        clientServicePort.delete(id);
        return WrapperResponse.<Void>builder()
                .data(null)
                .status(HttpStatus.NO_CONTENT.value())
                .message(HttpStatus.NO_CONTENT.getReasonPhrase())
                .build();
    }
}
