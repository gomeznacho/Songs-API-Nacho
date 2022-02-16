package com.gomez.SongsAPI.service.impl;

import com.gomez.SongsAPI.config.MyUserDetails;
import com.gomez.SongsAPI.dto.UsuarioDto;
import com.gomez.SongsAPI.entities.Usuario;
import com.gomez.SongsAPI.repositories.UsuarioRepository;
import com.gomez.SongsAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value="usuarioService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario == null)
            throw new UsernameNotFoundException("usuario no encontrado");

        return new MyUserDetails(usuario.getUsername(), usuario.getPassword(), usuario.getEmail());
    }

    @Override
    public Usuario save(UsuarioDto usuario) {
        Usuario usuarioTemp = usuario.getUserFromDto();
        if(usuarioRepository.existsByUsername(usuarioTemp.getUsername()) ||
            usuarioRepository.existsByEmail(usuarioTemp.getEmail()))
            throw new IllegalArgumentException("email o username ya registrados");
        usuarioTemp.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return usuarioRepository.save(usuarioTemp);
    }

    @Override
    public boolean deleteById(Long id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);

    }
}
