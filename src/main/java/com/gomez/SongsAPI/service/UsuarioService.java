package com.gomez.SongsAPI.service;

import com.gomez.SongsAPI.dto.UsuarioDto;
import com.gomez.SongsAPI.entities.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario save(UsuarioDto usuario);

    boolean deleteById(Long id);

    void deleteAll();

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);
}



