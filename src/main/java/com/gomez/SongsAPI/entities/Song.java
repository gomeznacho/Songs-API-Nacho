package com.gomez.SongsAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="song_id")
    private Long id;

    private String tittle;

    @Column(name= "release_date")
    private LocalDate releaseDate;

    private URL videoclip;

    private URL url;

    @JsonIgnoreProperties(value={"songs", "composer"})
    @ManyToOne/*(fetch = FetchType.EAGER)*/
    @JoinColumn(name = "album_id", foreignKey=@ForeignKey(name="fk_album_id"))
    private Album album;

    @JsonIgnoreProperties(value={"songs", "albums", "writtenSongs"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="song_composer",
            joinColumns= @JoinColumn(name="song_id", foreignKey=@ForeignKey(name="fk_song_id")),
            inverseJoinColumns= @JoinColumn(name="composer_id", foreignKey=@ForeignKey(name="fk_composer_id")))
    private Set<Composer> composers;

    public Song() {
    }

    public Song(Long id, String tittle, LocalDate releaseDate, URL videoclip, URL url) {
        this.id = id;
        this.tittle = tittle;
        this.releaseDate = releaseDate;
        this.videoclip = videoclip;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }


    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public URL getVideoclip() {
        return videoclip;
    }

    public void setVideoclip(URL videoclip) {
        this.videoclip = videoclip;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Composer> getComposers() {
        return composers;
    }

    public void setComposers(Set<Composer> composers) {
        this.composers = composers;
    }
}
