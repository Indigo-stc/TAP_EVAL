package com.ista.music.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T, ID extends Serializable>{

    T save(T entity);

    T findById(ID id);

    List<T> findByAll();

    void delete(ID id);


}
