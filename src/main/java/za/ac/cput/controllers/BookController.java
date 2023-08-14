package za.ac.cput.controllers;
/**
 * CarController.java
 * This is the controller for the Car class
 * Author: Peter Buckingham (220165289)
 * Date: 05 April 2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.impl.Book;
import za.ac.cput.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;


@RestController


//set url
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/api/books/all")
    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<>(bookService.getAll());
        return allBooks;
    }


   /* @GetMapping("/api/cars/economy")
    public List<Book> getEconomyCars() {
        List<Book> economyCars = new ArrayList<>(bookService.getAll());
        economyCars.removeIf(car -> car.getPriceGroup() != PriceGroup.ECONOMY);
        return economyCars;
    }

    @GetMapping("/api/cars/luxury")
    public List<Book> getLuxuryCars() {
        List<Book> luxuryCars = new ArrayList<>(bookService.getAll());
        luxuryCars.removeIf(car -> car.getPriceGroup() != PriceGroup.LUXURY);
        return luxuryCars;
    }

    @GetMapping("/api/cars/special")
    public List<Book> getSpecialCars() {
        List<Book> specialCars = new ArrayList<>(bookService.getAll());
        specialCars.removeIf(car -> car.getPriceGroup() != PriceGroup.SPECIAL);
        return specialCars;
    }*/


}
