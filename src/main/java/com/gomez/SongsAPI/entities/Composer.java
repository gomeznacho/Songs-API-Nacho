package com.gomez.SongsAPI.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Composer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="composer_id")
    private Long id;

    @Column(name="artistic_name")
    private String artisticName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy="composers")
    private Set<Song> writtenSongs;

    public Composer(){}

    public Composer(Long id, String artisticName) {
        this.id = id;
        this.artisticName = artisticName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

}
