package com.ohgiraffers.entity.section02.embeddable.subsection02.secondary.table;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WriterInfo {

    @Column(name="self_introduction", table="tbl_writer_info")
    private String selfIntroduction;
}
