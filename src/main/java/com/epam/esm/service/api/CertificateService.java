package com.epam.esm.service.api;

import com.epam.esm.model.entity.Certificate;

import java.util.List;
import java.util.Optional;

public interface CertificateService {

    boolean create(Certificate giftCertificate);

    List<Certificate> findAll();

    Optional<Certificate> findById();

    Certificate update(Long updateId, Certificate replacement);

    Certificate delete(Long deleteId);

}
