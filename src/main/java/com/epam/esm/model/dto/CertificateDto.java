package com.epam.esm.model.dto;

import com.epam.esm.model.entity.Tag;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
public class CertificateDto {

    double price;

    int duration;

    @NonNull
    String name;

    @NonNull
    String description;

    @NonNull
    String createDate;

    @NonNull
    String lastUpdateDate;

    @NonNull
    List<Tag> tags;
}
