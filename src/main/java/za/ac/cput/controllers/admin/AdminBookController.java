package za.ac.cput.controllers.admin;
/**
 * CarController.java
 * This is the controller for the Car class
 * Author: Peter Buckingham (220165289)
 * Date: 05 April 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.impl.Book;
import za.ac.cput.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;


@RestController


//set url
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/admin/books")
public class AdminBookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/api/books/all")
    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<>(bookService.getAll());
        return allBooks;
    }
    @PostMapping("/api/books/create")
    public Book create(@RequestBody Book bookCreationRequest) {
        // Extract the registration details from the request object
        String title = bookCreationRequest.getTitle();
        String author = bookCreationRequest.getAuthor();
        String publisher = bookCreationRequest.getPublisher();
        String genre = bookCreationRequest.getGenre();
        int edition = bookCreationRequest.getEdition();
        String description = bookCreationRequest.getDescription();
        System.out.println("Title: " + title);
        System.out.println("This book is now created");
        Book createdBook = bookService.create(bookCreationRequest);
        return createdBook;


    }
    @PutMapping("/api/books/update/{id}")
    public Book update(@RequestBody Book bookUpdateRequest) {
        // Extract the registration details from the request object
    /*    String title = bookUpdateRequest.getTitle();
        String author = bookUpdateRequest.getAuthor();
        String publisher = bookUpdateRequest.getPublisher();
        String genre = bookUpdateRequest.getGenre();
        int edition = bookUpdateRequest.getEdition();
        String description = bookUpdateRequest.getDescription();
        System.out.println("Title: " + title);
       */
        Book updatedBook = bookService.update(bookUpdateRequest);
        System.out.println("This book is now updated");
 //       Book updatedBook = bookService.update(bookUpdateRequest);
        return updatedBook;
    }
    @DeleteMapping("/api/books/delete/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("ID: " + id);
        bookService.delete(id);
        System.out.println("This book is now deleted");
    }
    @GetMapping("/api/books/read/{id}")
    public Book read(@PathVariable int id) {
        System.out.println("ID: " + id);
        Book readBook = bookService.read(id);
        return readBook;
    }




}
