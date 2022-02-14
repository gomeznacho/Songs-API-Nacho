package com.gomez.SongsAPI.service.impl;

import com.gomez.SongsAPI.entities.Song;
import com.gomez.SongsAPI.repositories.SongRepository;
import com.gomez.SongsAPI.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAll() {
       return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        if(id ==null || id<= 0)
            return Optional.empty();

        return songRepository.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !songRepository.existsById(id))
            return false;

        songRepository.deleteById(id);

        return true;
    }

    @Override
    public boolean deleteAll() {
        songRepository.deleteAll();
        return true;
    }
}
