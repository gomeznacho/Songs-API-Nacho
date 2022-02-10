package com.gomez.SongsAPI.entities;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String album;

    @Column(name= "release_date")
    private LocalDate releaseDate;

    private Boolean videoclip;

    private URL url;

    @ManyToMany
    @JoinTable(name = "song_artist",
            joinColumns = {
            @JoinColumn(name = "song_id")},
            inverseJoinColumns = {
            @JoinColumn(name = "artist_id")})
    Set<Composer> composers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getVideoclip() {
        return videoclip;
    }

    public void setVideoclip(Boolean videoclip) {
        this.videoclip = videoclip;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Set<Composer> getComposers() {
        return composers;
    }

    public void setComposers(Set<Composer> composers) {
        this.composers = composers;
    }
}
