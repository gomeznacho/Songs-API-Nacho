package com.gomez.SongsAPI.controllers;

import com.gomez.SongsAPI.entities.Album;
import com.gomez.SongsAPI.entities.Song;
import com.gomez.SongsAPI.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/songs")
public class SongController {

    private final SongService songService;


    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public List<Song> findAllSongs(){
        return songService.findAll();
    }

    @GetMapping("/id")
    public ResponseEntity<Song> findById(@RequestParam(required = false)Long id){
        Optional<Song> songOpt = songService.findById(id);
        if(songOpt.isEmpty())
            return ResponseEntity.notFound().build();
        Song song = songOpt.get();
        return ResponseEntity.ok(song);
    }

    @GetMapping("/song")
    public ResponseEntity<Song> findByTitle(@RequestParam(required = false)String tittle){
        Optional<Song> songOpt = songService.findByTittle(tittle);
        if(songOpt.isEmpty())
            return ResponseEntity.notFound().build();
        Song song = songOpt.get();
        return ResponseEntity.ok(song);
    }
    @GetMapping("/composer")
    public List<Song> findByComposer(@RequestParam(required = false)String name){

        return songService.findByComposerName(name);
    }

    @GetMapping("/album")
    public List<Song> findByAlbum(@RequestParam(required = false)String name){

        return songService.findByAlbumName(name);
    }

    @GetMapping("/videoclip")
    public List<Song> findByVideoClip(){
        return songService.findByVideoClip();
    }

    @PostMapping("/song")
    public ResponseEntity<Song> postSong(@RequestBody Song song){

        if(song.getId() != null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(songService.save(song));
    }

    @PutMapping("/song")
    public ResponseEntity<Song> updateSong(@RequestBody Song song){

        if(song.getId() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(songService.save(song));
    }

    @DeleteMapping("/song")
    public ResponseEntity<Song> deleteSong(@RequestParam Long id){
        if(id==null || id <= 0)
            return ResponseEntity.badRequest().build();

        if(songService.deleteById(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/all")
    public ResponseEntity<Song> deleteAll(){
        songService.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
