package com.epam.esm.dao.api;

import com.epam.esm.dao.CertificateColumnName;
import com.epam.esm.dao.TagColumnName;
import com.epam.esm.model.entity.Certificate;
import com.epam.esm.model.entity.Entity;
import com.epam.esm.model.entity.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface TagDao<T extends Entity, K> {

    RowMapper<Tag> TAG_MAPPER = (ResultSet rs, int rowNum) ->
            Tag.builder()
                    .id(rs.getLong(TagColumnName.ID))
                    .name(rs.getString(TagColumnName.NAME))
                    .build();

    List<T> findAll();

    Optional<T> findById(K id);

    Optional<T> findByName(String name);

    List<T> findByCertificateId(K id);

    boolean create(T t);

    boolean delete(K deleteId);

}
