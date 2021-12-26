package com.epam.esm.model.entity;

import lombok.*;

import java.util.List;

@Value
@Builder
public class Certificate {

    Long id;

    double price;

    int duration;

    String name;

    String description;

    String createDate;

    String lastUpdateDate;

    List<Tag> tags;

}
