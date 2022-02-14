package com.gomez.SongsAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @JsonIgnoreProperties(value="composers")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy="composers")
    private Set<Song> writtenSongs;

    @JsonIgnoreProperties(value={"composers","songs"})
    @OneToMany(fetch = FetchType.EAGER, mappedBy="composer")
    private Set<Album> albums;

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

    public Set<Song> getWrittenSongs() {
        return writtenSongs;
    }

    public void setWrittenSongs(Set<Song> writtenSongs) {
        this.writtenSongs = writtenSongs;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
