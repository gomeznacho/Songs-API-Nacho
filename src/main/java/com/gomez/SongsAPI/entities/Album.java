package com.gomez.SongsAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="album_id")
    private Long id;

    private String name;

    @JsonIgnoreProperties(value={"albums", "writtenSongs"})
    @ManyToOne
    @JoinColumn(name = "composer_id", foreignKey = @ForeignKey(name="fk_album_composer"))
    private Composer composer;

    @JsonIgnoreProperties(value="album")
    @OneToMany(fetch = FetchType.EAGER, mappedBy="album")
    private Set<Song> songs;

    public Album() {
    }

    public Album(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
