package com.epam.esm.service.api;

import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.GiftCertificate;

import java.util.List;
import java.util.Optional;

public interface GiftCertificateService {

    boolean create(GiftCertificate giftCertificate) throws ServiceException;

    List<GiftCertificate> findAll() throws ServiceException;

    Optional<GiftCertificate> findById() throws ServiceException;

    GiftCertificate update(Long updateId, GiftCertificate replacement) throws ServiceException;

    GiftCertificate delete(Long deleteId) throws ServiceException;

}
