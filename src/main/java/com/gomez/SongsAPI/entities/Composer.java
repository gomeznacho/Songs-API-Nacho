package com.gomez.SongsAPI.entities;

import javax.persistence.*;

@Entity
public class Composer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="artistic_name")
    private String artisticName;


}
