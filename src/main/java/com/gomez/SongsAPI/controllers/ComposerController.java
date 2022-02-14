package com.gomez.SongsAPI.controllers;

import com.gomez.SongsAPI.entities.Composer;
import com.gomez.SongsAPI.service.ComposerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/composers")
public class ComposerController {

    private final ComposerService composerService;

    public ComposerController(ComposerService composerService) {
        this.composerService = composerService;
    }


    @GetMapping("")
    public List<Composer> findAllComposers(){
        return composerService.findAll();
    }

    @GetMapping("/composer")
    public ResponseEntity<Composer> findById(@RequestParam(required = false)Long id){
        Optional<Composer> composerOpt = composerService.findById(id);
        if(composerOpt.isEmpty())
            return ResponseEntity.notFound().build();
        Composer composer = composerOpt.get();
        return ResponseEntity.ok(composer);
    }

    @PostMapping("/composer")
    public ResponseEntity<Composer> postComposer(@RequestBody Composer composer){

        if(composer.getId() != null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(composerService.save(composer));
    }

    @PutMapping("/composer")
    public ResponseEntity<Composer> updateComposer(@RequestBody Composer composer){

        if(composer.getId() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(composerService.save(composer));
    }

    @DeleteMapping("/composer")
    public ResponseEntity<Composer> deleteComposer(@RequestParam Long id){
        if(id==null || id <= 0)
            return ResponseEntity.badRequest().build();

        if(composerService.deleteById(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/all")
    public ResponseEntity<Composer> deleteAll(){
        composerService.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
