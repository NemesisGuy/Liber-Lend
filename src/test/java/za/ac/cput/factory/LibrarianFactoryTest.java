package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.impl.Librarian;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianFactoryTest {

    @Test
    void LibrarianFactoryTest() {

        LibrarianFactory librarianFactory = new LibrarianFactory();
        Librarian librarian = librarianFactory.create();

        assertNotNull(librarian);
        assertNotNull(librarian.getId());


    }

}