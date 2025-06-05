package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tbl_book")
public class Book {
    @Id
    @Column(name="book_no")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookNo;
    @Column(name="book_title")
    private String bookTitle;
    @Column(name="author")
    private String author;
    @Column(name="publisher")
    private String publishelr;
    @Column(name="published_date")
    private LocalDate publishedDate;
    @Embedded
    private Price price;

    protected Book() {}

    public Book(String bookTitle, String author, String publishelr, LocalDate publishedDate, Price price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publishelr = publishelr;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNo=" + bookNo +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publishelr='" + publishelr + '\'' +
                ", publishedDate=" + publishedDate +
                ", price=" + price +
                '}';
    }
}
