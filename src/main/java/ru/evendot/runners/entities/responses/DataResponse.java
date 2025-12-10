package ru.evendot.runners.entities.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataResponse {
    private String message;
    private Object data;
}
