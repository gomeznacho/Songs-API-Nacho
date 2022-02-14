package com.gomez.SongsAPI.service;

import com.gomez.SongsAPI.entities.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAllAlbums();

    Optional<Album> findById(Long id);

    Album save(Album album);

    boolean deleteById(Long id);

    boolean deleteAll();
}
