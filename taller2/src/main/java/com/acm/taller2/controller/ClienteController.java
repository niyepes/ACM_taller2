package com.acm.taller2.controller;

import com.acm.taller2.dto.ClienteDTO;
import com.acm.taller2.mappers.ClienteMapper;
import com.acm.taller2.model.Cliente;
import com.acm.taller2.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(clienteService.saveCliente(ClienteMapper.dtoToModel(cliente)));
    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@Valid @RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(clienteService.updateCliente(ClienteMapper.dtoToModel(cliente)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
