package com.epam.esm.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagDto {

    Long id;

    String name;

}
