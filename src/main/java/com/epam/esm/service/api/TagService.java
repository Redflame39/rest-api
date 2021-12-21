package com.epam.esm.service.api;

import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    boolean create(Tag tag) throws ServiceException;

    List<Tag> findAll() throws ServiceException;

    Optional<Tag> findById() throws ServiceException;

    Tag delete(Tag deleteId) throws ServiceException;

}
