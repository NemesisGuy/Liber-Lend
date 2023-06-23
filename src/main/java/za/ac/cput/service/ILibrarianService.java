package za.ac.cput.service;

import za.ac.cput.domain.impl.Librarian;

import java.util.List;

public interface ILibrarianService {

    Librarian create(Librarian librarian);

    Librarian update(Librarian librarian);
    boolean delete(Integer id);
    List<Librarian> getAll();
}
