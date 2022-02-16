package com.gomez.SongsAPI.controllers;

import com.gomez.SongsAPI.config.TokenProvider;
import com.gomez.SongsAPI.dto.AuthToken;
import com.gomez.SongsAPI.dto.LoginUsuario;
import com.gomez.SongsAPI.dto.UsuarioDto;
import com.gomez.SongsAPI.entities.Usuario;
import com.gomez.SongsAPI.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/api/v1/user")
public class UsuarioController {

    private AuthenticationManager authenticationManager;
    private UsuarioService usuarioService;
    private TokenProvider tokenUtil;


    public UsuarioController(AuthenticationManager authenticationManager, UsuarioService usuarioService, TokenProvider tokenUtil) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.tokenUtil = tokenUtil;
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody UsuarioDto usuario){

        return usuarioService.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUsuario loginUsuario){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUsuario.getUsername(),
                        loginUsuario.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        final String token = tokenUtil.generateToken(auth);
        return ResponseEntity.ok(new AuthToken(token));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Usuario> deleteById(@RequestParam Long id){
        if(id==null || id<=0)
            return ResponseEntity.badRequest().build();
        if(usuarioService.deleteById(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/user")
    public ResponseEntity<Usuario> findById(@RequestParam Long id){
        if(id == null || id<=0)
            return ResponseEntity.badRequest().build();
        Optional<Usuario> usuarioOpt = usuarioService.findById(id);
        if(usuarioOpt.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioOpt.get());
    }

    @DeleteMapping("")
    public ResponseEntity<Usuario> deleteAll(){
        usuarioService.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
