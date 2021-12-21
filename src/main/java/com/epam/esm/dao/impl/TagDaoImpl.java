package com.epam.esm.dao.impl;

import com.epam.esm.dao.api.TagDao;
import com.epam.esm.exception.DaoException;
import com.epam.esm.model.entity.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j2
@Repository
public class TagDaoImpl implements TagDao<Tag, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TagDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tag> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Tag> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean create(Tag tag) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Long deleteId) throws DaoException {
        return false;
    }
}