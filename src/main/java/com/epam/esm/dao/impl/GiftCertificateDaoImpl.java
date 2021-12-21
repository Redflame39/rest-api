package com.epam.esm.dao.impl;

import com.epam.esm.dao.api.GiftCertificateDao;
import com.epam.esm.exception.DaoException;
import com.epam.esm.model.entity.GiftCertificate;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j2
@Repository
public class GiftCertificateDaoImpl implements GiftCertificateDao<GiftCertificate, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GiftCertificate> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<GiftCertificate> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean create(GiftCertificate giftCertificate) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Long updateId, GiftCertificate replacement) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Long deleteId) throws DaoException {
        return false;
    }
}
