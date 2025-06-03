package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    // 의존성 주입이 옵션으로 수행될 수 있도록 처리하는데 유용하게 사용된다.
    @Autowired(required = false)
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }

    public BookDTO selectBookBySequence(int sequence){
        return bookDAO.selectOneBook(sequence);
    }
}
