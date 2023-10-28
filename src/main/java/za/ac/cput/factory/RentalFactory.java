package za.ac.cput.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.domain.impl.Book;
import za.ac.cput.domain.impl.Rental;
import za.ac.cput.domain.security.User;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class RentalFactory {

    public static Rental createRental(int rentalId, Book book, User user, LocalDateTime issuedDate, LocalDateTime returnedDate, Double fine) {
        return Rental.builder()
                .setId(rentalId)            // Use setId instead of rentalId
                .setBook(book)
                .setUser(user)
                .setIssuedDate(issuedDate)
                .setDateReturned(returnedDate) // Use setDateReturned instead of returnedDate
                .setFine(fine)
                .build();
    }
    public static Rental createRental(Book book, User user, LocalDateTime issuedDate, LocalDateTime returnedDate, Double fine) {
        return Rental.builder()
                .setBook(book)
                .setUser(user)
                .setIssuedDate(issuedDate)
                .setDateReturned(returnedDate) // Use setDateReturned instead of returnedDate
                .setFine(fine)
                .build();
    }
    public static Rental createRental(Rental rental) {
        System.out.println("RentalFactory.createRental: " + rental);
        return Rental.builder()
                .setId(rental.getId())
                .setBook(rental.getBook())
                .setUser(rental.getUser())
                .setIssuedDate(rental.getIssuedDate())
                .setDateReturned(rental.getReturnedDate())
                .setFine(rental.getFine())
                .build();

    }

//    public Rental create(Rental rental) {
//        return Rental.builder().build();
//    }

    public static Rental createRental() {
        return Rental.builder().build();
    }


}
