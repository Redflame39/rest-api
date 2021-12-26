package com.epam.esm.model.dto;

import com.epam.esm.model.entity.Tag;
import lombok.Data;

import java.util.List;

@Data
public class CertificateDto {

    Long id;

    double price;

    int duration;

    String name;

    String description;

    String createDate;

    String lastUpdateDate;

    List<TagDto> tags;
}
