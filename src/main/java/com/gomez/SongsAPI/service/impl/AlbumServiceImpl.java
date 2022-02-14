package com.gomez.SongsAPI.service.impl;

import com.gomez.SongsAPI.entities.Album;
import com.gomez.SongsAPI.repositories.AlbumRepository;
import com.gomez.SongsAPI.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long id) {
        if(id == null || id <=0)
            return Optional.empty();

        return albumRepository.findById(id);
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || id <= 0)
            return false;
        albumRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAll() {
        albumRepository.deleteAll();
        return true;
    }
}
