package com.ista.music.repository;

import com.ista.music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Integer> {

}
