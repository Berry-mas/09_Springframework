package com.ohgiraffers.section01.autowired.common;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BookDTO {

    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private Date createdDate;

}
