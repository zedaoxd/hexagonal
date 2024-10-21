package br.com.bruno.goodpraticies.adapter.rest;

import br.com.bruno.goodpraticies.adapter.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/client")
public interface ClientController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    WrapperResponse<ClientCreateResponse> create(@RequestBody @Valid ClientCreateRequest request);

    @PutMapping("/{id}")
    WrapperResponse<ClientUpdateResponse> update(@PathVariable @Valid UUID id, @RequestBody @Valid ClientUpdateRequest request);

    @GetMapping
    WrapperResponse<List<ClientFindAllResponse>> findAll();

    @GetMapping("/{id}")
    WrapperResponse<ClientFindByIdResponse> findById(@PathVariable @Valid UUID id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    WrapperResponse<Void> delete(@PathVariable @Valid UUID id);
}
