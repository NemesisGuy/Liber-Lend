package za.ac.cput.controllers.admin;
/**
 *
 * AdminUserController.java
 * This is the controller for the user entity
 * Author: Peter Buckingham (220165289)
 * Date: 05 April 2023
 */




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.security.Role;
import za.ac.cput.domain.security.User;
import za.ac.cput.exception.RoleNotFoundException;
import za.ac.cput.repository.IRoleRepository;
import za.ac.cput.service.impl.UserService;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/admin/users")
public class AdminUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private IRoleRepository roleRepository;


    @GetMapping("/list/all")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.read(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        List<Role> roles = roleRepository.findAll();
        List<Role> matchingRoles = new ArrayList<>();

        for (Role userRole : user.getRoles()) {
            for (Role dbRole : roles) {
                if (dbRole.getRoleName().equals(userRole.getRoleName())) {
                    matchingRoles.add(dbRole);
                    break;
                }
            }
        }
        if (matchingRoles.isEmpty()) {
            throw new RoleNotFoundException("Desired role(s) not found");
        }

        user.setRoles(matchingRoles);
        return userService.create(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        User existingUser = userService.read(id);

        if (existingUser != null) {
            // Update the user fields
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());

            // Get all roles from the database
            List<Role> dbRoles = roleRepository.findAll();

            List<Role> matchingRoles = new ArrayList<>();

            for (Role userRole : updatedUser.getRoles()) {
                for (Role dbRole : dbRoles) {
                    if (dbRole.getRoleName().equals(userRole.getRoleName())) {
                        matchingRoles.add(dbRole);
                        break;
                    }
                }
            }

            // If there are any matching roles, update the user's roles
            if (!matchingRoles.isEmpty()) {
                existingUser.setRoles(matchingRoles);
            } else {
                throw new RoleNotFoundException("Desired role(s) not found");
            }

            // Save the updated user
            existingUser = userService.update(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            // User not found
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        boolean deleted = userService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}



