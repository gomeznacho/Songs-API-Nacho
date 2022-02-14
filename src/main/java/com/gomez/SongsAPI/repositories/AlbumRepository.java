package com.gomez.SongsAPI.repositories;

import com.gomez.SongsAPI.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findAllByNameIgnoreCase(String name);

    List<Album> findAllByComposerArtisticNameIgnoreCase(String name);

    Optional<Album> findBySongsTittleIgnoreCase(String tittle);
}
