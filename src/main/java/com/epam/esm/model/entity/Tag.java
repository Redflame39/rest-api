package com.epam.esm.model.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Tag {

    Long id;

    String name;

}
