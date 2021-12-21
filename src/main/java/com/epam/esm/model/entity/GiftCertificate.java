package com.epam.esm.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
@SuperBuilder
public class GiftCertificate extends Entity {

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
