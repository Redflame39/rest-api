package com.epam.esm.service.impl;

import com.epam.esm.dao.api.CertificateDao;
import com.epam.esm.model.entity.Certificate;
import com.epam.esm.service.api.CertificateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CertificateServiceImpl implements CertificateService {

    private final CertificateDao<Certificate, Long> dao;

    @Autowired
    public CertificateServiceImpl(CertificateDao<Certificate, Long> dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(Certificate giftCertificate) {
        return false;
    }

    @Override
    public List<Certificate> findAll() {
        return null;
    }

    @Override
    public Optional<Certificate> findById() {
        return Optional.empty();
    }

    @Override
    public Certificate update(Long updateId, Certificate replacement) {
        return null;
    }

    @Override
    public Certificate delete(Long deleteId) {
        return null;
    }
}
