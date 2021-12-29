package com.epam.esm.converter;

import com.epam.esm.model.dto.CertificateDto;
import com.epam.esm.model.entity.Certificate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CertificateToCertificateDtoConverter implements Converter<Certificate, CertificateDto> {

    @Override
    public CertificateDto convert(Certificate source) {
        return CertificateDto.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .price(source.getPrice())
                .duration(source.getDuration())
                .createDate(source.getCreateDate())
                .lastUpdateDate(source.getLastUpdateDate())
                .build();
        // TODO: Tag to TagDto converter
    }


}
