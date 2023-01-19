package com.ista.music.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_playList")
    private Integer id_playList;
    private String nombre;
    private String description;
    @OneToMany(mappedBy = "playList")
    private List<Song> songs = new ArrayList<>();

}
