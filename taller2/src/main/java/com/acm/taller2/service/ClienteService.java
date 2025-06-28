package com.acm.taller2.service;


import com.acm.taller2.mappers.ClienteMapper;
import com.acm.taller2.model.Cliente;
import com.acm.taller2.persistence.entities.ClienteEntity;
import com.acm.taller2.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente saveCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clienteRepository.save(ClienteMapper.modelToEntity(cliente));
        return ClienteMapper.entityToModel(clienteEntity);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente findById(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElse(null);
        return clienteEntity != null ? ClienteMapper.entityToModel(clienteEntity) : null;
    }

    public Cliente updateCliente(Cliente cliente) {
        ClienteEntity clienteEntity =  clienteRepository.save(ClienteMapper.modelToEntity(cliente));
        return ClienteMapper.entityToModel(clienteEntity);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll().stream().map(ClienteMapper::entityToModel).collect(Collectors.toList());
    }
}
