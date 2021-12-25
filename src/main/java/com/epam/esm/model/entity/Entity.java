package com.epam.esm.model.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class Entity {

    protected Long id;

}
