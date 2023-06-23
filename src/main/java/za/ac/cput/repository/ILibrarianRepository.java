package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.impl.Librarian;

public interface ILibrarianRepository extends JpaRepository<Librarian, Integer> {
}
