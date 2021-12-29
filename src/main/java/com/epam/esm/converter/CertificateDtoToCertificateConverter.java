package com.epam.esm.converter;

import com.epam.esm.model.dto.CertificateDto;
import com.epam.esm.model.entity.Certificate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CertificateDtoToCertificateConverter implements Converter<CertificateDto, Certificate> {

    @Override
    public Certificate convert(CertificateDto source) {
        return Certificate.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .price(source.getPrice())
                .duration(source.getDuration())
                .createDate(source.getCreateDate())
                .lastUpdateDate(source.getLastUpdateDate())
                .build();
        // TODO: TagDto to Tag converter
    }

}
