package com.example.Spring_Boot_JPA.mappers.impl;

import com.example.Spring_Boot_JPA.bo.BookBo;
import com.example.Spring_Boot_JPA.entity.Book;
import com.example.Spring_Boot_JPA.mappers.BoEntityMapperIface;
import org.springframework.stereotype.Service;

@Service
public class BookBoEntityMapper
        implements BoEntityMapperIface<BookBo, Book> {

    @Override
    public BookBo toBo(Book book) {
        return BookBo.builder()
                .id(book.getId())
                .name(book.getName())
                .build();
    }

    @Override
    public Book toEntity(BookBo bookBo) {
        return Book.builder()
                .id(bookBo.getId())
                .name(bookBo.getName())
                .build();
    }
}
