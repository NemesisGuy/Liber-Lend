package za.ac.cput.repository;

/*
* Author: Peter Buckingham (220169289)
* Date: 23 August 2021
* File : IRentalRepository.java
* */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.impl.Rental;

import java.util.List;
import java.util.Optional;
@Repository
public interface IRentalRepository extends JpaRepository<Rental, Integer> {
    Optional<Rental> findAllById(int id);
    Optional<Rental> findTopByIdOrderByReturnedDateDesc(int id);
    Optional<Rental> findTopByBookIdOrderByReturnedDateDesc(int id);
    List<Rental> findByUserIdAndReturnedDateIsNull(int id);


}
