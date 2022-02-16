package com.gomez.SongsAPI.repositories;

import com.gomez.SongsAPI.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
