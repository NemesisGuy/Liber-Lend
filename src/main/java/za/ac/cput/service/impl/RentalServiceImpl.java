package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.impl.Book;
import za.ac.cput.domain.impl.Rental;

import za.ac.cput.domain.security.User;
import za.ac.cput.exception.BookNotAvailableException;
import za.ac.cput.exception.UserCantRentMoreThanOneBookException;
import za.ac.cput.factory.RentalFactory;
import za.ac.cput.repository.IRentalRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("rentalServiceImpl")
public class RentalServiceImpl {
    @Autowired
    private IRentalRepository repository;

    @Autowired
    private RentalFactory rentalFactory;

    private RentalServiceImpl(IRentalRepository repository) {
        this.repository = repository;
    }


    public Rental create(Rental rental) {
        if (isBookAvailable(rental)) {
            if (isCurrentlyRenting(rental.getUser())) {
                System.out.println("User is currently renting a book");
                throw new UserCantRentMoreThanOneBookException(rental.getUser().getFirstName() + " " + rental.getUser().getLastName() + " is currently renting " + getCurrentRental(rental.getUser()).getBook().getTitle() + " by " + getCurrentRental(rental.getUser()).getBook().getAuthor());
            }
            Rental newRental = rentalFactory.createRental(rental);
            return repository.save(newRental);
        } else {
            throw new BookNotAvailableException(rental.getBook().getTitle() + ", is not available for rental at this time!");
        }
    }


    public Rental read(Integer integer) {
        return this.repository.findById(integer).orElse(null);
    }


    public Rental read(int id) {
        return this.repository.findById(id).orElse(null);
    }


    public Rental update(Rental rental) {
        System.out.println("IRentalServiceImpl.update : ");
        System.out.println("rental Id received : " + rental.getRentalId());

        if (repository.existsById(rental.getRentalId())) {

            System.out.println("Rental " + rental.getRentalId() + " found");
            System.out.println(rental);
            Rental updatedRental = rentalFactory.createRental(rental);
            return repository.save(updatedRental);
        }
        System.out.println("Rental " + rental.getRentalId() + " not found");
        return null;
    }


    public boolean delete(Integer integer) {

        if (this.repository.existsById(integer)) {
            this.repository.deleteById(integer);
            return true;
        }
        return false;
    }


    public boolean delete(int id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }


    public ArrayList<Rental> getAll() {

        return (ArrayList<Rental>) this.repository.findAll();
    }
    //get all available books

    public ArrayList<Rental> getAllAvailableBooks() {
        ArrayList<Rental> availableBooks = new ArrayList<>();

        // Retrieve all rentals from the repository
        List<Rental> allRentals = repository.findAll();

        // Iterate over each rental to check if the book is available
        for (Rental rental : allRentals) {
            if (isBookAvailable(rental)) {
                availableBooks.add(rental);
            }
        }
        return availableBooks;

    }

    private boolean isBookAvailable(Rental rental) {
        Book bookToRent = rental.getBook();
        //find rental by book id
        Optional<Rental> rentalByBookIdOrderByReturnedDateDesc = repository.findTopByBookIdOrderByReturnedDateDesc(bookToRent.getId());
        //put output in a rental object if found
        Rental rentalFromDatabase = rentalByBookIdOrderByReturnedDateDesc.orElse(null);
        if (rentalFromDatabase != null) {
            //if rental is not null then book has been rented before
            System.out.println("RentalFromDatabase Rental Return Date : " + rentalFromDatabase.getReturnedDate());
            System.out.println("Rental Taken Date : " + rental.getIssuedDate());
        }else {
            //if rental rentalFromDatabase is null then book has not been rented before

           // System.out.println(rentalFromDatabase.getBook().getTitle() +  "'s return date is null, as it has not been rented yet");
            System.out.println(rental.getBook().getTitle() +  " has not been rented yet");
            // throw new BookNotAvailableException(rentalFromDatabase.getBook().getTitle() + ", has not been rented yet!");

        }
            //if most recent rental is returned is 24hours before new rental then book is available, if the most recent rental has not been returned or is null then book is not available
        if (rentalFromDatabase != null && rentalFromDatabase.getReturnedDate() != null && rental.getIssuedDate() != null) {
            if (rental.getReturnedDate() != null) {
                LocalDateTime timeSinceLastRental = rental.getReturnedDate().minusDays(rentalFromDatabase.getReturnedDate().getDayOfMonth());
                System.out.println("Rental Date - rentalFromDatabase : " + rentalFromDatabase.getReturnedDate());
                System.out.println("Rental Date - rentalFromDatabase : " + timeSinceLastRental);
            }
            //if most recent rental is returned is 24hours before new rental then book is available, if the most recent rental has not been returned or is null then book is not available
        } else if (rentalFromDatabase != null && rentalFromDatabase.getReturnedDate() == null && rental.getIssuedDate() != null){
            System.out.println(rentalFromDatabase.getBook().getTitle() + " has not been returned yet");
            //time since date issue till now if book has not been returned yet(current date - date issued)
            LocalDateTime timeSinceLastRental = LocalDateTime.now().minusDays(rentalFromDatabase.getIssuedDate().getDayOfMonth());
            System.out.println(rentalFromDatabase.getBook().getTitle() + " was issued on : " + rentalFromDatabase.getIssuedDate().getDayOfMonth()+ " and has been rented for " + timeSinceLastRental.getDayOfMonth() + " days");
            throw new BookNotAvailableException(rentalFromDatabase.getBook().getTitle() + ", has not been returned yet!");
        }else {
            //the book has not been rented yet
            System.out.println(rental.getBook().getTitle() +  " has not been rented yet");
        }

        //if most recent rental is returned is 24hours before new rental then book is available, if the most recent rental has not been returned or is null then book is not available
        if (rentalFromDatabase == null) { //if no rental has been made
            return true; //book is available
        } else if (rentalFromDatabase.getReturnedDate() == null) { //if most recent rental has not been returned
            return false; //book is not available
        } else
            return rentalByBookIdOrderByReturnedDateDesc.get().getReturnedDate().plusDays(1).isBefore(rental.getIssuedDate());

    }

    public boolean isBookAvailableByBookId(Book book) {
        // Find rental by book id
        Optional<Rental> rentalByBookIdOrderByReturnedDateDesc = repository.findTopByBookIdOrderByReturnedDateDesc(book.getId());

        // Put output in a rental object if found
        Rental rentalFromDatabase = rentalByBookIdOrderByReturnedDateDesc.orElse(null);

        // If a rental was found
        if (rentalFromDatabase != null) {
            // If the rental was returned, then the book is available
            if (rentalFromDatabase.getReturnedDate() != null) {
                LocalDateTime timeSinceLastRental = rentalFromDatabase.getReturnedDate().minusDays(rentalFromDatabase.getReturnedDate().getDayOfMonth());
                System.out.println("RentalFromDatabase Rental, Rental was returned on:  " + rentalFromDatabase.getReturnedDate());
                /* System.out.println("Rental Date - rentalFromDatabase: " + timeSinceLastRental);*/
                System.out.println("Book is available");
                // If the rental was not returned, then the book is not available
            } else {
                System.out.println("The book has not been returned yet");
                // Time since date issued till now if book has not been returned yet (current date - date issued)
                LocalDateTime timeSinceLastRental = LocalDateTime.now().minusDays(rentalFromDatabase.getIssuedDate().getDayOfMonth());
                System.out.println("Rental Date - rentalFromDatabase: " + rentalFromDatabase.getIssuedDate().getDayOfMonth());
                System.out.println("Book is not available");
            }

            // If the most recent rental is returned 24 hours before the new rental, then the book is available
            return rentalFromDatabase.getReturnedDate().plusDays(1).isBefore(LocalDateTime.now());
        }

        // If no rental has been made or the most recent rental has not been returned, the book is not available
        return false;
    }

    public boolean isCurrentlyRenting(User user) {
        // Find active rentals for the user
        List<Rental> activeRentals = repository.findByUserIdAndReturnedDateIsNull(user.getId());

        // If the user has any active rentals, they are currently renting a book
        return !activeRentals.isEmpty();
    }

    public Rental getCurrentRental(User user) {
        // Find active rentals for the user
        List<Rental> activeRentals = repository.findByUserIdAndReturnedDateIsNull(user.getId());

        // If the user has any active rentals, they are currently renting a book
        if (!activeRentals.isEmpty()) {
            return activeRentals.get(0);
        }

        return null;
    }


}

