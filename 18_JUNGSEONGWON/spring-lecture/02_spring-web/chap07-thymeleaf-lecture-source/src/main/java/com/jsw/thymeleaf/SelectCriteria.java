package com.jsw.thymeleaf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SelectCriteria {

    private int startPage;
    private int endPage;
    private int pageNo;

    public SelectCriteria(int endPage, int pageNo, int startPage) {
        this.endPage = endPage;
        this.pageNo = pageNo;
        this.startPage = startPage;
    }
}
