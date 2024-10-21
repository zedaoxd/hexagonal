package br.com.bruno.goodpraticies.adapter.rest;

import br.com.bruno.goodpraticies.infrastructure.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.UUID;

public interface ClientController {

    @Operation(summary = "Create a new client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created", content = @Content(schema = @Schema(implementation = ClientCreateResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    WrapperResponse<ClientCreateResponse> create(
            @RequestBody(
                    description = "Client data",
                    required = true,
                    content = @Content(examples = {
                            @ExampleObject(name = "ClientCreateRequest", value = """
                                    {
                                        "name": "John Doe",
                                        "email": "johndoe@mail.com"
                                    }
                                    """)
                    }))
            ClientCreateRequest request);

    @Operation(summary = "Update a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client updated", content = @Content(schema = @Schema(implementation = ClientUpdateResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    WrapperResponse<ClientUpdateResponse> update(
            UUID id,
            @RequestBody(
                    description = "Client data",
                    required = true,
                    content = @Content(examples = {
                            @ExampleObject(name = "ClientUpdateRequest", value = """
                                    {
                                        "name": "John Doe",
                                        "email": "johndoe@mail.com"
                                    }
                                    """)
                    }))
            ClientUpdateRequest request);

    @Operation(summary = "Find all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clients found", content = @Content(schema = @Schema(implementation = ClientFindAllResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    WrapperResponse<List<ClientFindAllResponse>> findAll();

    @Operation(summary = "Find a client by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found", content = @Content(schema = @Schema(implementation = ClientFindByIdResponse.class))),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    WrapperResponse<ClientFindByIdResponse> findById(UUID id);

    @Operation(summary = "Delete a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Client deleted"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    WrapperResponse<Void> delete(UUID id);
}
