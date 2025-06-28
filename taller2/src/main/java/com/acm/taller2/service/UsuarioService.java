package com.acm.taller2.service;

import com.acm.taller2.mappers.UsuarioMapper;
import com.acm.taller2.model.Usuario;
import com.acm.taller2.persistence.entities.UsuarioEntity;
import com.acm.taller2.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.save(UsuarioMapper.modelToEntity(usuario));
        return UsuarioMapper.entityToModel(usuarioEntity);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario findById(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).orElse(null);
        return usuarioEntity != null ? UsuarioMapper.entityToModel(usuarioEntity) : null;
    }

    public Usuario updateUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity =  usuarioRepository.save(UsuarioMapper.modelToEntity(usuario));
        return UsuarioMapper.entityToModel(usuarioEntity);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper::entityToModel).collect(Collectors.toList());
    }
}
