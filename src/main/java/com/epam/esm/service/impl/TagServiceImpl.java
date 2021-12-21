package com.epam.esm.service.impl;

import com.epam.esm.dao.api.TagDao;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.service.api.TagService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class TagServiceImpl implements TagService {

    private final TagDao<Tag, Long> dao;

    @Autowired
    public TagServiceImpl(TagDao<Tag, Long> dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(Tag tag) throws ServiceException {
        return false;
    }

    @Override
    public List<Tag> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Tag> findById() throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Tag delete(Tag deleteId) throws ServiceException {
        return null;
    }
}
