package com.epam.esm.dao.impl;

import com.epam.esm.dao.CertificateQuery;
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
        return jdbcTemplate.query(CertificateQuery.SQL_FIND_ALL, CERTIFICATE_MAPPER);
    }

    @Override
    public Optional<Certificate> findById(Long id) {
        Certificate result = jdbcTemplate.queryForObject(CertificateQuery.SQL_FIND_ID, CERTIFICATE_MAPPER, id);
        return Optional.ofNullable(result);
    }

    @Override
    public boolean create(Certificate certificate) {
        int affectedRows = jdbcTemplate.update(CertificateQuery.SQL_CREATE,
                certificate.getName(),
                certificate.getDescription(),
                certificate.getPrice(),
                certificate.getDuration(),
                certificate.getCreateDate(),
                certificate.getLastUpdateDate());

        return affectedRows > 0;
    }

    @Override
    public boolean update(Long updateId, Certificate replacement) {
        int affectedRows = jdbcTemplate.update(CertificateQuery.SQL_UPDATE,
                replacement.getName(),
                replacement.getDescription(),
                replacement.getPrice(),
                replacement.getDuration(),
                replacement.getCreateDate(),
                replacement.getLastUpdateDate(),
                updateId);

        return affectedRows > 0;
    }

    @Override
    public boolean delete(Long deleteId) {
        int affectedRows = jdbcTemplate.update(CertificateQuery.SQL_DELETE,
                deleteId);

        return affectedRows > 0;
    }
}
