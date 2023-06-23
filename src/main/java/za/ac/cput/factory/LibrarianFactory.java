package za.ac.cput.factory;

import za.ac.cput.domain.impl.Contacts;
import za.ac.cput.domain.impl.Librarian;

import java.util.List;
import java.util.Random;

public class LibrarianFactory implements IFactory<Librarian>{


    @Override
    public Librarian create() {
        return new Librarian.Builder().build();
    }

    @Override
    public Librarian getById(long id) {
        return null;
    }

    @Override
    public Librarian update(Librarian entity) {
        return null;
    }

    @Override
    public boolean delete(Librarian entity) {
        return false;
    }

    @Override
    public List<Librarian> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Class<Librarian> getType() {
        return null;
    }

    public static Librarian createLibrarian(String firstName, String lastName, Contacts contacts, String office, String role) {
        return new Librarian.Builder()
                .setId(new Random().nextInt())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContacts(contacts)
                .setOffice(office)
                .setRole(role)
                .build();
    }

}
