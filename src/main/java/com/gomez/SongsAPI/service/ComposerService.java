package com.gomez.SongsAPI.service;

import com.gomez.SongsAPI.entities.Composer;
import com.gomez.SongsAPI.entities.Song;

import java.util.List;
import java.util.Optional;

public interface ComposerService {
    List<Composer> findAll();

    Optional<Composer> findById(Long id);

    boolean deleteAll();

    boolean deleteById(Long id);

    Composer save(Composer composer);

    Optional<Composer> findByArtisticName(String name);

    List<Composer> findByAlbumName(String name);

    List<Composer> findBySongsTittle(String tittle);
}
