package com.gomez.SongsAPI.service.impl;

import com.gomez.SongsAPI.entities.Album;
import com.gomez.SongsAPI.entities.Song;
import com.gomez.SongsAPI.repositories.SongRepository;
import com.gomez.SongsAPI.service.SongService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public Optional<Song> findByTittle(String tittle) {
        Optional<Song> songOpt = songRepository.findByTittleIgnoreCase(tittle);
        if(songOpt.isEmpty())
            return Optional.empty();
        return songOpt;
    }

    @Override
    public List<Song> findByComposerName(String artist) {
        return songRepository.findAllByComposersArtisticNameIgnoreCase(artist);
    }

    @Override
    public List<Song> findByAlbumName(String album) {
        return songRepository.findAllByAlbumNameIgnoreCase(album);
    }

    @Override
    public List<Song> findByVideoClip() {
        return songRepository.findAllByVideoclipNotNull();
    }

    @Override
    public List<Song> findByDateYear(Integer year) {
        LocalDateTime start = LocalDateTime.of(year, 1, 1,0, 0);
        LocalDateTime end = start.plusYears(1);

        return songRepository.findAllByReleaseDateBetween(start, end);
    }

    @Override
    public List<Song> findByDateMonth(Integer year, Integer month) {
        LocalDateTime start = LocalDateTime.of(year, month, 1,0, 0);
        LocalDateTime end = start.plusMonths(1);
        return songRepository.findAllByReleaseDateBetween(start, end);
    }
}
