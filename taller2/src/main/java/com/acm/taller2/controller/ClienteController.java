package com.acm.taller2.controller;

import com.acm.taller2.dto.ClienteDTO;
import com.acm.taller2.mappers.ClienteMapper;
import com.acm.taller2.model.Cliente;
import com.acm.taller2.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Recibe un DTO de cliente en el cuerpo de la petición y lo persiste en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Cliente creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody ClienteDTO cliente) {
        Cliente nuevo = clienteService.saveCliente(ClienteMapper.dtoToModel(cliente));
        return ResponseEntity.ok(nuevo);
    }

    @Operation(
            summary = "Actualizar un cliente existente",
            description = "Recibe un DTO de cliente con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró un cliente con el ID proporcionado")
    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@Valid @RequestBody ClienteDTO cliente) {
        Cliente actualizado = clienteService.updateCliente(ClienteMapper.dtoToModel(cliente));
        return ResponseEntity.ok(actualizado);
    }

    @Operation(
            summary = "Obtener un cliente por su ID",
            description = "Devuelve los detalles de un cliente existente. Se debe proporcionar el ID como parte de la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Cliente encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún cliente con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(
            summary = "Listar todos los clientes",
            description = "Retorna una lista con todos los clientes almacenados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de clientes retornada correctamente")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> lista = clienteService.findAll();
        return ResponseEntity.ok(lista);
    }

    @Operation(
            summary = "Eliminar un cliente por su ID",
            description = "Elimina el cliente identificado por el ID. Retorna HTTP 204 cuando la operación es exitosa."
    )
    @ApiResponse(responseCode = "204", description = "Cliente eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún cliente con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}