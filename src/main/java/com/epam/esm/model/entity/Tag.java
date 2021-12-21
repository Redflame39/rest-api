package com.epam.esm.model.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Value
@SuperBuilder
public class Tag extends Entity {

    int id;

    @NonNull
    String name;

}
