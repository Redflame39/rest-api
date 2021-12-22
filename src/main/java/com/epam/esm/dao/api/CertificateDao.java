package com.epam.esm.dao.api;

import com.epam.esm.model.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface CertificateDao<T extends Entity, K> {

    List<T> findAll();

    Optional<T> findById(K id);

    boolean create(T t);

    boolean update(K updateId, T replacement);

    boolean delete(K deleteId);
}
