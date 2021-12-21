package com.epam.esm.dao.api;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface GiftCertificateDao<T extends Entity, K> {

    List<T> findAll() throws DaoException;

    Optional<T> findById(K id) throws DaoException;

    boolean create(T t) throws DaoException;

    boolean update(K updateId, T replacement) throws DaoException;

    boolean delete(K deleteId) throws DaoException;
}
