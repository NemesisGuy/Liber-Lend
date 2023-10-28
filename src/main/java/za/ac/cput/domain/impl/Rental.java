package za.ac.cput.domain.impl;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import za.ac.cput.domain.security.User;

import java.time.LocalDateTime;

/**
 * Author: Peter Buckingham (220165289)
 * Date: April 2023
 * Rental Class.java
 */


@Entity
public class Rental {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private Double fine;
    private LocalDateTime issuedDate;
    private LocalDateTime returnedDate;
    //Initializing a parameterized constructor
    public Rental(int id, User user, Book book, Double fine, LocalDateTime issuedDate, LocalDateTime returnedDate) {

        this.id = id;
        this.user = user;
        this.book = book;
        this.issuedDate = issuedDate;
        this.returnedDate = returnedDate;
        this.fine = fine;
    }

    private Rental(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
       this.book = builder.book;
        this.issuedDate = builder.issuedDate;
        this.returnedDate = builder.returnedDate;
        this.fine = builder.fine;

    }

    public Rental() {

    }

    //Builder Class
    public static Builder builder() {
        return new Builder();
    }

    public int getRentalId() {
        return this.id;
    }
    public int getId() {
        return this.id;
    }

    public Double getFine() {
        return fine;
    }
    public LocalDateTime getIssuedDate() {
        return issuedDate;
    }

    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }

    public boolean finePaid() {
        return false;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", issuedDate='" + issuedDate + '\'' +
                ", dateReturned='" + returnedDate + '\'' +
                ", finePaid=" + fine +
                '}';
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return this.book;

    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static class Builder {

        private int id;
        private User user;
        private Book book;
        private Double fine;

        private LocalDateTime issuedDate;
        private LocalDateTime returnedDate;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }
        public Builder setUser(User user) {
            this.user = user;
            return this;
        }
        public Builder setBook(Book book) {
            this.book = book;
            return this;
        }

        public Builder setIssuedDate(LocalDateTime issuedDate) {
            this.issuedDate = issuedDate;
            return this;
        }

        public Builder setDateReturned(LocalDateTime returnedDate) {
            this.returnedDate = returnedDate;
            return this;
        }


        public Builder setFine(Double fine) {
            this.fine = fine;
            return this;
        }

        public Rental build() {
            return new Rental(this);
        }

        public Builder copy(Rental rental) {
            this.id = rental.id;
            this.user = rental.user;
            this.book = rental.book;
            this.issuedDate = rental.issuedDate;
            this.returnedDate = rental.returnedDate;
            this.fine = rental.fine;
            return this;
        }
    }
}