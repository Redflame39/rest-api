package com.epam.esm.service.impl;

import com.epam.esm.dao.api.TagDao;
import com.epam.esm.exception.EntityNotFoundException;
import com.epam.esm.exception.EntityNotUpdatedException;
import com.epam.esm.model.dto.TagDto;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.service.api.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagDao<Long> dao;

    @Autowired
    public TagServiceImpl(TagDao<Long> dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(TagDto tag) {
        return dao.create(tag);
    }

    @Override
    public List<Tag> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Tag delete(Long deleteId) {
        Optional<Tag> old = findById(deleteId);
        if (!old.isPresent()) {
            throw new EntityNotFoundException("Cannot find entity to delete");
        }
        boolean deleted = dao.delete(deleteId);
        if (!deleted) {
            throw new EntityNotUpdatedException("Delete wasn't carried out");
        }
        return old.get();
    }
}
