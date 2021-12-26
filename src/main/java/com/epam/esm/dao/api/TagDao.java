package com.epam.esm.dao.api;

import com.epam.esm.dao.TagColumnName;
import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.entity.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface TagDao<K> {

    RowMapper<Tag> TAG_MAPPER = (ResultSet rs, int rowNum) ->
            Tag.builder()
                    .id(rs.getLong(TagColumnName.ID))
                    .name(rs.getString(TagColumnName.NAME))
                    .build();

    List<Tag> findAll();

    Optional<Tag> findById(K id);

    boolean create(TagDto t);

    boolean delete(K deleteId);

    Optional<Tag> findByName(String name);

    List<Tag> findByCertificateId(K id);

}
