package com.epam.esm.dao.api;

import com.epam.esm.model.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface TagDao<T extends Entity, K> {

    List<T> findAll();

    Optional<T> findById(K id);

    boolean create(T t);

    boolean delete(K deleteId);

}
