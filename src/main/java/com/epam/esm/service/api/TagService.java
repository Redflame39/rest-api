package com.epam.esm.service.api;

import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    boolean create(TagDto tag);

    List<Tag> findAll();

    Optional<Tag> findById(Long id);

    Tag delete(Long deleteId);

}
