package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    // 생성자 주입
    private final BookDAO bookDAO;

    // public BookService() {}
    /* Spring 4.3 버전 이후부터 생성자가 1개 뿐이라면 어노테이션을 생략해도
    * 자동으로 생성자 주입이 동작한다. 단, 생성자가 1개 이상이라면 명시적으로 작성해야 한다.
    * */

    @Autowired  // 생성자 주입
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO selectBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
