package com.gomez.SongsAPI.controllers;

import com.gomez.SongsAPI.entities.Album;

import com.gomez.SongsAPI.entities.Song;
import com.gomez.SongsAPI.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("")
    public List<Album> findAllAlbums(){
        return albumService.findAllAlbums();
    }

    @GetMapping("/album")
    public ResponseEntity<Album> findAlbumById(@RequestParam Long id){
        Optional<Album> albumOptional = albumService.findById(id);
        if(albumOptional.isPresent())
            return ResponseEntity.ok(albumOptional.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/album")
    public ResponseEntity<Album> postAlbum(@RequestBody Album album){
        if(album.getId() != null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(albumService.save(album));
    }

    @PutMapping("/album")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album album){

        if(album.getId() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(albumService.save(album));
    }

    @DeleteMapping("/album")
    public ResponseEntity<Album> deleteAlbum(@RequestBody Long id){
        if(id==null || id <= 0)
            return ResponseEntity.badRequest().build();
        if(albumService.deleteById(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/all")
    public ResponseEntity<Song> deleteAll(){
        albumService.deleteAll();

        return ResponseEntity.noContent().build();
    }

}
