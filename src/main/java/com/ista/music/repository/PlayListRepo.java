package com.ista.music.repository;

import com.ista.music.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepo extends JpaRepository<PlayList, Integer> {

}
