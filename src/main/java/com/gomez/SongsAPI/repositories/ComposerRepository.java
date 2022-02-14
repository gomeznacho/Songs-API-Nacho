package com.gomez.SongsAPI.repositories;

import com.gomez.SongsAPI.entities.Composer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposerRepository extends JpaRepository<Composer, Long> {

}
