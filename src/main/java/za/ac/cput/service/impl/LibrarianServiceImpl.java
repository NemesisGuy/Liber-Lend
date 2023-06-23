package za.ac.cput.service.impl;

import za.ac.cput.domain.impl.Librarian;
import za.ac.cput.repository.ILibrarianRepository;
import za.ac.cput.service.ILibrarianService;

import java.util.List;

public class LibrarianServiceImpl implements ILibrarianService {

    private ILibrarianRepository repository;
    private LibrarianServiceImpl(ILibrarianRepository repository) {
        this.repository = repository;


    }
    @Override
    public Librarian create(Librarian librarian) {
        return this.repository.save(librarian);
    }


    @Override
    public Librarian update(Librarian librarian) {

        if(this.repository.existsById(librarian.getId()))
            return this.repository.save(librarian);
        return null;
    }

    @Override
    public boolean delete(Integer id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Librarian> getAll() {

        return this.repository.findAll();
    }
}
