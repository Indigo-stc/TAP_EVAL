package com.ista.music.service;

import com.ista.music.model.PlayList;
import com.ista.music.repository.PlayListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayListServiceImpl extends GenericServiceImpl<PlayList, Integer> implements PlayListService{

    @Autowired
    PlayListRepo repo;

    @Override
    public CrudRepository<PlayList, Integer> getDao() {
        return repo;
    }

}
