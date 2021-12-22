package com.epam.esm.dao.impl;

import com.epam.esm.dao.api.CertificateDao;
import com.epam.esm.model.entity.Certificate;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j2
@Repository
public class CertificateDaoImpl implements CertificateDao<Certificate, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CertificateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Certificate> findAll() {
        return null;
    }

    @Override
    public Optional<Certificate> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean create(Certificate giftCertificate) {
        return false;
    }

    @Override
    public boolean update(Long updateId, Certificate replacement) {
        return false;
    }

    @Override
    public boolean delete(Long deleteId) {
        return false;
    }
}
