package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.impl.Book;
import za.ac.cput.factory.BookFactory;
import za.ac.cput.repository.IBookRepository;
import za.ac.cput.service.IBookService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
/*
* Author: Peter Buckingham (220169289)
* Date: 23 June 2023
* File: BookServiceImpl.java
* */
@Service("bookServiceImpl")
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository repository ;
    @Autowired
    private BookFactory bookFactory;




    private BookServiceImpl(IBookRepository repository) {

        this.repository = repository;
    }


    @Override
    public Book create(Book book) {
        return this.repository.save(book);

    }

    @Override
    public Book read(Integer integer) {

        return (Book) this.repository.findAllById(Collections.singleton(integer));

    }

    @Override
    public Book read(int id) {
        Optional<Book> optionalBook = this.repository.findById(id);
        return optionalBook.orElse(null);
    }


    @Override
    public Book update(Book book) {
        if (this.repository.existsById(book.getId()))
            return this.repository.save(book);
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (this.repository.existsById( id)) {
            this.repository.deleteById( id);
            return true;
        }
        return false;
    }

    public boolean delete(Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Book> getAll() {
        return (ArrayList<Book>) this.repository.findAll();
    }


    ///////////


}
