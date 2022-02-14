package com.gomez.SongsAPI.repositories;

import com.gomez.SongsAPI.entities.Album;
import com.gomez.SongsAPI.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<Song> findByTittleIgnoreCase(String tittle);

    List<Song> findAllByComposersArtisticNameIgnoreCase(String artist);

    List<Song> findAllByAlbumNameIgnoreCase(String album);

    List<Song> findAllByVideoclipNotNull();
}
