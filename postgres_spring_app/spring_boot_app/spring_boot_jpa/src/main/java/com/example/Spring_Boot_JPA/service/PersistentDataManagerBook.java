package com.example.Spring_Boot_JPA.service;

import com.example.Spring_Boot_JPA.bo.BookBo;
import com.example.Spring_Boot_JPA.mappers.impl.BookBoEntityMapper;
import com.example.Spring_Boot_JPA.repository.BookRepository;
import com.example.Spring_Boot_JPA.serviceInterface.DataManagerBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersistentDataManagerBook implements DataManagerBook {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookBoEntityMapper bookBoEntityMapper;

    public List<BookBo> getAllBooks() {
        return this.bookRepository.findAll().stream().map(e -> this.bookBoEntityMapper.toBo(e)).collect(Collectors.toList());
    }

    public BookBo getBook(String id) {
        return this.bookBoEntityMapper.toBo(this.bookRepository.findOne(id));
    }

    public void addBook(BookBo bookBo) {
        this.bookRepository.save(this.bookBoEntityMapper.toEntity(bookBo));
    }

    public void updateBook(BookBo bookBo, String id) {
        this.bookRepository.delete(id);
        this.bookRepository.save(this.bookBoEntityMapper.toEntity(bookBo));
    }

    public void deleteBook(String id) {
        this.bookRepository.delete(id);
    }
}
