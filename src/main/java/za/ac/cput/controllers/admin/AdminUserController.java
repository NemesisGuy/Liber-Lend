package za.ac.cput.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.impl.User;
import za.ac.cput.service.impl.UserServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping ("/all")
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>(userService.getAll());
        return users;
    }
    @PostMapping("/create")
public User createUser(@RequestBody User user) {
        System.out.println("/api/admin/users/create was triggered");
        System.out.println("UserService was created...attempting to create user...");
        User createdUser = userService.create(user);
        return createdUser;
    }
    @GetMapping("/read/{userId}")
    public User readUser(@PathVariable Integer userId) {
        System.out.println(" was triggered");
        System.out.println("UserService was created...attempting to read user...");
        User readUser = userService.read(userId);
        return readUser;
    }
/* @GetMapping("/read/{userId}")
 public User readUser(@PathVariable Integer userId) {
     System.out.println(" was triggered");
     System.out.println("UserService was created...attempting to read user...");
     List<User> userList = (List<User>) userService.read(userId);
     if (!userList.isEmpty()) {
         return userList.get(0); // Return the first User object from the list
     } else {
         // Handle the case when the list is empty (no user found)
         return null; // Or throw an exception, or return an appropriate response
     }
 }

    public Book read(@PathVariable int id) {
        System.out.println("ID: " + id);
        Book readBook = bookService.read(id);
        return readBook;
    }*/



    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        User updated = userService.update(updatedUser);
        return updated;
    }

    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable Integer userId) {
        System.out.println("/api/admin/users/delete was triggered");
        System.out.println("UserService was created...attempting to delete user...");
        return userService.delete(userId);
    }


}
//.delete(`http://localhost:8080/api/admin/cars/delete/${carId}`)