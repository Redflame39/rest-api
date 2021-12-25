package com.epam.esm.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
@SuperBuilder
public class Certificate extends Entity {

    double price;

    int duration;

    String name;

    String description;

    String createDate;

    String lastUpdateDate;

    List<Tag> tags;

}
