package com.example.Spring_Boot_JPA.serviceInterface;

import com.example.Spring_Boot_JPA.bo.BookBo;

import java.util.List;

public interface DataManagerBook {

    List<BookBo> getAllBooks();

    BookBo getBook(String id);

    void addBook(BookBo bookBo);

    void updateBook(BookBo bookBo, String id);

    void deleteBook(String id);
}
