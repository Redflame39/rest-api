package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagQuery;
import com.epam.esm.dao.api.TagDao;
import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TagDaoImpl implements TagDao<Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TagDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tag> findAll() {
        return jdbcTemplate.query(TagQuery.SQL_FIND_ALL, TAG_MAPPER);
    }

    @Override
    public Optional<Tag> findById(Long id) {
        Tag result = jdbcTemplate.queryForObject(TagQuery.SQL_FIND_ID, TAG_MAPPER, id);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<Tag> findByName(String name) {
        Tag result = jdbcTemplate.queryForObject(TagQuery.SQL_FIND_NAME, TAG_MAPPER, name);
        return Optional.ofNullable(result);
    }

    @Override
    public List<Tag> findByCertificateId(Long id) {
        return jdbcTemplate.query(TagQuery.SQL_FIND_CERTIFICATE_ID, TAG_MAPPER, id);
    }

    @Override
    public boolean create(TagDto tag) {
        int affectedRows = jdbcTemplate.update(TagQuery.SQL_CREATE, tag.getName());

        return affectedRows > 0;
    }

    @Override
    public boolean delete(Long deleteId) {
        int affectedRows = jdbcTemplate.update(TagQuery.SQL_DELETE, deleteId);

        return affectedRows > 0;
    }

}