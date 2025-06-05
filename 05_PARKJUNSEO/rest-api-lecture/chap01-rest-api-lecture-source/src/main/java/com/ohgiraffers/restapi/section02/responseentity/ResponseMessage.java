package com.ohgiraffers.restapi.section02.responseentity;

import lombok.*;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {

    private int httpStatus;
    private String message;
    private Map<String, Object> results;

}
