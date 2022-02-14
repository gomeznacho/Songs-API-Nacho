package com.gomez.SongsAPI.service;

import com.gomez.SongsAPI.entities.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> findAll();

    Optional<Song> findById(Long id);

    Song save(Song song);

    boolean deleteById(Long id);

    boolean deleteAll();
}
