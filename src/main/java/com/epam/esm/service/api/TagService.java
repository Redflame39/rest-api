package com.epam.esm.service.api;

import com.epam.esm.model.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    boolean create(Tag tag);

    List<Tag> findAll();

    Optional<Tag> findById();

    Tag delete(Tag deleteId);

}
