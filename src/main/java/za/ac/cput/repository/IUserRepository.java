package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.impl.User;
/*
* Author: Peter Buckingham (220169289)
* Date: 23 June 2023
* File: IBookRepository.java
* */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    // Add additional methods as we need them
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
    public User findByEmailAndIdNot(String email, int id);


}
