package com.gomez.SongsAPI.service.impl;

import com.gomez.SongsAPI.entities.Composer;
import com.gomez.SongsAPI.entities.Song;
import com.gomez.SongsAPI.repositories.ComposerRepository;
import com.gomez.SongsAPI.service.ComposerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComposerServiceImpl implements ComposerService {

    private final ComposerRepository composerRepository;

    public ComposerServiceImpl(ComposerRepository composerRepository) {
        this.composerRepository = composerRepository;
    }

    @Override
    public List<Composer> findAll() {
        return composerRepository.findAll();
    }

    @Override
    public Optional<Composer> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return composerRepository.findById(id);
    }

    @Override
    public boolean deleteAll() {
        composerRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        composerRepository.deleteById(id);
        return true;
    }

    @Override
    public Composer save(Composer composer) {
        return composerRepository.save(composer);
    }

    @Override
    public Optional<Composer> findByArtisticName(String name) {
        if(name == null)
            return Optional.empty();

        return composerRepository.findByArtisticNameIgnoreCase(name);
    }

    @Override
    public List<Composer> findByAlbumName(String name) {
        return composerRepository.findAllByAlbumsNameIgnoreCase(name);
    }

    @Override
    public List<Composer> findBySongsTittle(String tittle) {
        return composerRepository.findAllByWrittenSongsTittleIgnoreCase(tittle);
    }
}
