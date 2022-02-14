package com.gomez.SongsAPI.repositories;

import com.gomez.SongsAPI.entities.Composer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComposerRepository extends JpaRepository<Composer, Long> {

    Optional<Composer> findByArtisticNameIgnoreCase(String artisticName);

    List<Composer> findAllByAlbumsNameIgnoreCase(String name);

    List<Composer> findAllByWrittenSongsTittleIgnoreCase(String tittle);

}
