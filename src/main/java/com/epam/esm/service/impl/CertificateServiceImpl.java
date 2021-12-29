package com.epam.esm.service.impl;

import com.epam.esm.dao.api.CertificateDao;
import com.epam.esm.dao.api.TagDao;
import com.epam.esm.exception.EntityNotFoundException;
import com.epam.esm.exception.EntityNotUpdatedException;
import com.epam.esm.model.dto.CertificateDto;
import com.epam.esm.model.entity.Certificate;
import com.epam.esm.service.api.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSXXX");
    private final CertificateDao<Long> certificateDao;
    private final TagDao<Long> tagDao;

    @Autowired
    public CertificateServiceImpl(CertificateDao<Long> certificateDao, TagDao<Long> tagDao) {
        this.certificateDao = certificateDao;
        this.tagDao = tagDao;
    }

    @Override
    public boolean create(CertificateDto certificate) {
        String currentDate = ZonedDateTime.now().format(FORMATTER);
        certificate.setCreateDate(currentDate);
        certificate.setLastUpdateDate(currentDate);
        boolean created = certificateDao.create(certificate);
        if (created) {
            certificate.getTags().forEach(tagDao::create);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Certificate> findAll() {
        return certificateDao.findAll();
    }

    @Override
    public Optional<Certificate> findById(Long id) {
        return certificateDao.findById(id);
    }

    @Override
    public Certificate update(Long updateId, CertificateDto replacement) {
        String currentDate = ZonedDateTime.now().format(FORMATTER);
        replacement.setLastUpdateDate(currentDate);
        boolean updated = certificateDao.update(updateId, replacement);
        if (!updated) {
            throw new EntityNotUpdatedException("Update wasn't carried out");
        }
        Optional<Certificate> upd = certificateDao.findById(updateId);
        if (!upd.isPresent()) {
            throw new EntityNotFoundException("Cannot found certificate, id: " + updateId);
        }
        return upd.get();
    }

    @Override
    public Certificate delete(Long deleteId) {
        Optional<Certificate> old = findById(deleteId);
        if (!old.isPresent()) {
            throw new EntityNotFoundException("Cannot find entity to delete");
        }
        boolean deleted = certificateDao.delete(deleteId);
        if (!deleted) {
            throw new EntityNotUpdatedException("Delete wasn't carried out");
        }
        return old.get();
    }
}
