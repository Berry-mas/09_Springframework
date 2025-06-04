package com.ohgiraffers.entity.section02.embeddable.subsection02.secondary.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* @SecondaryTable 선언하는 두 가지 방법
* 일단 Entity 클래스 레벨에 @SecondaryTable 선언한다.
* 복수개의 테이블을 사용하는 경우 @SecondaryTables를 사용한다.
* 
* 
* 해당 필드를 @SecondTable 지정해야한다.
* 1. @Embeddable클래스 하위 @Column(table)에 @SecondaryTable을 명시
* 2. Entity 클래스 하위 @Embdded 필드에 @AttributeOverride(column= @Column(table))에 @SecondaryTable을 명시
* */

@Entity
@Table(name="tbl_writer")
@SecondaryTables({
        @SecondaryTable(
                name="tbl_writer_info",
                // @PrimaryKeyJoinColumn(name="tbl_writer_info.pk컬럼명", referenceColumnName="tbl_writer.id컬럼명")
                pkJoinColumns = @PrimaryKeyJoinColumn(name="writer_id", referencedColumnName = "id")
        ),
        @SecondaryTable(
                name = "tbl_writer_address",
                // @PrimaryKeyJoinColumn(referenceColumnName) 생략 가능하다.
                pkJoinColumns = @PrimaryKeyJoinColumn(name="writer_id")
        )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private WriterInfo writerInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="address1", column = @Column(name="addr1", table="tbl_writer_address")),
            @AttributeOverride(name="address2", column = @Column(name="addr2", table="tbl_writer_address")),
            @AttributeOverride(name="zipCode", column = @Column(name="zip_code", table="tbl_writer_address"))
    })
    private Address address;
}
