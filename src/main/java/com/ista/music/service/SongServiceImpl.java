package com.ista.music.service;

import com.ista.music.model.Song;
import com.ista.music.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl extends GenericServiceImpl<Song, Integer> implements SongService {

    @Autowired
    SongRepo repo;
    @Override
    public CrudRepository<Song, Integer> getDao() {
        return repo;
    }

}
