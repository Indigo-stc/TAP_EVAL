package com.ista.music.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_song")
    private Integer id_song;
    private String title;
    private String artist;
    private String album;
    private Date year;
    @ManyToOne
    @JoinColumn(name = "id_playList")
    private PlayList playList;

}
