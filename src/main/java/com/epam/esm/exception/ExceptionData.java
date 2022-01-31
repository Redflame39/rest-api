package com.epam.esm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class ExceptionData {

    String name;

    String message;

    Integer code;

}
