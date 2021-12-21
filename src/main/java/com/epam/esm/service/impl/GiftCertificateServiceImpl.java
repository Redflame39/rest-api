package com.epam.esm.service.impl;

import com.epam.esm.dao.api.GiftCertificateDao;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.service.api.GiftCertificateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private final GiftCertificateDao<GiftCertificate, Long> dao;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDao<GiftCertificate, Long> dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(GiftCertificate giftCertificate) throws ServiceException {
        return false;
    }

    @Override
    public List<GiftCertificate> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<GiftCertificate> findById() throws ServiceException {
        return Optional.empty();
    }

    @Override
    public GiftCertificate update(Long updateId, GiftCertificate replacement) throws ServiceException {
        return null;
    }

    @Override
    public GiftCertificate delete(Long deleteId) throws ServiceException {
        return null;
    }
}
