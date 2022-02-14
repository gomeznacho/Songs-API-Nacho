package com.gomez.SongsAPI.controllers;

import com.gomez.SongsAPI.entities.Composer;
import com.gomez.SongsAPI.entities.Song;
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


    @GetMapping("/all")
    public List<Composer> findAllComposers(){
        return composerService.findAll();
    }

    @GetMapping("/id")
    public ResponseEntity<Composer> findById(@RequestParam(required = false)Long id){
        Optional<Composer> composerOpt = composerService.findById(id);
        if(composerOpt.isEmpty())
            return ResponseEntity.notFound().build();
        Composer composer = composerOpt.get();
        return ResponseEntity.ok(composer);
    }

    @GetMapping("/album")
    public List<Composer> findByAlbum(@RequestParam(required = false)String name){

        return composerService.findByAlbumName(name);
    }

    @GetMapping("")
    public ResponseEntity<Composer> findByName(@RequestParam(required = false)String name){
        Optional<Composer> composerOpt = composerService.findByArtisticName(name);
        if(composerOpt.isEmpty())
            return ResponseEntity.notFound().build();
        Composer composer = composerOpt.get();
        return ResponseEntity.ok(composer);
    }

    @GetMapping("/song")
    public  List<Composer> findBySongTittle(@RequestParam(required=false) String tittle){
        return composerService.findBySongsTittle(tittle);
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
