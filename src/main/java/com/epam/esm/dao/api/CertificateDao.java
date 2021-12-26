package com.epam.esm.dao.api;

import com.epam.esm.dao.CertificateColumnName;
import com.epam.esm.model.dto.CertificateDto;
import com.epam.esm.model.entity.Certificate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface CertificateDao<K> {

    RowMapper<Certificate> CERTIFICATE_MAPPER = (ResultSet rs, int rowNum) ->
            Certificate.builder()
                    .id(rs.getLong(CertificateColumnName.ID))
                    .name(rs.getString(CertificateColumnName.NAME))
                    .description(rs.getString(CertificateColumnName.DESCRIPTION))
                    .price(rs.getDouble(CertificateColumnName.PRICE))
                    .duration(rs.getInt(CertificateColumnName.DURATION))
                    .createDate(rs.getString(CertificateColumnName.CREATE_DATE))
                    .lastUpdateDate(rs.getString(CertificateColumnName.LAST_UPDATE_DATE))
                    .build();

    List<Certificate> findAll();

    Optional<Certificate> findById(K id);

    boolean create(CertificateDto t);

    boolean update(K updateId, CertificateDto replacement);

    boolean delete(K deleteId);


}
