package com.gomez.SongsAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="song_id")
    private Long id;

    @Column(nullable=false, length=50)
    private String tittle;

    @Column(name= "release_date")
    private LocalDateTime releaseDate;

    private URL videoclip;

    @Column(nullable=false)
    private URL url;

    @JsonIgnoreProperties(value={"songs", "composer"})
    @ManyToOne(fetch = FetchType.EAGER/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "album_id", foreignKey=@ForeignKey(name="fk_album_id"))
    private Album album;

    @JsonIgnoreProperties(value={"songs", "albums", "writtenSongs"})
    @ManyToMany(fetch = FetchType.EAGER/*, cascade = CascadeType.ALL*/)
    @JoinTable(name="song_composer",
            joinColumns= @JoinColumn(name="song_id", foreignKey=@ForeignKey(name="fk_song_id")),
            inverseJoinColumns= @JoinColumn(name="composer_id", foreignKey=@ForeignKey(name="fk_composer_id")))
    private Set<Composer> composers;

    public Song() {
    }

    public Song(Long id, String tittle, LocalDateTime releaseDate, URL videoclip, URL url) {
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


    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
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
