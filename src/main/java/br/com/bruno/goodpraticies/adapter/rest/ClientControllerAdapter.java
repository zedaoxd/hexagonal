package br.com.bruno.goodpraticies.adapter.rest;

import br.com.bruno.goodpraticies.infrastructure.dto.*;
import br.com.bruno.goodpraticies.infrastructure.mapper.ClientMapper;
import br.com.bruno.goodpraticies.core.port.ClientServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientControllerAdapter implements ClientController {

    private final ClientServicePort clientServicePort;
    private final ClientMapper clientMapper;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WrapperResponse<ClientCreateResponse> create(ClientCreateRequest request) {
        return WrapperResponse.<ClientCreateResponse>builder()
                .data(clientMapper.toResponse(clientServicePort.create(clientMapper.toDomain(request))))
                .status(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .build();
    }

    @Override
    @PutMapping("/{id}")
    public WrapperResponse<ClientUpdateResponse> update(@PathVariable @Valid UUID id,
                                                        @RequestBody @Valid ClientUpdateRequest request) {
        return WrapperResponse.<ClientUpdateResponse>builder()
                .data(clientMapper.toResponseUpdate(clientServicePort.update(clientMapper.toDomain(request), id)))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    @Override
    @GetMapping
    public WrapperResponse<List<ClientFindAllResponse>> findAll() {
        return WrapperResponse.<List<ClientFindAllResponse>>builder()
                .data(clientMapper.toResponse(clientServicePort.findAll()))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    @Override
    @GetMapping("/{id}")
    public WrapperResponse<ClientFindByIdResponse> findById(@PathVariable @Valid UUID id) {
        return WrapperResponse.<ClientFindByIdResponse>builder()
                .data(clientMapper.toResponseFindById(clientServicePort.findById(id)))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public WrapperResponse<Void> delete(@PathVariable @Valid UUID id) {
        clientServicePort.delete(id);
        return WrapperResponse.<Void>builder()
                .data(null)
                .status(HttpStatus.NO_CONTENT.value())
                .message(HttpStatus.NO_CONTENT.getReasonPhrase())
                .build();
    }
}
