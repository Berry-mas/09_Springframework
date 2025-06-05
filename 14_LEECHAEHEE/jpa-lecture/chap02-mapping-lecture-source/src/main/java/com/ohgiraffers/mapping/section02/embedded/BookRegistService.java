package com.ohgiraffers.mapping.section02.embedded;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookRegistService {

    private BookRepository bookRepository;

    public BookRegistService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void registeBook(BookRegistDTO newBook){

        Book book = new Book(
                newBook.getBookTitle(),
                newBook.getAuthor(),
                newBook.getPublisher(),
                newBook.getPublishedDate(),
                new Price(
                        newBook.getRegularPrice(),
                        newBook.getDiscountRate()
                )
        );
        // 저장
        bookRepository.save(book);
    }
}
